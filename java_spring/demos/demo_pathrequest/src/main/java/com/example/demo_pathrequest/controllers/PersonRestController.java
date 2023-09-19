package com.example.demo_pathrequest.controllers;

import com.example.demo_pathrequest.exceptions.ResourceNotFoundException;
import com.example.demo_pathrequest.models.PersonDTO;
import com.example.demo_pathrequest.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

// Annotations Spring pour définir un controller et son URL de base
@RestController
@RequestMapping("/api/v1/persons")  // Penser à mettre le slash
// Annotation Lombok pour générer le constructeur complet
@RequiredArgsConstructor
public class PersonRestController {

    // Service injecté
    private final PersonService personService;

    // Annotation Spring pour une méthode de requête GET
    @GetMapping("list")     // Ici le slash se met automatiquement
    public List<PersonDTO> listPersons() {
        return personService.getPersons();
    }

    // On peut récupérer des variables depuis l'URL avec la notation {var}
    @GetMapping("details/{personId}")
    public ResponseEntity<PersonDTO> getPerson(
            // Pour récupérer l'élément de l'URL, on déclare une variable avec @PathVariable
            // On peut choisir un autre nom pour la variable en précisant le nom d'origine entre parenthèses
            @PathVariable("personId") UUID id
    ) {
        PersonDTO foundPerson = personService.getPersonById(id);

        // En retournant une ResponseEntity, on peut gérer le cas où l'élément n'est pas trouvé
        if (foundPerson != null) {
            // Si la personne existe, on la retourne avec le statut OK...
            return ResponseEntity.ok(foundPerson);
        } else {
            // ... Sinon on génère une exception de type erreur 404 - Not found
            throw new ResourceNotFoundException();
        }
    }



}
