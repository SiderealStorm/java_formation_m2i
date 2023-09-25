package com.example.demo_resttemplate.services;

import com.example.demo_resttemplate.models.PostDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class PostService {

    // Pour faire un appel API, il faut un objet RestTemplate
    // Il faut un Builder pour l'obtenir
    private final RestTemplateBuilder builder;

    // Récupération sous forme de String
    public ResponseEntity<String> getPostsAsString() {
        // Tout élément build dépend de la configuration
        RestTemplate restTemplate = builder.build();

        return restTemplate.getForEntity("/posts", String.class);
    }

    // Récupération sous forme de Map
    public ResponseEntity<Map> getPostsAsMap() {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<Map> entityMap = restTemplate.getForEntity("/posts/1", Map.class);

        return entityMap;
    }

    public ResponseEntity<JsonNode> getPostsAsJsonNode() {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<JsonNode> entityJson = restTemplate.getForEntity("https://swapi.dev/api/films", JsonNode.class);

        List<String> titles = new ArrayList<>();

        // findPath() permet de parcourir les "niveaux" du JSON
        entityJson.getBody().findPath("results").elements().forEachRemaining(e -> {
            String title = e.findPath("title").asText();
            titles.add(title);
        });

        return entityJson;
    }


    // Récupération sous forme de PostDto
    public ResponseEntity<PostDTO[]> getPostsAsPostDto() {
        RestTemplate restTemplate = builder.build();

        return restTemplate.getForEntity("/posts", PostDTO[].class);
    }

    public List<String> getPostsTitles() {
        RestTemplate restTemplate = builder.build();

        ResponseEntity<PostDTO[]> entitiy = restTemplate.getForEntity("/posts", PostDTO[].class);

        return Arrays.stream(entitiy.getBody())
                .map(p -> p.getTitle())
                .collect(Collectors.toList());
    }
}
