package com.example.exo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PersonController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("person/detail")
    public String personDetails(Model model) {
        model.addAttribute("person", "Jacques DUPONT");

        return "persons/detail-one";
    }

    @GetMapping("persons/details")
    public String personsDetails(Model model) {
        model.addAttribute("person1", "John DOE");
        model.addAttribute("person2", "Jack DOE");
        return "persons/detail-two";
    }

    @GetMapping("persons")
    public String personsList(Model model) {
        List<String> persons = List.of("Jacques DUPONT", "Julie DURAND", "John DOE", "Jack DOE", "Jane DOE");
        model.addAttribute("persons", persons);
        return "persons/list";
    }
}
