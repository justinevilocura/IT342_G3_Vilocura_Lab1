package com.example.demo.security;

import com.example.demo.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        
        return ResponseEntity.badRequest().body(new MessageResponse("Validation error: " + errorMessage));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalExceptions(Exception ex) {
        return ResponseEntity.internalServerError().body(new MessageResponse("An unexpected error occurred: " + ex.getMessage()));
    }
}
