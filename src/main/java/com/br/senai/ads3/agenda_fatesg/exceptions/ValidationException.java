package com.br.senai.ads3.agenda_fatesg.exceptions;

public class ValidationException extends Exception {
    public ValidationException(String message) { super(message); }
    public ValidationException(String message, Throwable cause) { super(message, cause); }
}