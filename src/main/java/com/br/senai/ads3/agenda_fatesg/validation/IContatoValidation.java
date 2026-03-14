package com.br.senai.ads3.agenda_fatesg.validation;
import com.br.senai.ads3.agenda_fatesg.domains.Contato;

/**
 *
 * @author Caio4breu
 */
public interface IContatoValidation {
    
    void validarCampos(Contato contato) throws ExceptionValidationCampo;
    void validarRegrasAlterar (Contato contato) throws ExceptionValidationCampo;
    void validaRegraInserir (final Contato contato) throws ExceptionValidationCampo;
    void validaRegraAtivar (final Contato contato) throws ExceptionValidationCampo;
    void validaRegraInativar (final Contato contato) throws ExceptionValidationCampo;
}