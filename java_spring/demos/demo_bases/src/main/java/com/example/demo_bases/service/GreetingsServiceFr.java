package com.example.demo_bases.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Annotation pour définir un service
// Le service est déclaré sur la classe, pas l'interface
// On peut ajouter des qualificatifs dans le cas où plusieurs classes implémentent la même interface
// (par défaut : nom de la classe en camelCase)
@Service("greetings")
// Les profils permettent de "grouper" des services sous un même nom de qualificatif
// Les profils sont définis pour TOUTE l'application dans application.properties
@Profile({"FR", "default"})
// Si deux services implémentent la même interface, on peut en définir une par défaut avec @Primary
// ou avec le nom de profil "default"
public class GreetingsServiceFr implements GreetingsService {

    @Override
    public String sayHello() {
        return "Bonjour tout le monde";
    }
}
