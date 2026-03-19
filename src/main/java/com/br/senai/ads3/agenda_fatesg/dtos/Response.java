/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.senai.ads3.agenda_fatesg.dtos;

import com.br.senai.ads3.agenda_fatesg.enums.StatusResponse;
import com.br.senai.ads3.agenda_fatesg.exceptions.CoreException;
import com.br.senai.ads3.agenda_fatesg.exceptions.ExceptionValidationCampo;
import com.br.senai.ads3.agenda_fatesg.exceptions.ExceptionValidationRegra;
import lombok.Getter;

/**
 *
 * @author Clayton
 */
@Getter
public class Response {
    private final String titulo;
    private final String icone;
    private final String item;
    private final StatusResponse status;
    private final String mensagemErro;
    private final Object data;

    private Response(String titulo, String icone, String item, StatusResponse status, String mensagemErro, Object data) {
        this.titulo = titulo;
        this.icone = icone;
        this.item = item;
        this.status = status;
        this.mensagemErro = mensagemErro;
        this.data = data;
    }
    
    private Response(CoreException ex){
        this.titulo = ex.getTitulo();
        this.icone = ex.getIcone();
        this.status = StatusResponse.ERRO;
        this.mensagemErro = ex.getMessage();
        this.data = null;
        this.item = "";
    }
    
    private Response(ExceptionValidationCampo ex){
        this.titulo = ex.getTitulo();
        this.icone = ex.getIcone();
        this.status = StatusResponse.ERRO;
        this.mensagemErro = ex.getMessage();
        this.data = null;
        this.item = ex.getCampo();
    }
    
    private Response(ExceptionValidationRegra ex){
        this.titulo = ex.getTitulo();
        this.icone = ex.getIcone();
        this.status = StatusResponse.ERRO;
        this.mensagemErro = ex.getMessage();
        this.data = null;
        this.item = ex.getRegra();
    }  
    
    static public Response responseOk(Object data){
        return new Response("Sucesso.", "", "", StatusResponse.OK, "", data);
    }
    
    static public Response responseErroRegra(ExceptionValidationRegra ex) {
        return new Response(ex);
    }
    static public Response responseErroCampo(ExceptionValidationCampo ex) {
        return new Response(ex);
    }
    static public Response responseErro(CoreException ex) {
        return new Response(ex);
    }
    
}
