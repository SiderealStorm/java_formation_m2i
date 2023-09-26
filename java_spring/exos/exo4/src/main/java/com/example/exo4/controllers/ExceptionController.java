package com.example.exo4.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
public class ExceptionController {

    // Pour que l'erreur 404 de l'API soit renvoyée comme tel au Front
    @ExceptionHandler(RestClientException.class)
    public String handleRestClientException() {
        return "error/404";
    }
}
