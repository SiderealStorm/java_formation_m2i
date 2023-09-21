package com.example.demo_database.repositories;

import com.example.demo_database.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

// En héritant de JpaReposoitory, on accède par défaut à toutes les méthodes de base
public interface PersonRepository extends JpaRepository<Person, UUID> {

    // Créer des méthodes cursom avec les mots-clés reconnus par JPA = Query Methods
    List<Person> findAllByFirstNameStartingWith(String value);
    Long countAllByFirstNameStartingWith(String value);
}
