package com.example.exo6.controllers;

import com.example.exo6.models.ContactDTO;
import com.example.exo6.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @GetMapping
    public String getContactsList(Model model) {
        model.addAttribute("contacts", service.getAllContacts());

        return "contacts/list";
    }

    @GetMapping("add")
    public String getAddContactForm(Model model) {
        model.addAttribute("mode", "add");
        model.addAttribute("contact", ContactDTO.builder().build());

        return "contacts/form";
    }

    @PostMapping("add")
    public String addContact(ContactDTO contactDTO) {
        service.addContact(contactDTO);

        return "redirect:/contacts";
    }

    @GetMapping("details/{id}")
    public String getContactDetails(
            Model model,
            @PathVariable UUID id
            ) {
        model.addAttribute("mode", "view");
        model.addAttribute("contact", service.getContactById(id));

        return "contacts/form";
    }

    @GetMapping("edit/{id}")
    public String getEditContactForm(
            Model model,
            @PathVariable UUID id
    ) {
        model.addAttribute("mode", "edit");
        model.addAttribute("contact", service.getContactById(id));

        return "contacts/form";
    }

    @PostMapping("edit/{id}")
    public String editContact(
            @PathVariable UUID id,
            ContactDTO contactDTO
    ) {
        service.updateContact(id, contactDTO);

        return "redirect:/contacts";
    }

    @GetMapping("delete/{id}")
    public String getDeleteContactForm(
            Model model,
            @PathVariable UUID id
    ) {
        model.addAttribute("mode", "delete");
        model.addAttribute("contact", service.getContactById(id));

        return "contacts/form";
    }


    @PostMapping("delete/{id}")
    public String editContact(@PathVariable UUID id) {
        service.deleteContact(id);

        return "redirect:/contacts";
    }


}
