package com.example.demo_bases.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// En définissant le mapping sur la classe,
// toutes les méthodes de la classent commenceront par le même URL
@RequestMapping("/api/v1/home")
public class BaseRestController {

    @GetMapping
    public String getPersonFullName() {
        return "John Dupont";
    }

    @GetMapping("persons")
    public List<String> getPersons() {
        return List.of("Jacques DUPONT", "Julie DURAND", "John DOE");
    }
}
