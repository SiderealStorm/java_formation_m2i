package com.example.demo_validation.controllers;

import com.example.demo_validation.dto.ContactDTO;
import com.example.demo_validation.entities.Contact;
import com.example.demo_validation.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactRestController {

    private final ContactService contactService;

    @GetMapping("{contactId}")
    public Contact getContactById(@PathVariable("contactId") Long id) {
        return contactService.getContactById(id);
    }

    @PostMapping
    public ResponseEntity<String> postContact(
            // Annotation @Valid pour vérifier la validité des champs
            @RequestBody @Valid ContactDTO newDto,
            // Pour mapper les erreurs et leur type
            BindingResult results
    ) {

        if (results.hasErrors()) {
            List<String> errors = new ArrayList<>();
            results.getAllErrors().forEach(err -> errors.add(err.toString() + "\n"));
            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Contact created", HttpStatus.CREATED);
    }
}
