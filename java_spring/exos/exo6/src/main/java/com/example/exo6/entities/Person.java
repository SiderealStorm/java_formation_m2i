package com.example.exo6.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

// Annotation JPA pour préciser que les classes enfants
// sont des entités possédant ces attributs en plus des leur,
// et que chaque classe enfant donne une table indépendante
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    protected String email;
    protected String firstName;
    protected String lastName;
    protected LocalDate birthDate;
}
