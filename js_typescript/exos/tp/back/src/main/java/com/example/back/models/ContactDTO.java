package com.example.back.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ContactDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Integer age;
    private String email;
    private String phone;
}
