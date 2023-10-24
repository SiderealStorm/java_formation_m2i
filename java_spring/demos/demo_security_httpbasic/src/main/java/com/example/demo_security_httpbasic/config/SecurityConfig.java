package com.example.demo_security_httpbasic.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Annotation pour configuration
@Configuration
// Annotation pour préciser qu'il s'agit d'une config de sécurité
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    // Configuration de l'accès aux pages :
    // Annotation signifiant à Spring qu'il faut utiliser cette méthode pour définir tous les éléments de ce type
    @Bean
    // FilterChain ~ suite de tests d'autorisation
    // Si un test échoue, une exception peut être levée
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Configuration du HttpSecurity :
        http
                // Desactivation du CSRF (évite les erreurs de type CORS)
                .csrf().disable()
                // Pour gérer la levée d'exceptions
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .and()
                // Pour choisir les pages autorisées : requestMatchers + autorisations par groupe de pages
                .authorizeRequests()
                // Toute les pages commençant par /public sont autorisées à tous
                .requestMatchers("/pubic", "/public/**").permitAll()
                // Toute les pages commençant par /private sont autorisées aux personnes connectées
                .requestMatchers("/private", "/private/**").authenticated()
                .and()
                // Pour définir la page de login à utiliser avec HttpBasic
                .formLogin().loginPage("/auth/authenticate")
                .and()
                // Type d'authentification : seulement si on veut la connexion gérée par Spring
                .httpBasic()
                ;

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
