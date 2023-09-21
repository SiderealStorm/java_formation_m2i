package com.example.demo_fragments.controllers;

import com.example.demo_fragments.exceptions.ResourceNotFoundException;
import com.example.demo_fragments.models.DogDTO;
import com.example.demo_fragments.services.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dogs")
@RequiredArgsConstructor
@Slf4j
public class DogRestController {

    private final DogService dogService;

    @GetMapping
    public List<DogDTO> listDogs() {
        // Exemple de commentaire de débug
        log.debug("GET to /api/v1/dogs/list");

        return dogService.getDogs();
    }

    @GetMapping("{dogId}")
    public DogDTO dogDetails(@PathVariable("dogId") UUID id) {
        Optional<DogDTO> foundDog = dogService.getDogById(id);

        if (foundDog.isPresent()) {
            return foundDog.get();
        }

        throw new ResourceNotFoundException();
    }

    @PostMapping("add")
    public ResponseEntity<String> addDogHandler(
            // Pour récupérer un élément dans le corps de la requête :
            @RequestBody DogDTO newDog
    ) {
        DogDTO dogDTO = dogService.addDog(newDog);

        return new ResponseEntity<>("Dog created with id : " + dogDTO.getId(), HttpStatus.CREATED);
    }

    // Dans une API, on peut aussi faire des requêtes de type PUT/PATCH et DELETE

    // La route peut être identique car la requête est différente
    @DeleteMapping("{dogId}")
    public ResponseEntity<String> deleteDogHandler(@PathVariable("dogId") UUID id) {
        Optional<DogDTO> foundDog = dogService.getDogById(id);

        if (foundDog.isPresent()) {
            if (dogService.deleteDogById(id)) {
                return new ResponseEntity<>("Dog deleted at ID : " + id, HttpStatus.OK);
            }

            return new ResponseEntity<>("Something went wrong... ", HttpStatus.NOT_MODIFIED);
        }

        throw new ResourceNotFoundException();
    }

    // PUT vs. PATCH :
    // PATCH modifie les propriétés d'un élément déjà présent en BDD
    // --> plus rapide
    // PUT modifie TOUTES les propriétés de l'élément si il existe, sinon ajoute l'élément en BDD
    // --> peut provoquer des modifications indésirables (propriétés passant à null)

    @PatchMapping("{dogId}")
    public DogDTO editDog(@PathVariable("dogId") UUID id, @RequestBody DogDTO dogData) {
        Optional<DogDTO> foundDog = dogService.getDogById(id);

        if (foundDog.isPresent()) {
            return dogService.editDog(id, dogData);
        }

        throw new ResourceNotFoundException();
    }
}
