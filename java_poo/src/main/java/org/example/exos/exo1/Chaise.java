package org.example.exos.exo1;

import javax.swing.plaf.basic.BasicFormattedTextFieldUI;

public class Chaise {

    public int nbPieds;
    public String materiau;
    public String couleur;
    public double prix;

    public Chaise() {}

    public Chaise(int nbPieds, String materiau, String couleur, double prix) {
        this.nbPieds = nbPieds;
        this.materiau = materiau;
        this.couleur = couleur;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Chaise " + couleur + " en " + materiau + " avec " + nbPieds + " pieds à " + prix + " €";
    }

}
