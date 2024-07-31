package org.example.buysourcecode.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), "404001", "NOT_FOUND", message);
    }
}
