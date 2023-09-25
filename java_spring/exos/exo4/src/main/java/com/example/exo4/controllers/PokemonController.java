package com.example.exo4.controllers;

import com.example.exo4.exceptions.ElementNotFoundException;
import com.example.exo4.models.PokemonDTO;
import com.example.exo4.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService service;

    @GetMapping()
    public String getDefaultPokemon() {
        int maxId = service.getPokemonCount();
        return "redirect:/pokemon/" + new Random().nextInt(maxId);
    }

    @GetMapping("{value}")
    public String getPokemon(
            @PathVariable String value,
            Model model
            ) {
        PokemonDTO pokemonDTO = service.getPokemonByNameOrId(value);
        int pokemonCount = service.getPokemonCount();

        if (pokemonDTO != null) {
            model.addAttribute("pokemon", pokemonDTO);
            model.addAttribute("count", pokemonCount);

            return "pokemon/details";
        }
        throw new ElementNotFoundException();
    }

    @PostMapping("find")
    public String findPokemon(String value) {
        if (value.isBlank()) {
            return "redirect:/pokemon";
        }
        return "redirect:/pokemon/" + value;
    }

}
