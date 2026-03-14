package com.br.senai.ads3.agenda_fatesg.validation;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.repositories.IContatoRepository;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Caio4breu
 */
public class ContatoValidation implements IContatoValidation {
    
    private static final String emailRegex = "^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$";
    private static final String telefoneRegex = "^\\(?\\d{2}\\)?[\\s-]?\\d{4,5}-?\\d{4}$";
    private final IContatoRepository repository;
    
    public ContatoValidation (IContatoRepository repository){
        this.repository = repository;
    }

    @Override
    public void validarCampos(Contato contato) throws ExceptionValidationCampo {
        if (contato.getNome() == null || contato.getNome().isEmpty()) {
            throw new RuntimeException("Nome obrigatorio");
        }
        if (contato.getEmail() == null || contato.getEmail().isEmpty()) {
            throw new RuntimeException("Email obrigatorio");
        }
        if (contato.getNome().length() < 2){
            throw new RuntimeException("Nome curto demais");
        }
        if (contato.getTelefone() == null || contato.getTelefone().isEmpty()) {
            throw new RuntimeException("Telefone obrigatorio");
        }
        if (!contato.getEmail().matches(emailRegex)){
            throw new RuntimeException("E-mail inválido: " + contato.getEmail());
        }
        if (!contato.getTelefone().matches(telefoneRegex)){
            throw new RuntimeException("Telefone inválido: " + contato.getEmail());
        }
    }

    @Override
    public void validaRegraInserir(Contato contato) throws ExceptionValidationCampo {
        try {
            if (this.repository.contatoExiste(contato)){
                throw new RuntimeException("Contato já existente: " + contato.getNome());
            }
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void validaRegraAtivar(Contato contato) throws ExceptionValidationCampo {
        try {
            List<Contato> inativos = this.repository.buscarTodos(false);
            boolean estaInativo = false;
            for (Contato c: inativos) {
                if (c.getNome().equalsIgnoreCase(contato.getNome())) {
                    estaInativo = true;
                    break;
                }
            }
            if (!estaInativo) {
                throw new RuntimeException("Contato já está ativo: " + contato.getNome());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void validaRegraInativar(Contato contato) throws ExceptionValidationCampo {
        try {
            List<Contato> inativos = this.repository.buscarTodos(true);
            boolean estaInativo = false;
            for (Contato c: inativos) {
                if (c.getNome().equalsIgnoreCase(contato.getNome())) {
                    estaInativo = true;
                    break;
                }
            }
            if (!estaInativo) {
                throw new RuntimeException("Contato já está inativo: " + contato.getNome());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void validarRegrasAlterar(Contato contato) throws ExceptionValidationCampo {
        try {
            
            List<Contato> ativos = this.repository.buscarTodos(true);
            boolean estaAtivo  = false;
            for (Contato c: ativos) {
                if (c.getNome().equalsIgnoreCase(contato.getNome())) {
                    estaAtivo  = true;
                    break;
                }
            }
            if (!estaAtivo ) {
                throw new RuntimeException("Contato já está inativo: " + contato.getNome());
            }
            
            if (!this.repository.contatoExiste(contato)){
                throw new RuntimeException("Contato não existente: " + contato.getNome());
            }
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}