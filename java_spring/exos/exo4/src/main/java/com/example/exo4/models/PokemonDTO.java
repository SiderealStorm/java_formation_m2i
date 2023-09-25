package com.example.exo4.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class PokemonDTO {

    private String name;
    private Long id;
    private Long order;
    private List<String> types;
    private List<String> abilities;
    private String imageUrl;
    private Integer height;
    private Integer weight;

}
