package com.usman.service.codeverifyservice.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String exception){
        super(exception);
    }
}
