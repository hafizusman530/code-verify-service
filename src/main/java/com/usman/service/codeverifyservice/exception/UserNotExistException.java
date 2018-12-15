package com.usman.service.codeverifyservice.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String exception) {
        super(exception);
    }
}
