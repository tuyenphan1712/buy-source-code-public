package org.example.buysourcecode.exception;

import org.springframework.http.HttpStatus;

public class InvalidException extends BaseException {
    public InvalidException(String message) {
        super(400, "400002", "Invalid", message);
    }
}
