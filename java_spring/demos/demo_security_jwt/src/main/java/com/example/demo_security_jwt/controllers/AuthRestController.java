package com.example.demo_security_jwt.controllers;

import com.example.demo_security_jwt.models.AuthenticationRequest;
import com.example.demo_security_jwt.models.AuthenticationResponse;
import com.example.demo_security_jwt.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller pour gérer la connexion
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerHandler(@RequestBody AuthenticationRequest authRequest) {
        // On enregistre le nouvel utilisateur et on récupère le token
        String token = authService.register(authRequest);

        // API = stateless : on ne modifie pas la session
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(token)
                .build();

        return ResponseEntity.ok(response);
    }


    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authHandler(AuthenticationRequest authRequest) {
        String token = authService.authenticate(authRequest);

        // API = stateless : on ne modifie pas la session
        AuthenticationResponse response = AuthenticationResponse.builder()
                .token(token)
                .build();

        return ResponseEntity.ok(response);
    }
}
