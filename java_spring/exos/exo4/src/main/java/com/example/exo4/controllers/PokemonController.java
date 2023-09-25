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

@Controller
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService service;

    @GetMapping()
    public String getDefaultPokemon() {
        return "redirect:/pokemon/1";
    }

    @GetMapping("id/{id}")
    public String getPokemon(
            @PathVariable Long id,
            Model model
            ) {
        PokemonDTO pokemonDTO = service.getPokemonById(id);

        if (pokemonDTO != null) {
            model.addAttribute("pokemon", pokemonDTO);

            return "pokemon/details";
        }
        throw new ElementNotFoundException();
    }

    @GetMapping("name/{name}")
    public String getPokemon(
            @PathVariable String name,
            Model model
    ) {
        PokemonDTO pokemonDTO = service.getPokemonByName(name);

        if (pokemonDTO != null) {
            model.addAttribute("pokemon", pokemonDTO);

            return "pokemon/details";
        }
        throw new ElementNotFoundException();
    }

    @PostMapping("find")
    public String findPokemon(String name) {
        return "redirect:/pokemon/name/" + name;
    }

}
