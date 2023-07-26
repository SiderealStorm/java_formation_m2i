package org.example.exos.exo5;

public class Arbre extends Plante {

    private double circonference;

    public Arbre() {}

    public Arbre(String nom, double hauteur, String couleurFeuilles, double circonference) {
        super(nom, hauteur, couleurFeuilles);
        this.circonference = circonference;
    }

    public double getCirconference() {
        return this.circonference;
    }

    public void setCirconference(double circonference) {
        this.circonference = circonference;
    }

    @Override
    public String toString() {
        return super.toString() + ", circonférence du tronc : " + circonference + " cm";
    }

}
