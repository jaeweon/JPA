package com.jpa.basic.exception;

public class NoProductException extends RuntimeException{
    public NoProductException(String message) {
        super(message);
    }
}
