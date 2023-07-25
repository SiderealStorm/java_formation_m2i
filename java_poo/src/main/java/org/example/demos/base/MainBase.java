package org.example.demos.base;

public class MainBase {
    public static void main(String[] args) {

        // Utilisation de la classe "Voiture"

        // Instanciation d'un objet
        System.out.println("--------------- Voiture 1 ----------------");
        Voiture v1 = new Voiture();

        // Accéder à un attribut public

        v1.couleur = "Rouge";
        System.out.println("Couleur : " + v1.couleur);

        // Exécution d'un méthode d'instance

        v1.demarrer();
        v1.faireLePlein(20);
        System.out.println("Carburant actuel : " + v1.carburant + "L");
        v1.demarrer();

        // Utilisation des différents constructeurs

        System.out.println("--------------- Voiture 2 ----------------");
        Voiture v3 = new Voiture("Bleu");
        System.out.println("--------------- Voiture 3 ----------------");
        Voiture v2 = new Voiture("Noir", 20, 120);
        System.out.println("--------------- Voiture 4 ----------------");
        Voiture v4 = new Voiture("Gris", 40, 70, "Toyota", 5);

        double chevauxFiscaux = v4.puissanceFiscale();
        System.out.println("Puissance fiscale : " + chevauxFiscaux);

        System.out.println(v4);

    }
}
