package com.jumpstart.food_ordering_system.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFound(CategoryNotFoundException ex) {
        return buildErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(MenuNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMenuNotFound(MenuNotFoundException ex) {
        return buildErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    private ResponseEntity<Map<String, String>> buildErrorResponse(String message) {
        Map<String, String> error = new HashMap<>();
        error.put("error", message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}