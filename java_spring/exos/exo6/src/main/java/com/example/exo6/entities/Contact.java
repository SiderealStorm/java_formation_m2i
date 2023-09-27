package com.example.exo6.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Contact extends Person {

    private String phone;
}
