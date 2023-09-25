package com.example.exo3.controllers;

import com.example.exo3.exceptions.InvalidFormException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(InvalidFormException.class)
    public ResponseEntity<String> sentInvalidForm(
    ) {
        return new ResponseEntity<>("Errors in form", HttpStatus.BAD_REQUEST);
    }
}
