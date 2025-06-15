package com.org.PropertyService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        ValidationExceptionResponse response = new ValidationExceptionResponse(HttpStatus.BAD_REQUEST.value(),errors);
        return new ResponseEntity<ValidationExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyNotFound.class)
    public ResponseEntity<?> propertyNotFound(PropertyNotFound propertyNotFound){
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), propertyNotFound.getMessage()),HttpStatus.NOT_FOUND);
    }

}
