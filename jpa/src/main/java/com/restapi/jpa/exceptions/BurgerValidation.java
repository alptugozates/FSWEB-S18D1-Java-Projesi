package com.restapi.jpa.exceptions;

import com.restapi.jpa.entity.Burger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BurgerValidation {
    private static final int MIN_CONTENT_LENGTH = 5;
    private static final int MAX_PRICE = 1000;


    public void validate(Burger burger) {
        if (burger == null) {
            throw new BurgerValidationException("Burger object cannot be null");
        }

        validateContent(burger.getContents());
        validatePrice(burger.getPrice());
        validateBreadType(burger.getBreadType());
    }

    private void validateContent(String content) {
        if (content == null || content.trim().isEmpty()) {
            throw new BurgerValidationException("Burger content cannot be empty");
        }

        if (content.length() < MIN_CONTENT_LENGTH) {
            throw new BurgerValidationException("Burger content should be at least " + MIN_CONTENT_LENGTH + " characters");
        }
    }

    private void validatePrice(double price) {
        if (price < 0) {
            throw new BurgerValidationException("Burger price cannot be negative");
        }
    }

    private void validateBreadType(String breadType) {
        if(breadType == null) {
            throw new BurgerValidationException("Bread Type cannot be null");
        }
    }
}
