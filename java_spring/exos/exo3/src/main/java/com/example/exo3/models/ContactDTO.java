package com.example.exo3.models;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ContactDTO {

    private UUID id;

    // Remarque : les apostrophes ne sont pas affichées dans l'HTML
    @NotNull(message = "Ne peut pas être vide")
    @Size(min = 2, max = 100, message = "Doit comporter entre 2 et 100 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ '-]+$", message = "Ne doit comporter que des lettres, apostrophes, tirets et espaces")
    private String firstName;

    @NotNull(message = "Ne peut pas être vide")
    @Size(min = 2, max = 100, message = "Doit comporter entre 2 et 100 caractères")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ '-]+$", message = "Ne doit comporter que des lettres, apostrophes, tirets et espaces")
    private String lastName;

    @NotNull(message = "Ne peut pas être vide")
    @Size(max = 100, message = "Ne doit pas comporter plus de 100 caractères")
    @Email(message = "Format de mail invalide")
    private String email;

    @NotNull(message = "Ne peut pas être vide")
    @Size(min = 6,max = 20, message = "Doit comporter entre 2 et 100 chiffres")
    @Pattern(regexp = "^[+]?\\d+$", message = "Format de téléphone invalide")
    private String phone;

    @NotNull(message = "Ne peut pas être vide")
    @Past(message = "Date invalide (future)")
    private LocalDate birthDate;

    private Integer age;
}
