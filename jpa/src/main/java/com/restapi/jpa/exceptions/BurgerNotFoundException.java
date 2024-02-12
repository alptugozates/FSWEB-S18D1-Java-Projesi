package com.restapi.jpa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BurgerNotFoundException extends RuntimeException{
    private HttpStatus status;
    public BurgerNotFoundException(String message) {
        super(message);
    }
}
