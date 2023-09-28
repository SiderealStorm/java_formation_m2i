package com.example.demo_security_jwt.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

// Annotation Spring pour composant autre que config, service, etc. qu'on veut Autowire
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    // Méthode appelée en cas de AuthenticationException
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Erreur à renvoyer en cas d'utilisation de JWT
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
