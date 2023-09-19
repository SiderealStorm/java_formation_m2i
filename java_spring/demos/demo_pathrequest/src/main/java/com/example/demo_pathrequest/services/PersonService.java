package com.example.demo_pathrequest.services;

import com.example.demo_pathrequest.models.PersonDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

// Annotation Spring pour permettre l'injection en tant que service
@Service
@Primary    // Ce service sera celui par défaut
public class PersonService {

    private final Map<UUID, PersonDTO> persons;

    public PersonService() {
        persons = new HashMap<>();

        // Ajout de personnes pour l'exemple :
        // Utilisation du Builder
        PersonDTO personA = PersonDTO.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .age(32)
                .build();

        PersonDTO personB = PersonDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Jack")
                .lastName("Doe")
                .age(32)
                .build();

        PersonDTO personC = PersonDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Jane")
                .lastName("Doe")
                .age(32)
                .build();

        persons.put(personA.getId(), personA);
        persons.put(personB.getId(), personB);
        persons.put(personC.getId(), personC);
    }

    public List<PersonDTO> getPersons() {
        // Récupérer les valeurs d'un HashMap sous forme de liste
        return persons.values().stream().toList();
    }

    public PersonDTO getPersonById(UUID id) {
        Optional<PersonDTO> foundPerson = persons.values().stream().filter(person -> person.getId().equals(id)).findFirst();
        // La méthode orElse() permet de définir une valeur à retourner s'il n'y en a pas
        return foundPerson.orElse(null);
    }

    // Même méthode avec un optionnel :
//    public Optional<PersonDTO> getPersonById(UUID id) {
//        // L'utilisation d'un optionnel permet d'évier les NullPointerException
//        return persons.values().stream().filter(person -> person.getId().equals(id)).findFirst();
//    }
}
