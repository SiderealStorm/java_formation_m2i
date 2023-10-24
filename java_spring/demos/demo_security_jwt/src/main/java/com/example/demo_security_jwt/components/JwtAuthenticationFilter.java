package com.example.demo_security_jwt.components;

import com.example.demo_security_jwt.entities.UserEntity;
import com.example.demo_security_jwt.services.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// Composant pour l'authentification JWT
// Pas d'annotation car sinon les dépendances s'injectent en boucle
// Cette classe doit être ajoutée à la FilterChain
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenGenerator jwtTokenGenerator;
    private final CustomUserDetailsService customUserDetailsService;

    // Méthode pour authentifier un utilisateur
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // On récupère le token JWT
        String token = getJwtFromRequest(request);

        // On vérifie que le token est non vide et valide
        if (StringUtils.hasText(token) && jwtTokenGenerator.validateToken(token)) {
            // Mise à jour du contexte de validation :

            // Récupération de l'utilisateur dans le token JWT
            String username = jwtTokenGenerator.getUserFromToken(token);

            // Recherche de l'utilisateur en BDD
            UserEntity foundUser = customUserDetailsService.loadUserByUsername(username);

            // Création d'un token d'authentification
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    foundUser.getEmail(),
                    foundUser.getPassword(),
                    foundUser.getAuthorities()
            );

            // On extrait les détails de la requête (IP, etc.)
            // et on les passe au token d'authentification
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // Authentification de l'utilisateur en mettant à jour le contexte de sécurité
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        // On envoie la requête et la réponse pour vérification à la filterChain
        // (= permet de poursuivre de la filterChain)
        filterChain.doFilter(request, response);
    }

    // Méhtode pour extraire le token
    private String getJwtFromRequest(HttpServletRequest request) {
        // Le token se trouve dans un Header de la requête
        String authHeader =  request.getHeader("Authorization");

        // On vérifie que le header récupéré n'est ni null, ni vide, ni blank
        // et qu'il commence par 'Bearer'
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer")) {
            // On ne récupère que la partie après 'Bearer '
            return authHeader.substring("Bearer ".length());
        }

        return null;
    }
}
