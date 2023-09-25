package com.example.exo3.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ContactDTO {

    private UUID id;

    @NotNull(message = "First name must not be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Names must contain only letters")
    private String firstName;

    @NotNull(message = "Last name must not be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Names must contain only letters")
    private String lastName;

    @NotNull(message = "Email must not be null")
    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "Phone must not be null")
    @Pattern(regexp = "^[+]?\\d+$", message = "Invalid phone pattern")
    private String phone;

    @NotNull(message = "Birth date must not be null")
    @Past(message = "Birth date must be a past date")
    private LocalDate birthDate;

    private Integer age;
}
