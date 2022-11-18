package com.example.interfacebasedimpl.exception;

public class UserAlreadyFound extends RuntimeException{
    public UserAlreadyFound(String message) {
        super(message);
    }
}
