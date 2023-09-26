package com.example.exo4.services;

import com.example.exo4.exceptions.ElementNotFoundException;
import com.example.exo4.models.PokeApiResponse;
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
        String finalValue;

        // Pour les cas où l'utilisateur tape "002" :
        try {
            finalValue = String.valueOf(Integer.parseInt(value));
        } catch (NumberFormatException ex) {
            finalValue = value;
        }

        RestTemplate restTemplate = builder.build();

        // On devrait passer par le modèle PokeApiResponse, qui reprend exactement le JsonNode via Jackson
        ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity("pokemon/" + finalValue, JsonNode.class);

        if (responseEntity.getBody() != null) {
            return convertJsonNodeToPokemon(responseEntity.getBody());
        }
        return null;
    }

    // En utilisant PokeApiResponse et Jackson
    public PokeApiResponse getPokeApiResponseByNameOrId(String value) {
        String finalValue;

        // Pour les cas où l'utilisateur tape "002" :
        try {
            finalValue = String.valueOf(Integer.parseInt(value));
        } catch (NumberFormatException ex) {
            finalValue = value;
        }

        RestTemplate restTemplate = builder.build();

        ResponseEntity<PokeApiResponse> responseEntity = restTemplate.getForEntity("pokemon/" + finalValue, PokeApiResponse.class);

        PokeApiResponse pokemon = responseEntity.getBody();
        if (pokemon != null) {
            pokemon.setImageUrl(String.format(
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/%03d.png",
                    pokemon.getId()
            ));
            return pokemon;
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

    // En passant par un JsonNode, la conversion est plus gourmande en ressources
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
