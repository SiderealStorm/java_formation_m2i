package com.example.exo4.services;

import com.example.exo4.exceptions.ElementNotFoundException;
import com.example.exo4.models.PokemonDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final RestTemplateBuilder builder;

    public PokemonDTO getPokemonById(Long id) {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity("pokemon/" + id, JsonNode.class);

        if (responseEntity.getBody() != null) {

            return convertJsonNodeToPokemon(responseEntity.getBody());
        }
        return null;
    }

    public PokemonDTO getPokemonByName(String name) {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity("pokemon/" + name, JsonNode.class);

        if (responseEntity.getBody() != null) {
            return convertJsonNodeToPokemon(responseEntity.getBody());
        }
        return null;
    }

    public PokemonDTO convertJsonNodeToPokemon(JsonNode jsonNode) {
        PokemonDTO pokemonDTO = PokemonDTO.builder()
                .id(jsonNode.get("id").asLong())
                .name(jsonNode.get("name").asText())
                .order(jsonNode.get("order").asLong())
                .types(new ArrayList<>())
                .abilities(new ArrayList<>())
                .height(jsonNode.get("height").asInt())
                .weight(jsonNode.get("weight").asInt())
                .imageUrl(jsonNode.findPath("sprites").get("front_default").asText())
                .build();

        jsonNode.findPath("types").elements().forEachRemaining(e ->
                pokemonDTO.getTypes().add(e.findPath("type").get("name").asText()));

        jsonNode.findPath("abilities").elements().forEachRemaining(e ->
                pokemonDTO.getAbilities().add(e.findPath("ability").get("name").asText()));

        return pokemonDTO;
    }
}
