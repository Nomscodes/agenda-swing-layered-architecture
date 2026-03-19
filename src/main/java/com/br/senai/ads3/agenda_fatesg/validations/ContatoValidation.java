/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.senai.ads3.agenda_fatesg.validations;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.exceptions.CoreException;
import com.br.senai.ads3.agenda_fatesg.exceptions.ExceptionValidationCampo;
import com.br.senai.ads3.agenda_fatesg.exceptions.ExceptionValidationRegra;
import com.br.senai.ads3.agenda_fatesg.repositories.IContatoRepository;

/**
 *
 * @author Clayton
 */
public class ContatoValidation implements IContatoValidation {

    private final IContatoRepository repository;
    
    public ContatoValidation(final IContatoRepository repository){
        this.repository = repository;
    }

    /**
     *
     * @param contato
     * @throws Exception
     */
    @Override
    public void validaCampo(Contato contato) throws ExceptionValidationCampo {
        if(contato == null) {
            //thro
        }
        if(contato.getNome().length() < 5){
            
        }
    }

    @Override
    public void validaRegraInserir(Contato contato) throws ExceptionValidationRegra {
        var regra = "Não permitido a duplicação de registro.";
        try {
            if(this.repository.contatoExiste(contato)){
                throw new ExceptionValidationRegra(regra, "O contato ".concat(contato.getNome()).concat(" já está cadastrado."), "Falha ao inserir.", "");
            }
        } catch (CoreException ex) {
            throw new ExceptionValidationRegra(regra, ex.getMessage(), ex.getTitulo(), ex.getIcone());
        }
    }

    @Override
    public void validaRegraAlterar(Contato contato) throws ExceptionValidationRegra {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validaRegraAtivar(Contato contato) throws ExceptionValidationRegra {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validaRegraInativar(Contato contato) throws ExceptionValidationRegra {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
