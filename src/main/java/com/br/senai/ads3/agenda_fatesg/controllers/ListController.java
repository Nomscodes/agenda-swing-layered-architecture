package com.br.senai.ads3.agenda_fatesg.controllers;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.exceptions.BusinessException;
import java.util.List;

public interface ListController {
    List listAll();
    boolean markInactiveByName(String name) throws BusinessException;
    List findByName(String name);
}