package com.br.senai.ads3.agenda_fatesg.controllers;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.exceptions.BusinessException;
import com.br.senai.ads3.agenda_fatesg.exceptions.ValidationException;

public interface FormController {
    Contato create(Contato dto) throws ValidationException, BusinessException;
    Contato update(String originalName, Contato dto) throws ValidationException, BusinessException;
    void validate(Contato dto) throws ValidationException;
}