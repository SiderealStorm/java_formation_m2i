package com.example.exo6.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    @GetMapping
    public String getContactsList() {
        return "contacts/list";
    }

    @GetMapping("/add")
    public String getAddContactForm() {
        return "contacts/form";
    }
}
