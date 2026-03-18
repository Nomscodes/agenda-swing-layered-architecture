package com.br.senai.ads3.agenda_fatesg.controllers;

import com.br.senai.ads3.agenda_fatesg.domains.Contato;
import com.br.senai.ads3.agenda_fatesg.dtos.Response;
import com.br.senai.ads3.agenda_fatesg.exceptions.CoreException;
import com.br.senai.ads3.agenda_fatesg.exceptions.ExceptionValidationCampo;
import com.br.senai.ads3.agenda_fatesg.exceptions.ExceptionValidationRegra;
import com.br.senai.ads3.agenda_fatesg.services.ContatoService;
import com.br.senai.ads3.agenda_fatesg.services.IContatoService;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ContatoController implements IContatoCadastroController, IContatoListaController {
    
    private final IContatoService service;

    public ContatoController() {
       this.service = new ContatoService();
    }    

    public ContatoController(Path storage) {
        this.service = new ContatoService(storage);
    }
    
    @Override
    public Response criar(Contato dto){
        try {
            if(this.service.inserir(dto)){
                return Response.responseOk(dto);
            } else {
                return Response.responseOk(null);
            }
        } catch (ExceptionValidationCampo ex) {
            return Response.responseErroCampo(ex);
        } catch (ExceptionValidationRegra ex) {
            return Response.responseErroRegra(ex);
        }
    }

    @Override
    public Response alterar(String originalName, Contato dto) {
        try {
            if(this.service.alterar(dto)){
                return Response.responseOk(dto);
            } else {
                return Response.responseOk(null);
            }
        } catch (ExceptionValidationCampo ex) {
            return Response.responseErroCampo(ex);
        } catch (ExceptionValidationRegra ex) {
            return Response.responseErroRegra(ex);
        }
    }

    @Override
    public Response listarTodos()  {
        try {
            return Response.responseOk(this.service.buscarTodos());
        } catch (CoreException ex) {
            return Response.responseErro(ex);
        }
    }
    @Override
    public Response listarTodosAtivos(){
        try {
            return Response.responseOk(this.service.buscarTodosAtivos());
        } catch (CoreException ex) {
            return Response.responseErro(ex);
        }
    }
    @Override
    public Response listaTodosInativos(){
        return this.service.buscarTodosInativos();
    }

    @Override
    public Response inativarPorNome(String name){
        return this.service.excluir(name);
    }

    @Override
    public Response buscarPorNome(String name){
        List<Contato> all = listarTodos();
        List<Contato> filtered = new ArrayList<>();
        for (Contato c : all) {
            if (c.getNome() != null && c.getNome().toLowerCase().contains(name.toLowerCase())) {
                filtered.add(c);
            }
        }
        return filtered;
    }
}
