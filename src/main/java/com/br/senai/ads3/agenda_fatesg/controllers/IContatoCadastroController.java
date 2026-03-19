package com.br.senai.ads3.agenda_fatesg.controllers;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.dtos.Response;

public interface IContatoCadastroController {
    Response criar(Contato dto);
    Response alterar(String originalName, Contato dto);
}