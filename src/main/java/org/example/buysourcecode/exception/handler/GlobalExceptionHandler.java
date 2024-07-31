package org.example.buysourcecode.exception.handler;

import org.example.buysourcecode.dto.ErrorResponse;
import org.example.buysourcecode.exception.BaseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ErrorResponse handleBaseException(BaseException e) {
        return ErrorResponse.builder()
                .status(e.getStatus())
                .code(e.getCode())
                .type(e.getType())
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleConstraintViolationException(MethodArgumentNotValidException e) {
        Map<String, Object> extra = new HashMap<>();
        e.getFieldErrors().forEach(violation -> extra.put(violation.getField(), violation.getDefaultMessage()));

        return ErrorResponse.builder()
                .status(400)
                .code("400001")
                .type("INVALID_REQUEST")
                .message("Invalid request")
                .extraErrors(extra)
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e) {
        e.printStackTrace();
        return ErrorResponse.builder()
                .status(500)
                .code("500001")
                .type("INTERNAL_SERVER_ERROR")
                .message("Internal server error")
                .build();
    }

}
