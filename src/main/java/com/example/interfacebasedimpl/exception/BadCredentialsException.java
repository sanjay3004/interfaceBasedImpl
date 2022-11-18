package com.example.interfacebasedimpl.exception;

public class BadCredentialsException extends RuntimeException{

    public BadCredentialsException(String message) {
        super(message);
    }
}
