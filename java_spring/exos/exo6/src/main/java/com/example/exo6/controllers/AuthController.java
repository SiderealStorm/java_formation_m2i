package com.example.exo6.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("login")
    public String getLoginForm(Model model) {
        model.addAttribute("mode", "login");

        return "auth/form";
    }


    @GetMapping("signin")
    public String getRegisterForm(Model model) {
        model.addAttribute("mode", "register");

        return "auth/form";
    }
}
