package com.thymeleaf.suap.exception;

@SuppressWarnings("serial")
public class AcessoNegadoException extends RuntimeException{
    public AcessoNegadoException(String message) {
        super(message);
    }
}
