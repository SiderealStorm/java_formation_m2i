package org.example.demos.interfaces;

// Pour appliquer une interface à une classe, on utilise le mot-clé "implements"
// On n'est pas obligé d'implémenter les méthodes dans une classe abstraite
public abstract class Forme implements Calculable {

    protected String nom;

    public Forme(String nom) {
        this.nom = nom;
    }

    // Les méthodes abstraites n'ont pas d'implémentation
    public abstract void afficherDetails();

    @Override
    public double calculerAire() {
        return 0;
    }

    public static String compareAires(Forme forme1, Forme forme2) {
        double aire1 = forme1.calculerAire();
        double aire2 = forme2.calculerAire();
        if (aire1 > aire2) {
            return forme1.nom + " a une plus grande aire que " + forme2.nom;
        } else if (aire1 < aire2) {
            return forme2.nom + " a une plus grande aire que " + forme1.nom;
        } else {
            return "Les deux aires sont égales";
        }
    }

}
