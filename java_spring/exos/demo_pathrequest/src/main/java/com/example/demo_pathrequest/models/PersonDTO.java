package com.example.demo_pathrequest.models;

import lombok.*;

import java.util.UUID;

// Annotations Lombok pour générer :
// les getters, setters
@Getter
@Setter
// les constructeurs (sans arguments et tous arguments)
@AllArgsConstructor
@NoArgsConstructor
// la méthode toString()
@ToString
// les méthodes equals() et hashCode()
@EqualsAndHashCode
// --> Toutes ces annotations peuvent être remplacées par l'annotation @Data
// Annotation pour pouvoir utiliser le Builder Pattern (= tous les constructeurs possibles)
@Builder
public class PersonDTO {

    // La classe UUID génère des ID uniques sous forme de texte
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;


}
