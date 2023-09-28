package com.example.demo_security_jwt.services;

import com.example.demo_security_jwt.entities.UserEntity;
import com.example.demo_security_jwt.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Pour que la classe soit reconnue par Spring Security comme classe de sécurité par défaut,
// il faut implémenter son interface par défaut : UserDetailsService
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return userEntityRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username + " is not a registered email"));
    }
}
