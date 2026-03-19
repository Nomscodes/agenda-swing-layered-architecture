/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.br.senai.ads3.agenda_fatesg.validations;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.exceptions.ExceptionValidationCampo;
import com.br.senai.ads3.agenda_fatesg.exceptions.ExceptionValidationRegra;

/**
 *
 * @author Clayton
 */
public interface IContatoValidation {
    
    void validaCampo(final Contato contato) throws ExceptionValidationCampo;
    void validaRegraInserir(final Contato contato) throws ExceptionValidationRegra;
    void validaRegraAlterar(final Contato contato) throws ExceptionValidationRegra;
    void validaRegraAtivar(final Contato contato) throws ExceptionValidationRegra;
    void validaRegraInativar(final Contato contato) throws ExceptionValidationRegra;
    
}
