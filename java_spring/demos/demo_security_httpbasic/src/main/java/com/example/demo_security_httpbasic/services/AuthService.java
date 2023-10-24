package com.example.demo_security_httpbasic.services;

import com.example.demo_security_httpbasic.entities.UserEntity;
import com.example.demo_security_httpbasic.models.AuthenticationRequest;
import com.example.demo_security_httpbasic.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Service gérant l'authentification
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserEntityRepository userEntityRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    // Méthode pour créer un utilisateur et le connecter
    // On utilise on objet spécifique pour que le code soit plus maintenable
    public void register(AuthenticationRequest authRequest) {
        // On commence par vérifier que l'utilisateur n'existe pas déjà
        if (!userEntityRepository.existsByEmail(authRequest.getEmail())) {
            // Création de l'utilisateur :
            UserEntity newUser = new UserEntity();
            newUser.setEmail(authRequest.getEmail());
            // Le mot de passe doit être encodé
            newUser.setPassword(passwordEncoder.encode(authRequest.getPassword()));

            // Sauvegarde de l'utilisateur en BDD
            userEntityRepository.save(newUser);
        }

        // Connexion de l'utilisateur créé :
        authenticate(authRequest);
    }

    public void authenticate(AuthenticationRequest authRequest) {

        // On crée un token de connexion
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                // On passe les données de connexion (non encodées) :
                // principal = username de connexion tel que défini dans le CustomUserDetailsService (ici email)
                authRequest.getEmail(),
                // credentials = password NON encodé
                authRequest.getPassword()
        );

        // On authentifie l'utilisateur
        Authentication authentication = authenticationManager.authenticate(token);

        // On ajoute l'authentification au contexte de sécurité
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
