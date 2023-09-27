package com.example.exo6.services;

import com.example.exo6.entities.UserEntity;
import com.example.exo6.models.AuthenticationRequest;
import com.example.exo6.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserEntityRepository repository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public void register(AuthenticationRequest authRequest) {
        if (!repository.existsByEmail(authRequest.getLogin())) {
            UserEntity newUser = new UserEntity();
            newUser.setEmail(authRequest.getLogin());
            newUser.setPassword(
                    passwordEncoder.encode(authRequest.getPassword())
            );
            repository.save(newUser);
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
