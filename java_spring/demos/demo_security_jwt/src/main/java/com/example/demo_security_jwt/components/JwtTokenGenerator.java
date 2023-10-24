package com.example.demo_security_jwt.components;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

// Composant pour l'authentification JWT
// Nécessite une dépendance
@Component
public class JwtTokenGenerator  {

    // La clé de cryptage est stockée dans le fichier application.properties
    @Value("${jwt.secretKey}")
    private String secretKey;

    // Génération du token
    public String generateToken(Authentication authentication) {
        // Il faut le nom d'utilisateur de la personne authentifiée
        String username = authentication.getName();
        // Un JWT doit avoir une expiration pour des questions de sécurité
        // Ici le token sera valable une journée
        Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        // Création du token via le builder du Jwts
        String token = Jwts.builder()
                // On ajoute les données précédentes
                .setSubject(username)
                .setExpiration(expirationDate)
                // Date de création = maintenant
                .setIssuedAt(new Date())
                // Configuration de l'encryptage
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token;
    }

    // Extraction des données (utilisateur) du token
    public String getUserFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                // Une fois build, on peut lire les données du token
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // Vérification de la validation du token
    public Boolean validateToken(String token) {
        // Un token est valide s'il ne lève aucune exception ;
        // on fait donc un try/catch
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            // On lève une exception précise si le token n'est pas valide
            throw new AuthenticationCredentialsNotFoundException("JWT token not valid");
        }
    }
}
