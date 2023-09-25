package com.example.exo4.services;

import com.example.exo4.exceptions.ElementNotFoundException;
import com.example.exo4.models.PokemonDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final RestTemplateBuilder builder;

    public PokemonDTO getPokemonByNameOrId(String value) {
        RestTemplate restTemplate = builder.build();

        try {
            ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity("pokemon/" + value, JsonNode.class);

            if (responseEntity.getBody() != null) {
                return convertJsonNodeToPokemon(responseEntity.getBody());
            }
        } catch (RestClientException e) {
            throw new ElementNotFoundException();
        }
        return null;
    }

    public Integer getPokemonCount() {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity("pokedex/1", JsonNode.class);

        if (responseEntity.getBody() != null) {
            return responseEntity.getBody().get("pokemon_entries").size();
        }
        return null;
    }

    public PokemonDTO convertJsonNodeToPokemon(JsonNode jsonNode) {
        PokemonDTO pokemonDTO = PokemonDTO.builder()
                .id(jsonNode.get("id").asLong())
                .name(jsonNode.get("name").asText())
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
