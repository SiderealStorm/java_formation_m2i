package com.example.demo_security_session.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
@RequiredArgsConstructor
public class PrivateController {

    @GetMapping
    public String getPrivatePage(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();

        // On peut vérifier le contenu de la session
        String user = (String) session.getAttribute("user");

        if (user != null && user.equals("Storm")) {
            return "private/secret";
        }
        return "redirect:/";
    }

}
