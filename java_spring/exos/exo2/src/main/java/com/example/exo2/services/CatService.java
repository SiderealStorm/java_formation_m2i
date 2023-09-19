package com.example.exo2.services;

import com.example.exo2.models.Cat;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatService {

    private final Map<UUID, Cat> cats;

    public CatService() {
        cats = new HashMap<>();

        Cat cat1 = Cat.builder()
                .id(UUID.randomUUID())
                .name("Poupette")
                .breed("Européen")
                .coat("Tabby")
                .age(8)
                .sociable(true)
                .build();

        Cat cat2 = Cat.builder()
                .id(UUID.randomUUID())
                .name("Cookie")
                .breed("Ragdoll")
                .coat("Poils longs")
                .age(5)
                .sociable(false)
                .build();

        Cat cat3 = Cat.builder()
                .id(UUID.randomUUID())
                .name("Melody")
                .breed("Européen")
                .coat("Noir et blanc")
                .age(12)
                .sociable(true)
                .build();

        cats.put(cat1.getId(), cat1);
        cats.put(cat2.getId(), cat2);
        cats.put(cat3.getId(), cat3);
    }

    public List<Cat> getCats() {
        return cats.values().stream().toList();
    }

    public Optional<Cat> getCatById(UUID id) {
        return cats.values().stream().filter(cat -> cat.getId().equals(id)).findFirst();
    }
}
