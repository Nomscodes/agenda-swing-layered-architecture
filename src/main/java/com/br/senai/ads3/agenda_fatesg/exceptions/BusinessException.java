package com.br.senai.ads3.agenda_fatesg.exceptions;

public class BusinessException extends Exception {
    public BusinessException(String message) { super(message); }
    public BusinessException(String message, Throwable cause) { super(message, cause); }
}