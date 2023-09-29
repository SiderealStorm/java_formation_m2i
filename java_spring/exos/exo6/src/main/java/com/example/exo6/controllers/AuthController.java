package com.example.exo6.controllers;

import com.example.exo6.models.AuthenticationRequest;
import com.example.exo6.services.AuthService;
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

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("signin")
    public String getSigninForm(Model model) {
        model.addAttribute("mode", "signin");
        model.addAttribute("authRequest", AuthenticationRequest.builder().build());

        return "auth/form";
    }

    @PostMapping("signin")
    public String signin(AuthenticationRequest authRequest, HttpServletRequest request) {
        authService.authenticate(authRequest);
        updateContext(request);
        return "redirect:/contacts";
    }


    @GetMapping("signup")
    public String getRegisterForm(Model model) {
        model.addAttribute("mode", "signup");
        model.addAttribute("authRequest", AuthenticationRequest.builder().build());

        return "auth/form";
    }

    @PostMapping("signup")
    public String signup(AuthenticationRequest authRequest, HttpServletRequest request) {
        authService.register(authRequest);
        updateContext(request);
        return "redirect:/contacts";
    }


    private void updateContext(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SecurityContext context = SecurityContextHolder.getContext();
        session.setAttribute("SPRING_SECURITY_CONTEXT", context);
    }
}
