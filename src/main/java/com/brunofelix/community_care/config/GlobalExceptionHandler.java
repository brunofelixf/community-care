package com.brunofelix.community_care.config;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.brunofelix.community_care.exception.ResourceNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Tratamento de exceções de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                errors,
                LocalDateTime.now(),
                request.getDescription(false)
        );

        logger.error("Validation Failed: {}", errorResponse);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

     // Tratamento de recurso não encontrado
     @ExceptionHandler(ResourceNotFoundException.class)
     public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
 
        ErrorResponse errorResponse = new ErrorResponse(
                 HttpStatus.NOT_FOUND.value(),
                 ex.getMessage(),
                 null,
                 LocalDateTime.now(),
                 request.getDescription(false)
         );

        logger.error("Resource Not Found: {}", errorResponse);
 
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
     }

     // Tratamento genérico de exceções
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(
            Exception ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred",
                null,
                LocalDateTime.now(),
                request.getDescription(false)
        );

        logger.error("An unexpected error occurred: {}", ex);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
