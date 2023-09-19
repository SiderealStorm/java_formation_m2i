package com.example.demo_bases.controller;

import com.example.demo_bases.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloController {

    // Appel au service via l'interface
    private final GreetingsService service;

    // Le service doit être injecté via le constructeur
    // Le qualificatif permet de choisir si plusieurs classes possibles (même interface)
    public HelloController(@Qualifier("greetings") GreetingsService service) {
        this.service = service;
    }


    // Autre façon d'injecter une dépendance (sur propriété publique ou setter)
    // MAIS pas une bonne pratique car possibilité de générer une NullPointerException !
//    @Autowired
//    public GreetingsService service;

    // On définit une route pour chaque méthode de requête (value est facultatif)
    @RequestMapping(value = "/hello")
    public String Hello() {
        System.out.println(service.sayHello());

        // On retourne le chemin de la vue correspondante
        return "index";
    }

    @RequestMapping(value = "/hello/person")
    public String personName(
            // Le Model est une interface qui est réceptionnée lors d'une requête
            Model model
    ) {
        List<String> languages = List.of("Java", "TypeScript", "Python");

        // Ajout d'attributs au modèle, utilisables dans la vue
        model.addAttribute("firstName", "Storm");
        model.addAttribute("languages", languages);

        return "person/detail";
    }
}
