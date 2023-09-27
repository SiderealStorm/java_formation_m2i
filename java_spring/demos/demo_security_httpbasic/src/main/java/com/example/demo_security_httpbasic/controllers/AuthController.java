package com.example.demo_security_httpbasic.controllers;

import com.example.demo_security_httpbasic.models.AuthenticationRequest;
import com.example.demo_security_httpbasic.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller pour gérer la connexion
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        model.addAttribute("authRequest", AuthenticationRequest.builder().build());
        model.addAttribute("mode", "register");

        return "auth/registerForm";
    }

    @PostMapping("/register")
    public String registerHandler(AuthenticationRequest authRequest, HttpServletRequest request) {
        // On enregistre le nouvel utilisateur
        authService.register(authRequest);

        // Pour authentifier réellement un utilisateur, il doit être mis dans la session
        HttpSession session = request.getSession();
        // Pour cela il nous faut le contexte de sécurité mis à jour
        SecurityContext context = SecurityContextHolder.getContext();
        // On envoie le contexte dans la session à l'attribut où il est attendu
        session.setAttribute("SPRING_SECURITY_CONTEXT", context);

        return "redirect:/private";
    }

    @GetMapping("authenticate")
    public String getAuthenticationForm(Model model) {
        model.addAttribute("authRequest", AuthenticationRequest.builder().build());
        model.addAttribute("mode", "authenticate");

        return "auth/registerForm";
    }

    @PostMapping("authenticate")
    public String authHandler(AuthenticationRequest authRequest, HttpServletRequest request) {
        authService.authenticate(authRequest);

        HttpSession session = request.getSession();
        SecurityContext context = SecurityContextHolder.getContext();
        session.setAttribute("SPRING_SECURITY_CONTEXT", context);

        return "redirect:/private";
    }
}
