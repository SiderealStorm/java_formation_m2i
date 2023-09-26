package com.example.exo5.controllers;

import com.example.exo5.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final UserService service;

    @GetMapping
    public String getHomePage() {
        return "home";
    }

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("login")
    public String logIn(String username) {
        service.setUser(username);

        return "redirect:/private";
    }
}
