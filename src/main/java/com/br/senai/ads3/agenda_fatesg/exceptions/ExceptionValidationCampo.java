/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.senai.ads3.agenda_fatesg.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Clayton
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionValidationCampo extends CoreException {
    private String campo;

    public ExceptionValidationCampo(String campo, String message, String titulo, String icone) {
        super(message, titulo, icone);
        this.campo = campo;
    }
    
    
}
