package com.example.demo.advice;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public Map<Path, String> handleModelInvalidArgument(ConstraintViolationException exception) {
        Map<Path, String> errorMap = new HashMap<>();
        exception.getConstraintViolations()
                .forEach(fieldError -> errorMap.put(fieldError.getPropertyPath(), fieldError.getMessage()));
        return errorMap;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleDtoInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        BindingResult body = exception.getBindingResult();
        body.getFieldErrors()
                .forEach(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return errorMap;
    }

}
