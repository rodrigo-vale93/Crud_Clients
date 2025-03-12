package com.crud.projeto_crud.controller.handlers;

import com.crud.projeto_crud.dto.CustomError;
import com.crud.projeto_crud.dto.ValidationError;
import com.crud.projeto_crud.services.ResourceExceptionNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceExceptionNotFound.class)
    public ResponseEntity<CustomError> ResourceException(ResourceExceptionNotFound e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> ethodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        for (FieldError f : e.getBindingResult().getFieldErrors()){
            err.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }
}