package com.example.exo3.controllers;

import com.example.exo3.exceptions.ElementNotFoundException;
import com.example.exo3.models.ContactDTO;
import com.example.exo3.models.DisplayMode;
import com.example.exo3.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController() {
        contactService = new ContactService();
    }

    @GetMapping
    public String getContactsList(Model model) {
        List<ContactDTO> contacts = contactService.getAllContacts();

        model.addAttribute("contacts", contacts);

        return "contacts/list";
    }

    @GetMapping("{contactId}")
    public String getContactDetails(
            Model model,
            @PathVariable("contactId") UUID id
            ) {
        Optional<ContactDTO> contact = contactService.getContactById(id);

        if (contact.isPresent()) {
            model.addAttribute("contact", contact.get());
            model.addAttribute("mode", DisplayMode.VIEW.getValue());
            return "contacts/form";
        } else {
            throw new ElementNotFoundException();
        }
    }

    @GetMapping("add")
    public String getNewContactForm(Model model) {
        model.addAttribute("mode", DisplayMode.ADD.getValue());
        model.addAttribute("contact", ContactDTO.builder().build());

        return "contacts/form";
    }

    @PostMapping("add")
    public String addNewContact(ContactDTO contact) {
        contactService.addContact(contact);

        return "redirect:/contacts";
    }
}
