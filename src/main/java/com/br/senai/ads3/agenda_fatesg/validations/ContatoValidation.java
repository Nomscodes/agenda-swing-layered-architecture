/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.senai.ads3.agenda_fatesg.validations;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
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
    @Override
    public void validaCampo(Contato contato) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validaRegraInserir(Contato contato) throws Exception {
      if(this.repository.contatoExiste(contato)){
          throw new Exception("O contato ".concat(contato.getNome()).concat(" já está cadastrado."));
      }
    }

    @Override
    public void validaRegraAlterar(Contato contato) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validaRegraAtivar(Contato contato) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validaRegraInativar(Contato contato) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
