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

    @NotNull(message = "First name must not be null")
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
    private String firstName;

    @NotNull(message = "Last name must not be null")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters")
    private String lastName;

    @NotNull(message = "Email must not be null")
    @Size(max = 100, message = "Email must be less than 100 characters long")
    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "Phone must not be null")
    @Size(min = 6,max = 20, message = "Phone must be between 6 and 20 characters long")
    @Pattern(regexp = "^[+]?\\d+$", message = "Invalid phone pattern")
    private String phone;

    @NotNull(message = "Birth date must not be null")
    @Past(message = "Birth date must be a past date")
    private LocalDate birthDate;

    private Integer age;
}
