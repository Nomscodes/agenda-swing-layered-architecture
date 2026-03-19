package com.br.senai.ads3.agenda_fatesg.controllers;

import com.br.senai.ads3.agenda_fatesg.dtos.Response;

public interface IContatoListaController {
    Response listarTodos();
    Response listarTodosAtivos();
    Response listaTodosInativos();
    Response inativarPorNome(String name);
    Response buscarPorNome(String name);
}