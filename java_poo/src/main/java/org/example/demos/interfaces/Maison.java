package org.example.demos.interfaces;

public class Maison implements Calculable {

    private String couleur;
    private double surface;

    public Maison(String couleur, double surface) {
        this.couleur = couleur;
        this.surface = surface;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Maison de couleur " + couleur + ", de surface habitable " + surface + " m²";
    }

    @Override
    public double calculerAire() {
        return this.surface;
    }
}
