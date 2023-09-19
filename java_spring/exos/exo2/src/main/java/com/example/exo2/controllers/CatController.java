package com.example.exo2.controllers;

import com.example.exo2.exceptions.ResourceNotFoundException;
import com.example.exo2.models.Cat;
import com.example.exo2.services.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("listing")
    public String catsList(Model model) {
        List<Cat> cats = catService.getCats();

        model.addAttribute("cats", cats);
        return "cats/listing";
    }

    @GetMapping("details/{catId}")
    public String catDetails(@PathVariable("catId") UUID id, Model model) {
        Optional<Cat> foundCat = catService.getCatById(id);

        if (foundCat.isPresent()) {
            System.out.println(foundCat.get());
            model.addAttribute("cat", foundCat.get());
            return "cats/details";
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
