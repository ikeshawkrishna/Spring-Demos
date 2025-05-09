package com.example.FlightService.Exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleInvalidArgument(Exception e){
        Map<String, String> mapResult = new HashMap<>();
        
        if(e instanceof MethodArgumentNotValidException ex){
            List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
            fieldErrors.forEach( error -> mapResult.put(error.getField(), error.getDefaultMessage()));
            return mapResult;
        }

        if(e instanceof ConstraintViolationException ex){
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
            for(ConstraintViolation cv: constraintViolations){
                mapResult.put(cv.getPropertyPath().toString(), cv.getMessage());
            }
            return mapResult;
        }

        if(e instanceof HttpMessageNotReadableException ex){
            mapResult.put("Error", ex.getMessage());
            return mapResult;
        }

        e.printStackTrace();

        return mapResult;
    }


}
