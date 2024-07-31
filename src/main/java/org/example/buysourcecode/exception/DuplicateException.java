package org.example.buysourcecode.exception;


public class DuplicateException extends BaseException {
    public DuplicateException(String message) {
        super(400, "400001", "Duplicate", message);
    }
}
