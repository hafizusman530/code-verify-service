package com.usman.service.codeverifyservice.exception;

import com.usman.service.codeverifyservice.response.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;


@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private static HttpHeaders headers = new HttpHeaders();

    static {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @ExceptionHandler({TokenNotFoundException.class})
    public ResponseEntity<Object> handleInvalidRequest(RuntimeException e, WebRequest request) {
        TokenNotFoundException tokenNotFoundException = (TokenNotFoundException) e;
        return handleExceptionInternal(e, tokenNotFoundException.getApiResponse(), headers, UNPROCESSABLE_ENTITY, request);
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<Object> handleUserNotFoundException(RuntimeException e, WebRequest request) {
        UserNotExistException userNotExistException = (UserNotExistException) e;
        return handleExceptionInternal(e, userNotExistException.getApiResponse(), headers, UNPROCESSABLE_ENTITY, request);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Object> handleUserAlreadyExistException(RuntimeException e, WebRequest request) {
        UserAlreadyExistException userAlreadyExistException = (UserAlreadyExistException) e;
        return handleExceptionInternal(e, userAlreadyExistException.getApiResponse(), headers, UNPROCESSABLE_ENTITY, request);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(RuntimeException e, WebRequest request) {
        IllegalStateException illegalStateException = (IllegalStateException) e;
        return handleExceptionInternal(e, new ApiResponse("0", illegalStateException.getMessage(), "false"), headers, UNPROCESSABLE_ENTITY, request);
    }

}
