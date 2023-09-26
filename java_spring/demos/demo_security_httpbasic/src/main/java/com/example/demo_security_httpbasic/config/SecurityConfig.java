package com.example.demo_security_httpbasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// Annotation pour configuration
@Configuration
// Annotation pour préciser qu'il s'agit d'une config de sécurité
@EnableWebSecurity
public class SecurityConfig {

    // Annotation signifiant à Spring qu'il faut utiliser cette méthode pour définir tous les éléments de ce type
    @Bean
    // FilterChain ~ suite de tests d'autorisation
    // Si un test échoue, une exception peut être levée
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Configuration du HttpSecurity :
        http
                // Desactivation du CSRF (évite les erreurs de type CORS)
                .csrf().disable()
                // Pour choisir les pages autorisées : requestMatchers + autorisations par groupe de pages
                .authorizeRequests()
                // Toute les pages commençant par /public sont autorisées à tous
                .requestMatchers("/pubic", "/public/**").permitAll()
                // Toute les pages commençant par /private sont autorisées aux personnes connectées
                .requestMatchers("/private", "/private/**").authenticated()
                .and()
                // Type d'authentification
                .httpBasic();

        // On retourne le HttpSecurity qu'on a configuré
        return http.build();
    }
}
