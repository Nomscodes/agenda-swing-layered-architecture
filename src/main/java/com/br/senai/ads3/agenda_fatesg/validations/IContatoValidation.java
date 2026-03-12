/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.br.senai.ads3.agenda_fatesg.validations;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;

/**
 *
 * @author Clayton
 */
public interface IContatoValidation {
    
    void validaCampo(final Contato contato) throws Exception;
    void validaRegraInserir(final Contato contato) throws Exception;
    void validaRegraAlterar(final Contato contato) throws Exception;
    void validaRegraAtivar(final Contato contato) throws Exception;
    void validaRegraInativar(final Contato contato) throws Exception;
    
}
