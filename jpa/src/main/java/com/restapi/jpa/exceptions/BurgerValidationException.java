package com.restapi.jpa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class BurgerValidationException extends RuntimeException{
    public BurgerValidationException(String message) {
        super(message);
    }
}
