package com.example.demo_security_session.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/private")
@RequiredArgsConstructor
public class PrivateRestController {

    // Dans le cas d'une API, la session se trouve dans les Headers de la requête
    @GetMapping
    public String getSecret(
            HttpServletRequest request
    ) {
        // Le header
        String authorization = request.getHeader("Authorization");

        if (authorization != null && authorization.equals("Storm")) {
            return "The secret is... idk";
        }

        // En temps normal, on renvoie une erreur 403
        return "Status : 403";
    }
}
