package com.example.demo_fragments.services;

import com.example.demo_fragments.models.DogDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Primary
public class DogService {

    private final Map<UUID, DogDTO> dogs;

    public DogService() {
        dogs = new HashMap<>();

        DogDTO dogA = DogDTO.builder()
                .id(UUID.randomUUID())
                .name("Bernie")
                .breed("Labrador")
                .age(3)
                .build();

        DogDTO dogB = DogDTO.builder()
                .id(UUID.randomUUID())
                .name("Caramel")
                .breed("Breagle")
                .age(8)
                .build();

        DogDTO dogC = DogDTO.builder()
                .id(UUID.randomUUID())
                .name("Rex")
                .breed("Doberman")
                .age(6)
                .build();

        dogs.put(dogA.getId(), dogA);
        dogs.put(dogB.getId(), dogB);
        dogs.put(dogC.getId(), dogC);
    }

    public List<DogDTO> getDogs() {
        return dogs.values().stream().toList();
    }

    public Optional<DogDTO> getDogById(UUID id) {
        return dogs.values().stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public DogDTO addDog(DogDTO dogData) {
        if (dogData.getId() == null) {
            dogData.setId(UUID.randomUUID());
        }

        dogs.put(dogData.getId(), dogData);

        return dogData;
    }

    public boolean deleteDogById(UUID id) {
        Optional<DogDTO> foundDog = getDogById(id);

        if (foundDog.isPresent()) {
            dogs.remove(foundDog.get().getId());

            return true;
        }

        return false;
    }

    // Par sécurité, on passe l'ID indépendamment du chien au cas où il n'existe pas
    public DogDTO editDog(UUID id, DogDTO newDog) {
        // Création d'une référence pour pouvoir utiliser ifPresentOrElse (fonctions lambda)
        AtomicReference<DogDTO> atomicReference = new AtomicReference<>();

        Optional<DogDTO> foundDog = getDogById(id);

        foundDog.ifPresentOrElse(found -> {
            if (newDog.getName() != null) {
                found.setName(newDog.getName());
            }

            if (newDog.getBreed() != null) {
                found.setBreed(newDog.getBreed());
            }

            if (newDog.getAge() != 0) {
                found.setAge(newDog.getAge());
            }

            // On utilise l'AtomicReference car on ne peut pas faire un return dans une lambda
            atomicReference.set(found);
        }, () -> {
            atomicReference.set(null);
        });

        return atomicReference.get();
    }
}
