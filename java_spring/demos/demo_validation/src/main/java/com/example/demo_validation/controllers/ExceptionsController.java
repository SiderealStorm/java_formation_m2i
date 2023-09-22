package com.example.demo_validation.controllers;

import com.example.demo_validation.exceptions.ElementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Annotation Spring permettant de déclarer la classe comme REST controller d'exceptions
@RestControllerAdvice
public class ExceptionsController {

    // Méthode permettant de gérer une exception Java
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> dividedByZero() {
        return new ResponseEntity<>("Divided by 0", HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    // Autre façon de gérer l'erreur 404
//    @ExceptionHandler(ElementNotFoundException.class)
//    public ResponseEntity<String> elementNotFound() {
//        return new ResponseEntity<>("Element not found", HttpStatus.NOT_FOUND);
//    }
}
