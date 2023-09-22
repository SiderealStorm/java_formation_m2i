package com.example.demo_validation.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseRestController {

    @GetMapping
    public String getBaseRoute() {

        // Génération d'une exception
        int number = 25 / 0;

        return "Hello World!";
    }

}
