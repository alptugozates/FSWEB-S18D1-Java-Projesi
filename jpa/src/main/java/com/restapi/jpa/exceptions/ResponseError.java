package com.restapi.jpa.exceptions;

import lombok.Data;

@Data
public class ResponseError {
    private int status;
    private String message;

    public ResponseError(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
