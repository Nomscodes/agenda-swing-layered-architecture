/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.senai.ads3.agenda_fatesg.validation;

import com.br.senai.ads3.agenda_fatesg.exceptions.CoreException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Aluno
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionValidationCampo extends CoreException{
    private String campo;
    
}
