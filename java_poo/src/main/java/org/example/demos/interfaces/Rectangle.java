package org.example.demos.interfaces;

public class Rectangle extends Forme {

    private double longueur;
    private double largeur;

    public Rectangle(String nom, double longueur, double largeur) {
        super(nom);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * (longueur + largeur);
    }

    @Override
    public double calculerAire() {
        return longueur * largeur;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Rectangle de longueur " + longueur + " et de largeur " + largeur);
        System.out.println("Périmètre : " + calculerPerimetre());
        System.out.println("Aire : " + calculerAire());
    }
}
