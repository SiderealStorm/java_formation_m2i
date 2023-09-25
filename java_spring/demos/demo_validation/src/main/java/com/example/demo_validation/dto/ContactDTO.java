package com.example.demo_validation.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {

    private Long id;

    // Ajout de critères de validation
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    // Possibilité d'ajouter des messages personnalisés
    @Email(message = "Invalid email")
    @NotNull
    private String email;

    // Possibilité de vérifier via un pattern RegEx
//    @Pattern(regexp = "")
    @NotNull
    private String phone;

    @Min(0)
    @Max(120)
    private Integer age;
}
