package com.example.exo2.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Cat {

    private UUID id;
    private String name;
    private String breed;
    private String coat;
    private int age;
    private boolean sociable;

}
