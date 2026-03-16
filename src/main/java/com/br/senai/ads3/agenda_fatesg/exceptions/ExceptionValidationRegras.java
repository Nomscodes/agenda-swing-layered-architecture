package com.br.senai.ads3.agenda_fatesg.exceptions;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
/**
 *
 * @author wylian
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionValidationRegras extends CoreException {
    private String regra; 
}
