package com.example.demo_security_jwt.config;

import com.example.demo_security_jwt.components.JwtAuthenticationFilter;
import com.example.demo_security_jwt.components.JwtTokenGenerator;
import com.example.demo_security_jwt.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// Annotation pour configuration
@Configuration
// Annotation pour préciser qu'il s'agit d'une config de sécurité
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    // Injections pour le Bean JwtAuthenticationFilter :
    private final JwtTokenGenerator jwtTokenGenerator;
    private final CustomUserDetailsService customUserDetailsService;

    // Pour injecter le JwtAuthenticationFilter, il faut passer par un @Bean
    // Cette injection se fera après les autres, ce qui évite de "boucler"
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtTokenGenerator, customUserDetailsService);
    }

    // Configuration de l'accès aux pages :
    // Annotation signifiant à Spring qu'il faut utiliser cette méthode pour définir tous les éléments de ce type
    @Bean
    // FilterChain ~ suite de tests d'autorisation
    // Si un test échoue, une exception peut être levée
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Configuration du HttpSecurity :
        http
                // Ajout du filtre JWT (pour API)
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                // Desactivation du CSRF (évite les erreurs de type CORS)
                .csrf().disable()
                // Pour retirer le mécanisme de session de l'application (= API seulement)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // Pour gérer la levée d'exceptions
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .and()
                // Pour choisir les pages autorisées : requestMatchers + autorisations par groupe de pages
                .authorizeRequests()
                // Toute les pages commençant par /public sont autorisées à tous
                .requestMatchers("/api/v1/pubic", "/api/v1/public/**", "/api/v1/auth/**").permitAll()
                // Toute les pages commençant par /private sont autorisées aux personnes connectées
                .requestMatchers("/api/v1/private", "/api/v1/private/**").authenticated();

        // On retourne le HttpSecurity qu'on a configuré
        return http.build();
    }

    // Configuration pour gérer la connexion :
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        // Cette configuration nécessite une BDD (et donc un repo)
        return configuration.getAuthenticationManager();
    }

    // Configuration de l'encodage des mots de passe :
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Fait un hashage par défaut ; hasher plus est plus sûr mais prend plus de temps
        return new BCryptPasswordEncoder();
    }

}
