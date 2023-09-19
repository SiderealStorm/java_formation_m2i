package com.example.exo2.controllers;

import com.example.exo2.exceptions.ResourceNotFoundException;
import com.example.exo2.models.Cat;
import com.example.exo2.services.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cats")
@RequiredArgsConstructor
public class CatRestController {

    private final CatService catService;

    @GetMapping("listing")
    public List<Cat> catsList() {
        return catService.getCats();
    }

    @GetMapping("details/{catId}")
    public ResponseEntity<Cat> catDetails(@PathVariable("catId") UUID id) {
        Optional<Cat> foundCat = catService.getCatById(id);

        if (foundCat.isPresent()) {
            return ResponseEntity.ok(foundCat.get());
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
