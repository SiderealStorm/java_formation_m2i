package org.example.demos.heritage;

public class Chien extends Animal {

    private double taille;

    public Chien(String nom, int age, String couleur, double taille) {
        super(nom, age, couleur);
        this.taille = taille;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    @Override
    public void crier() {
        System.out.println("Ouaf ouaf");
    }

    @Override
    public void manger() {
        super.manger();
        System.out.println("Le chien mange de la pâtée");
    }

    @Override
    public String toString() {
        return "Nom du chien : " + getNom() + " ; âge : " + getAge() + " ans (né en " + anneeNaissance() + ") ; taille : " + taille + " cm";
    }
}
