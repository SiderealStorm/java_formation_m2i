package org.example.exos.exo2;

import java.time.LocalDate;

public class Film {

    private String titre;
    private String realisateur;
    private LocalDate dateSortie;
    private String genre;

    public Film() {}

    public Film(String titre, String realisateur, LocalDate dateSortie, String genre) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.dateSortie = dateSortie;
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return titre + ", " + genre + " de " + realisateur + " sorti le " + dateSortie;
    }
}
