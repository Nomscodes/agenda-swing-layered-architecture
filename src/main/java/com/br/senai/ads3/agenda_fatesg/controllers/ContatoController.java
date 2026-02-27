package com.br.senai.ads3.agenda_fatesg.controllers;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.exceptions.BusinessException;
import com.br.senai.ads3.agenda_fatesg.exceptions.ValidationException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContatoController implements FormController, ListController {

    private final Path storagePath;

    public ContatoController(Path storagePath) {
        this.storagePath = storagePath;
    }

    public ContatoController(String storageFilePath) {
        this(Paths.get(storageFilePath));
    }

    @Override
    public void validate(Contato dto) throws ValidationException {
        if (dto == null) {
            throw new ValidationException("Contato inválido");
        }
        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new ValidationException("Nome é obrigatório");
        }
    }

    @Override
    public Contato create(Contato dto) throws ValidationException, BusinessException {
        validate(dto);
        try {
            ensureStorage();
            List<String> lines = Files.exists(storagePath) ? Files.readAllLines(storagePath, StandardCharsets.UTF_8) : Collections.emptyList();
            for (String linha : lines) {
                String[] registro = linha.split(";");
                String nomeSalvo = registro.length > 0 ? registro[0] : "";
                String status = registro.length > 3 ? registro[3] : "ativo";
                if (nomeSalvo.equalsIgnoreCase(dto.getNome()) && "ativo".equalsIgnoreCase(status)) {
                    throw new BusinessException("Erro: O nome '" + dto.getNome() + "' já está cadastrado!");
                }
            }
            String line = toCsvLine(dto, "ativo");
            Files.write(storagePath, Collections.singleton(line), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return dto;
        } catch (IOException e) {
            throw new RuntimeException("Erro de I/O: " + e.getMessage(), e);
        }
    }

    @Override
    public Contato update(String originalName, Contato dto) throws ValidationException, BusinessException {
        validate(dto);
        try {
            ensureStorage();
            List<String> lines = Files.readAllLines(storagePath, StandardCharsets.UTF_8);
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).startsWith(originalName + ";")) {
                    String newLine = toCsvLine(dto, "ativo");
                    lines.set(i, newLine);
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new BusinessException("Registro original não encontrado: " + originalName);
            }
            Files.write(storagePath, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
            return dto;
        } catch (IOException e) {
            throw new RuntimeException("Erro de I/O: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Contato> listAll() {
        try {
            ensureStorage();
            List<String> lines = Files.readAllLines(storagePath, StandardCharsets.UTF_8);
            List<Contato> result = new ArrayList<>();
            for (String l : lines) {
                String[] d = l.split(";");
                String status = d.length > 3 ? d[3] : "ativo";
                if ("ativo".equalsIgnoreCase(status)) {
                    String nome = d.length > 0 ? d[0] : "";
                    String email = d.length > 1 ? d[1] : "";
                    String tel = d.length > 2 ? d[2] : "";
                    result.add(new Contato(nome, email, tel));
                }
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean markInactiveByName(String name) throws BusinessException {
        try {
            ensureStorage();
            List<String> lines = Files.readAllLines(storagePath, StandardCharsets.UTF_8);
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).startsWith(name + ";")) {
                    String[] r = lines.get(i).split(";");
                    String newLine = (r.length > 0 ? r[0] : "") + ";" + (r.length > 1 ? r[1] : "") + ";" + (r.length > 2 ? r[2] : "") + ";inativo";
                    lines.set(i, newLine);
                    found = true;
                    break;
                }
            }
            if (found) {
                Files.write(storagePath, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
            }
            return found;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Contato> findByName(String name) {
        List<Contato> all = listAll();
        List<Contato> filtered = new ArrayList<>();
        for (Contato c : all) {
            if (c.getNome() != null && c.getNome().toLowerCase().contains(name.toLowerCase())) {
                filtered.add(c);
            }
        }
        return filtered;
    }

    private void ensureStorage() throws IOException {
        if (!Files.exists(storagePath)) {
            Files.createFile(storagePath);
        }
    }

    private String toCsvLine(Contato c, String status) {
        String nome = c.getNome() == null ? "" : c.getNome();
        String email = c.getEmail() == null ? "" : c.getEmail();
        String tel = c.getTelefone() == null ? "" : c.getTelefone();
        return nome + ";" + email + ";" + tel + ";" + status + System.lineSeparator();
    }
}
