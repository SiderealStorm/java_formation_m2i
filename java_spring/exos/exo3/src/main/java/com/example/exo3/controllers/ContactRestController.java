package com.example.exo3.controllers;

import com.example.exo3.exceptions.ElementNotFoundException;
import com.example.exo3.exceptions.InvalidFormException;
import com.example.exo3.models.ContactDTO;
import com.example.exo3.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactRestController {

    private final ContactService contactService;

    @GetMapping
    public List<ContactDTO> getContactsList() {
        return contactService.getAllContacts();
    }

    @GetMapping("{contactId}")
    public ContactDTO getContactDetails(@PathVariable("contactId") UUID id) {
        ContactDTO contact = contactService.getContactById(id);

        if (contact != null) {
            return contact;
        } else {
            throw new ElementNotFoundException();
        }
    }

    @PostMapping("add")
    public ResponseEntity<String> addNewContact(
            @RequestBody @Valid ContactDTO newContact,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            throw new InvalidFormException();
        }

        ContactDTO contact = contactService.addContact(newContact);

        return new ResponseEntity<>("Contact created with id : " + contact.getId(), HttpStatus.OK);
    }

    @DeleteMapping("{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable("contactId") UUID id) {

        // On vérifie d'abord si l'id existe
        if(contactService.isIdInDb(id)) {
            if (contactService.deleteContactById(id)) {
                return new ResponseEntity<>("Contact deleted at id : " + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_MODIFIED);
        }
        throw new ElementNotFoundException();
    }

    @PatchMapping("{contactId}")
    public ContactDTO editContact(@PathVariable("contactId") UUID id, @RequestBody ContactDTO contact) {
        // On vérifie d'abord si l'id existe
        if(contactService.isIdInDb(id)) {
            return contactService.editContact(id, contact);
        }
        throw new ElementNotFoundException();
    }
}
