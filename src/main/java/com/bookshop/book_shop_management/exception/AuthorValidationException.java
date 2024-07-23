package com.bookshop.book_shop_management.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AuthorValidationException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundBookException.class)
    public Map<String, Object> handleNotFoundBookException(NotFoundBookException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        return response;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidReactException.class)
    public Map<String, Object> handleNotFoundBookException(InvalidReactException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        return response;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyDetailsException.class)
    public Map<String, Object> handleEmptyDetailsException(EmptyDetailsException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        return response;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyAuthorsException.class)
    public Map<String, Object> handleEmptyAuthorsException(EmptyAuthorsException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        return response;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PageIsOverException.class)
    public Map<String, Object> handlePageIsOverException(PageIsOverException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        return response;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotISBNException.class)
    public Map<String, Object> handleNotISBNException(NotISBNException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        return response;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundBookCategoryException.class)
    public Map<String, Object> handleNotFoundBookCategoryException(NotFoundBookCategoryException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> hendleException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthorNotFoundException.class)
    public Map<String, String> hendleException(AuthorNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> hendleException(HttpMessageNotReadableException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", "Malformed JSON request");
        errorMap.put("message", ex.getLocalizedMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> hendleException(ConstraintViolationException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getConstraintViolations().forEach(constraintViolation -> {
            errorMap.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        });
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String, String> hendleException(SQLIntegrityConstraintViolationException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", ex.getLocalizedMessage());
        return errorMap;
    }
}
