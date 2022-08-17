package com.example.demo.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public Map<Path, String> handleInvalidArgument(ConstraintViolationException ex) {
        Map<Path, String> errorMap = new HashMap<>();
        ex.getConstraintViolations().forEach(fieldError -> errorMap.put(fieldError.getPropertyPath(), fieldError.getMessage()));
        return errorMap;
    }
}
