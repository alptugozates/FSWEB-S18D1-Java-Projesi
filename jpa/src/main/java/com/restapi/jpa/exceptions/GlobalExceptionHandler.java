package com.restapi.jpa.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.logging.ErrorManager;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BurgerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseError> handleBurgerNotFoundException(BurgerNotFoundException ex, WebRequest request) {
        logError(ex);
        ResponseError error = new ResponseError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BurgerValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseError> handleBurgerValidationException(BurgerValidationException ex, WebRequest request) {
        logError(ex);
        ResponseError error = new ResponseError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseError> handleGenericException(Exception ex, WebRequest request) {
        logError(ex);
        ResponseError error = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public void logError(Exception ex) {
        log.error("An error occurred: {}", ex.getMessage(), ex);
    }
}
