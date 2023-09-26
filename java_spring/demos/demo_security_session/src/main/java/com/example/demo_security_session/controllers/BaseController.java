package com.example.demo_security_session.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//La session n'existe QUE dans une WebApp car une API est Stateless

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BaseController {

    @GetMapping
    public String getHomePage(
            // La session se trouve dans le HttpServletRequest
            HttpServletRequest request,
            Model model
    ) {
        // On peut récupérer la session dans la requête
        HttpSession session = request.getSession();

        // Comme en JEE classique, on peut attribuer un utilisateur
        session.setAttribute("user", "Toto");

        model.addAttribute("username", "");
        model.addAttribute("password", "");
        model.addAttribute("error", "");

        return "home";
    }

    @PostMapping
    public String login(
            String username,
            String password,
            HttpServletRequest request,
            Model model
    ) {
        String error = "";

        if (username != null && username.equals("admin")) {
            if (password != null && password.equals("admin")) {
                request.getSession().setAttribute("user", "Storm");
            } else {
                error = "Invalid password";
            }
        } else {
            error = "Invalid username";
        }

        if (error.isBlank()) {
            return "redirect:/private";
        }

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("error", error);
        return "home";
    }
}
