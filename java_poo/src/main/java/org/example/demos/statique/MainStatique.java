package org.example.demos.statique;

public class MainStatique {
    public static void main(String[] args) {

        // Pour accéder à un attribut ou une méthode statique, on utilise le nom de la classe
        // Les méthodes et attributs statiques sont accessibles même si aucun objet n'est instancié
        System.out.println("Nombre de maisons : " + Maison.getNbMaisons());
        System.out.println("En latin Maison = " + Maison.nomLatin);

        Maison maison1 = new Maison("Rouge", 4, 12.5, 20);

        System.out.println("Couleur de la maison 1 : " + maison1.getCouleur());

        Maison maison2 = new Maison("Bleu", 5, 4, 25);

        System.out.println("Nombre de maisons : " + Maison.getNbMaisons());

        System.out.println();

        // Exemple de méthodes et attributs tatiques de Java :

        System.out.println("Nombre aléatoire : " + Math.random());
        System.out.println("Arrondi : " + Math.round(11.997527254));
        System.out.println("Valeur de Pi : " + Math.PI);

    }
}
