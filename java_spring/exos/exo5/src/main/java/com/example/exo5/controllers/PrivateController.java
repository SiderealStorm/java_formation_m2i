package com.example.exo5.controllers;

import com.example.exo5.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
@RequiredArgsConstructor
public class PrivateController {

    private final UserService service;

    @GetMapping
    public String getPrivateHomePage(Model model) {
        model.addAttribute("username", service.getUser());

        return "private/home";
    }


    @GetMapping("profile")
    public String getProfilePage() {
        return "private/profile";
    }


    @GetMapping("favs")
    public String getFavouritesPage() {
        return "private/favs";
    }
}
