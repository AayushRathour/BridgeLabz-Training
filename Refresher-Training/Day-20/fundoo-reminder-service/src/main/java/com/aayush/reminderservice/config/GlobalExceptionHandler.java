package com.aayush.reminderservice.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

/**
 * Global exception handler for reminder-service.
 *
 * Converts:
 *   - ResponseStatusException  → { "error": "..." }  with the appropriate HTTP status
 *   - Validation errors         → { "field": "message", ... } with 400
 *   - Unexpected exceptions     → { "error": "Internal server error" } with 500
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles explicit HTTP errors thrown via ResponseStatusException
     * (e.g., 404 Note not found, 403 Forbidden).
     */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleResponseStatus(
            ResponseStatusException ex) {

        Map<String, String> body = new LinkedHashMap<>();
        body.put("error", ex.getReason() != null ? ex.getReason() : ex.getMessage());

        return ResponseEntity
                .status(ex.getStatusCode())
                .body(body);
    }

    /**
     * Handles bean validation failures (@Valid on request bodies).
     * Returns a map of fieldName → errorMessage.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new LinkedHashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    /**
     * Catch-all for any other uncaught runtime exceptions.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneric(Exception ex) {

        Map<String, String> body = new LinkedHashMap<>();
        body.put("error", "Internal server error");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body);
    }
}
