package com.example.demo_resttemplate.controllers;

import com.example.demo_resttemplate.models.PostDTO;
import com.example.demo_resttemplate.services.PostService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoRestController {

    private final PostService postService;

    @GetMapping("in-string")
    public ResponseEntity<String> getPostsAsString() {
        ResponseEntity<Map> postsAsMap = postService.getPostsAsMap();
        ResponseEntity<JsonNode> postsAsJsonNode = postService.getPostsAsJsonNode();
        return postService.getPostsAsString();
    }

    @GetMapping("in-object")
    public ResponseEntity<PostDTO[]> getPostsAsPostDto() {
        return postService.getPostsAsPostDto();
    }

    @GetMapping("in-object/title")
    public List<String> getPostsTitles() {
        return postService.getPostsTitles();
    }
}
