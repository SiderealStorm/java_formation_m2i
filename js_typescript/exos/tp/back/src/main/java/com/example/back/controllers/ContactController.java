package com.example.back.controllers;

import com.example.back.models.ContactDetailsDTO;
import com.example.back.models.ContactSummaryDTO;
import com.example.back.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

//    @GetMapping("list")
//    public ResponseEntity<List<ContactSummaryDTO>> getContactSummaryList() {
//        return ResponseEntity.ok(service.getAllContactsDtoList());
//    }

    @GetMapping("list")
    public ResponseEntity<List<ContactDetailsDTO>> getContactSummaryList() {
        return ResponseEntity.ok(service.getAllContactsDtoList());
    }

    @GetMapping("details/{contactId}")
    public ResponseEntity<ContactDetailsDTO> getContactDetailsById(@PathVariable("contactId") Long id) {
        ContactDetailsDTO contact = service.getContactById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("add")
    public ResponseEntity<ContactDetailsDTO> addNewContact(@RequestBody ContactDetailsDTO newContact) {
        ContactDetailsDTO savedContact = service.saveNewContact(newContact);
        return ResponseEntity.ok(savedContact);
    }
}
