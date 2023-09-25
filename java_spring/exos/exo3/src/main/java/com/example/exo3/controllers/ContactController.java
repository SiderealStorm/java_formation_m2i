package com.example.exo3.controllers;

import com.example.exo3.exceptions.ElementNotFoundException;
import com.example.exo3.models.ContactDTO;
import com.example.exo3.models.DisplayMode;
import com.example.exo3.services.ContactService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/contacts")
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public String getContactsList(
            Model model,
            @RequestParam(value = "filter", defaultValue = "") String filter
    ) {
        List<ContactDTO> contacts;

        if (filter == null || (filter.isBlank() && filter.isEmpty())) {
            contacts = contactService.getAllContacts();
        } else {
            contacts = contactService.getContactsFilterLastname(filter);
        }

        model.addAttribute("contacts", contacts);
        model.addAttribute("filter", "");

        return "contacts/list";
    }

    @PostMapping
    public String getFilteredContactsList(
            String filter
    ) {

        return "redirect:/contacts?filter=" + filter;
    }

    @GetMapping("{contactId}")
    public String getContactDetails(
            Model model,
            @PathVariable("contactId") UUID id
            ) {
        ContactDTO contact = contactService.getContactById(id);

        if (contact != null) {
            model.addAttribute("contact", contact);
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
    public String addNewContact(
            // L'ordre est important !
            @Valid ContactDTO contact,
            BindingResult results,
            Model model
            ) {
        System.out.println("Add new contact");

        if (results.hasErrors()) {
            System.out.println("Form has errors");

            model.addAttribute("mode", DisplayMode.ADD.getValue());
            model.addAttribute("contact", contact);

            return "contacts/form";
        }

        contactService.addContact(contact);
        System.out.println("New contact added");

        return "redirect:/contacts";
    }

    @GetMapping("delete/{contactId}")
    public String getDeleteContactForm(@PathVariable("contactId") UUID id, Model model) {
        ContactDTO contact = contactService.getContactById(id);

        if (contact != null) {
            model.addAttribute("contact", contact);
            model.addAttribute("mode", DisplayMode.DELETE.getValue());
            return "contacts/form";
        } else {
            throw new ElementNotFoundException();
        }
    }

    @PostMapping("delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") UUID id) {
        if(contactService.isIdInDb(id)) {
            if(contactService.deleteContactById(id)) {
                return "redirect:/contacts";
            }
        }
        throw new ElementNotFoundException();
    }

    @GetMapping("edit/{contactId}")
    public String getEditContactForm(@PathVariable("contactId") UUID id, Model model) {
        ContactDTO contact = contactService.getContactById(id);

        if (contact != null) {
            model.addAttribute("contact", contact);
            model.addAttribute("mode", DisplayMode.EDIT.getValue());
            return "contacts/form";
        } else {
            throw new ElementNotFoundException();
        }
    }

    @PostMapping("edit/{contactId}")
    public String editContact(@PathVariable("contactId") UUID id, ContactDTO contact) {
        if(contactService.isIdInDb(id)) {
            contactService.editContact(id, contact);
            return "redirect:/contacts";
        }
        throw new ElementNotFoundException();
    }
}
