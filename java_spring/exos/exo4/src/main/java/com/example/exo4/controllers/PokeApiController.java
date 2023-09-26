package com.example.exo4.controllers;

import com.example.exo4.exceptions.ElementNotFoundException;
import com.example.exo4.models.PokeApiResponse;
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
@RequestMapping("/pokeapi")
@RequiredArgsConstructor
public class PokeApiController {

    private final PokemonService service;

    @GetMapping()
    public String getDefaultPokemon() {
        int maxId = service.getPokemonCount();
        return "redirect:/pokeapi/" + new Random().nextInt(maxId);
    }

    @GetMapping("{value}")
    public String getPokemonResponse(
            @PathVariable String value,
            Model model
    ) {
        PokeApiResponse pokemon = service.getPokeApiResponseByNameOrId(value);
        int pokemonCount = service.getPokemonCount();

        if (pokemon != null) {
            model.addAttribute("pokemon", pokemon);
            model.addAttribute("count", pokemonCount);

            return "pokemon/details-v2";
        }
        throw new ElementNotFoundException();
    }

    @PostMapping("find")
    public String findPokemon(String value) {
        if (value.isBlank()) {
            return "redirect:/pokeapi";
        }
        return "redirect:/pokeapi/" + value;
    }

}
