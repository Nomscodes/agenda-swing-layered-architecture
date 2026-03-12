/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.senai.ads3.agenda_fatesg.services;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.repositories.ContatoRepository;
import com.br.senai.ads3.agenda_fatesg.repositories.IContatoRepository;
import com.br.senai.ads3.agenda_fatesg.validations.ContatoValidation;
import com.br.senai.ads3.agenda_fatesg.validations.IContatoValidation;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CLAYTON.MARQUES
 */
public class ContatoService implements IContatoService {

    private final IContatoRepository repository;
    private final IContatoValidation validation;

    public ContatoService() {
        this.repository = new ContatoRepository();
        this.validation = new ContatoValidation(this.repository);
    }

    public ContatoService(Path storage) {
        this.repository = new ContatoRepository(storage);
        this.validation = new ContatoValidation(this.repository);
    }

    @Override
    public boolean inserir(Contato contato) throws Exception {
        this.validation.validaCampo(contato);
        this.validation.validaRegraInserir(contato);
        return this.repository.inserir(contato);        
    }

    @Override
    public boolean alterar(Contato contato) throws Exception {
        this.validation.validaCampo(contato);
        this.validation.validaRegraAlterar(contato);
        return this.repository.alterar(contato);
    }

    @Override
    public boolean excluir(Contato contato) throws Exception {
        if (this.contatoExiste(contato)) {
            return this.repository.desativar(contato);
        } else {
            throw new Exception("Este contato já existe cadastrado");
        }
    }
    
    @Override
    public boolean excluir(String nome) throws Exception {
        Contato contato = this.buscarPorNome(nome);
        if(contato != null){
            return excluir(contato);
        }
        return false;
    }
    
    @Override
    public List<Contato> listarPorNome(String name) throws Exception {
        List<Contato> all = this.buscarTodos();
        List<Contato> filtered = new ArrayList<>();
        for (Contato c : all) {
            if (c.getNome() != null && c.getNome().toLowerCase().contains(name.toLowerCase())) {
                filtered.add(c);
            }
        }
        return filtered;
    }
    
    @Override
    public Contato buscarPorNome(String name) throws Exception {
        List<Contato> all = this.buscarTodos();
        for (Contato c : all) {
            if (c.getNome() != null && c.getNome().toLowerCase().contains(name.toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Contato> buscarTodos() throws Exception {
        return this.repository.buscarTodos();
    }
    
    @Override
    public List<Contato> buscarTodosAtivos() throws Exception {
        return this.repository.buscarTodos(true);
    }
    
    @Override
    public List<Contato> buscarTodosInativos() throws Exception {
        return this.repository.buscarTodos(false);
    }

    @Override
    public boolean contatoExiste(Contato contato) throws Exception {
        return this.repository.contatoExiste(contato);
    }

    @Override
    public boolean reativaContato(Contato contato) throws Exception {
        return this.repository.reativar(contato);
    }

    private void validate(Contato dto) throws Exception {
        if (dto == null) {
            throw new Exception("Contato inválido");
        }
        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório");
        }
    }

}
