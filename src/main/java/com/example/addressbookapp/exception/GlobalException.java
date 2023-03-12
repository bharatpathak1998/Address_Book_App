package com.example.addressbookapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> notValidException(MethodArgumentNotValidException ex) {
        Map<String, String> map = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            map.put(error.getField(), error.getDefaultMessage());
        });
        return map;
    }

    @ExceptionHandler(TokenNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(TokenNotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        return map;
    }
}