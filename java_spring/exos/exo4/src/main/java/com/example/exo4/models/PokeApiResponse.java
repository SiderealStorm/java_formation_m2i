package com.example.exo4.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/*
    Pour récupérer TOUTES les données de l'API (qui pourraient être utiles plus tard, on crée des InnerClass
    Les classes doivent être statiques pour être accessibles avant que la classe mère ne soit instanciée
    Toutes les classes doivent avoir les annotations Lombok
 */
@Data
@Builder
public class PokeApiResponse {

    @Data
    @Builder
    public static class AbilitySummary
    {
        private String name;
        private String url;
    }

    @Data
    @Builder
    public static class Ability
    {
        private Ability ability;
        private boolean is_hidden;
        private int slot;
    }

    @Data
    @Builder
    public static class TypeSummary {
        private String name;
        private String url;
    }

    @Data
    @Builder
    public static class Type {
        private int slot;
        private Type type;
    }

    private int id;
    private String name;
    private int height;
    private int weight;
    private List<AbilitySummary> abilities;
    private List<TypeSummary> types;

}
