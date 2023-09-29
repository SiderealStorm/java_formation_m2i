package com.example.exo6.services;

import com.example.exo6.entities.RoleEntity;
import com.example.exo6.entities.UserEntity;
import com.example.exo6.models.AuthenticationRequest;
import com.example.exo6.repositories.RoleEntityRepository;
import com.example.exo6.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserEntityRepository userRepository;
    private final RoleEntityRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public void register(AuthenticationRequest authRequest) {
        if (!userRepository.existsByEmail(authRequest.getLogin())) {
            UserEntity newUser = new UserEntity();
            newUser.setEmail(authRequest.getLogin());
            newUser.setPassword(
                    passwordEncoder.encode(authRequest.getPassword())
            );

            // TODO ajouter les autres données de l'utilisateur

            // On crée le rôle en BDD s'il n'existe pas
            if (roleRepository.findByName("USER").isEmpty()) {
                RoleEntity userRole = new RoleEntity();
                userRole.setName("USER");
                roleRepository.save(userRole);
            }

            // Ajout du rôle
            // Si on voulait ajouter d'autres rôles à un utilisateur, on devrait le faire en BDD
            newUser.setRoles(Collections.singleton(roleRepository.findByName("USER").orElse(null)));

            userRepository.save(newUser);
        }

        authenticate(authRequest);
    }

    public void authenticate(AuthenticationRequest authRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                authRequest.getLogin(),
                authRequest.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
