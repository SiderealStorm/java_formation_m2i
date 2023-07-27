package org.example.demos.interfaces;

// Comme la classe Forme implémente une interface, les méthodes de l'interface non implémentées dans Forme doivent l'être dans ses classes enfant
public class Cercle extends Forme {

    private double rayon;

    public Cercle(String nom, double rayon) {
        super(nom);
        this.rayon = rayon;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    // Méthodes non nécessaires à implémenter (pour pouvoir compiler)
    @Override
    public double calculerAire() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * Math.PI * rayon;
    }

    // Méthode à implémenter obligatoirement car abstraite dans Forme
    @Override
    public void afficherDetails() {
        System.out.println("Cercle " + nom + " de rayon " + rayon + " :");
        System.out.println("Périmètre : " + calculerPerimetre());
        System.out.println("Aire : " + calculerAire());
    }
}
