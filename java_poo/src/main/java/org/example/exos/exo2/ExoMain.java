package org.example.exos.exo2;

import java.time.LocalDate;

/**
 * Exercice S22 : Film
 * 1. Créer une classe "Film"
 * 2. Ajouter les attributs suivants : titre, réalisateur, année de sortie et genre
 * 3. Ajouter un constructeur, des getters et des setters pour ces attributs, ainsi qu'une méthode pour afficher les informations sur le film
 */
public class ExoMain {
    public static void main(String[] args) {

        Film film1 = new Film();
        film1.setTitre("La Haine");
        film1.setRealisateur("Mathieu Kassovitz");
        film1.setDateSortie(LocalDate.of(1995, 5, 31));
        film1.setGenre("drame");

        Film film2 = new Film("Avatar 2", "James Cameron", LocalDate.of(2022, 12, 14), "film d'action");

        System.out.println(film1);
        System.out.println(film2);

        LocalDate date = LocalDate.of(2019, 07, 29);
        System.out.println(date);
    }
}
