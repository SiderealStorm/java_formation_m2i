package com.example.exo1.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PersonRestController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("person/detail")
    public String personDetails(Model model) {
        return "Jacques DUPONT";
    }

    @GetMapping("persons/details")
    public String[] personsDetails(Model model) {
        return new String[] {"John DOE", "Jack DOE"};
    }

    @GetMapping("persons")
    public List<String> personsList(Model model) {
        return List.of("Jacques DUPONT", "Julie DURAND", "John DOE", "Jack DOE", "Jane DOE");
    }
}
