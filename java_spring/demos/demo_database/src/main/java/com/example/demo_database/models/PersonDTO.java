package com.example.demo_database.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

// Annotations Lombok
@Data
@Builder
public class PersonDTO {

    private UUID id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private int age;
}
