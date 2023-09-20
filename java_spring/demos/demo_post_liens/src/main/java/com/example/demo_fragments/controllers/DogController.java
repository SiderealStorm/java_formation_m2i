package com.example.demo_fragments.controllers;

import com.example.demo_fragments.exceptions.ResourceNotFoundException;
import com.example.demo_fragments.models.DogDTO;
import com.example.demo_fragments.services.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/dogs")
@RequiredArgsConstructor
// Annotation Lombok permettant de créer un Logger, pour afficher des messages console plus pertinants
@Slf4j
public class DogController {

    private final DogService dogService;

    @GetMapping
    public String listDogs(
            Model model,
            // Pour ajouter des paramètres optionnels :
            @RequestParam(value = "name", defaultValue = "") String filterByName
            // On peut aussi utiliser required = false mais dans ce cas la valeur peut être null
    ) {
        List<DogDTO> dogs = dogService.getDogs();

        // Exemple d'utilisation du logger :
        log.info("Filter by letter : " + filterByName);
        log.error("Filter by letter : " + filterByName);
        log.warn("Filter by letter : " + filterByName);

        // Syntaxe dans l'URL : http://localhost:8080/dogs?name=texte

        if (!filterByName.isEmpty() && !filterByName.isBlank()) {
            dogs = dogs.stream().filter(d -> d.getName().startsWith(filterByName)).toList();
        }

        model.addAttribute("dogs", dogs);

        return "dogs/list";
    }

    @GetMapping("{dogId}")
    public String dogDetails(@PathVariable("dogId") UUID id, Model model) {
        Optional<DogDTO> foundDog = dogService.getDogById(id);

        if (foundDog.isPresent()) {
            model.addAttribute("dog", foundDog.get());
            model.addAttribute("mode", "details");

            return "dogs/form";
        }

        throw new ResourceNotFoundException();
    }

    @GetMapping("add")
    public String getDogForm(Model model) {
        model.addAttribute("dog", DogDTO.builder().build());
        model.addAttribute("mode", "add");

        return "dogs/form";
    }

    // Pour le POST, on peut utiliser la même route que le GET car le mode est différent
    @PostMapping("add")
    public String addDog(DogDTO dogDTO) {
        dogService.addDog(dogDTO);

        // Pour faire une redirection :
        return "redirect:/dogs";
    }

    // Pour supprimer, on utilise un POST
    @PostMapping("delete/{dogId}")
    public String deleteDogById(@PathVariable("dogId") UUID id) {
        // TODO faire la méthode de suppression

        return "redirect:/dogs";
    }
}
