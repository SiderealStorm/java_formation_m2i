package com.example.demo_bases.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Annotation pour définir un controller
// Le controller réceptionne des requêtes et retourne
@Controller
public class BaseController {

    @RequestMapping(value = "/")
    // Si controlleur d'API : peut retourner des objets, qui seront traduits par Spring en JSON
    public String index() {
        // Ici controlleur classique : on retourne le chemin de la page HTML à afficher (vue)
        // Les vues doivent se trouver dans le dossier "templates"
        return "index";
    }
}
