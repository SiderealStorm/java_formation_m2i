package org.example.exos.exo5;

public class Plante {

    private String nom;
    private double hauteur;
    private String couleurFeuilles;

    public Plante() {}

    public Plante(String nom, double hauteur, String couleurFeuilles) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleurFeuilles = couleurFeuilles;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getHauteur() {
        return this.hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public String getCouleurFeuilles() {
        return this.couleurFeuilles;
    }

    public void setCouleurFeuilles(String couleurFeuilles) {
        this.couleurFeuilles = couleurFeuilles;
    }

    @Override
    public String toString() {
        return "Plante : " + nom + ", hauteur : " + hauteur + " cm, couleur des feuilles : " + couleurFeuilles;
    }
}
