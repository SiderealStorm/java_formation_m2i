package com.example.back.controllers;

import com.example.back.models.ContactDTO;
import com.example.back.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @GetMapping("list")
    public ResponseEntity<List<ContactDTO>> getContactSummaryList() {
        return ResponseEntity.ok(service.getAllContactsDtoList());
    }

    @PostMapping("add")
    public ResponseEntity<ContactDTO> addNewContact(@RequestBody ContactDTO newContact) {
        ContactDTO savedContact = service.saveNewContact(newContact);
        return ResponseEntity.ok(savedContact);
    }

    @PatchMapping("edit")
    public ResponseEntity<ContactDTO> editContact(@RequestBody ContactDTO contact) {
        ContactDTO editedContact = service.editContact(contact);
        if (editedContact != null) {
            return ResponseEntity.ok(editedContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteContactById(@RequestBody ContactDTO contact) {
        if (service.deleteContactById(contact.getId())) {
            return ResponseEntity.ok("Contact n°" + contact.getId() + " supprimé");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
