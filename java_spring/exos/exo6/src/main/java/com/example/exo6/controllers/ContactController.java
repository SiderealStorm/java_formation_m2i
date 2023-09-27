package com.example.exo6.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getAddContactForm(Model model) {
        model.addAttribute("mode", "add");
        return "contacts/form";
    }

    @GetMapping("/details/{id}")
    public String getContactDetails(Model model) {
        model.addAttribute("mode", "view");
        return "contacts/form";
    }

    @GetMapping("/edit/{id}")
    public String getEditContactForm(Model model) {
        model.addAttribute("mode", "edit");
        return "contacts/form";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteContactForm(Model model) {
        model.addAttribute("mode", "delete");
        return "contacts/form";
    }

}
