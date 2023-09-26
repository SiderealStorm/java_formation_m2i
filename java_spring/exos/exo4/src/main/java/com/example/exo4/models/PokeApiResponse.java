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
    public static class AbilitySummary {
        private Integer slot;
        private Boolean is_hidden;
        private Ability ability;
    }

    @Data
    @Builder
    public static class Ability {
        private String name;
        private String url;
    }

    @Data
    @Builder
    public static class TypeSummary {
        private Integer slot;
        private Type type;
    }

    @Data
    @Builder
    public static class Type {
        private String name;
        private String url;
    }



    private Integer id;
    private String imageUrl;
    private String name;
    private Integer height;
    private Integer weight;
    private List<AbilitySummary> abilities;
    private List<TypeSummary> types;

}
