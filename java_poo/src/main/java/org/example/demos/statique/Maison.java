package org.example.demos.statique;

public class Maison {

    private String couleur;
    private int nbPortes;
    private double largeur;
    private double longueur;

    // Attributs de classes (= statiques) : communs à toutes les classes
    private static int nbMaisons;
    // On peut donner une valeur par défaut à un attribut dans la déclaration :
    public static String nomLatin = "Domus";

    public Maison() {}

    public Maison(String couleur, int nbPortes, double largeur, double longueur) {
        this.couleur = couleur;
        this.nbPortes = nbPortes;
        this.largeur = largeur;
        this.longueur = longueur;
        // A chaque création d'objet, on incrémente le nombre de maisons :
        this.nbMaisons++;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getNbPortes() {
        return nbPortes;
    }

    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    // Les getters (et setters) d'attributs statiques sont des méthodes statiques
    public static int getNbMaisons() {
        return nbMaisons;
    }

}
