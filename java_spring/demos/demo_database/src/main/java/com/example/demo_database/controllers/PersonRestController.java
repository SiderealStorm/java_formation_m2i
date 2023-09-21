package com.example.demo_database.controllers;

import com.example.demo_database.models.PersonDTO;
import com.example.demo_database.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Annotations Spring
@RestController
@RequestMapping("/api/v1/persons")
// Annotation Lombok
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> listPersons() {
        return personService.listPersons();
    }

    @PostMapping
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return personService.addPerson(personDTO);
    }

}
