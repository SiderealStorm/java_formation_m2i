package org.example.exos.exo1;

/**
 * Exercice S21 : La chaise
 * 1. Créer une classe Chaise possédant comme variables d’instance le nombre de pieds, le matériaux et la couleur de l’objet
 * 2. Afficher ses informations en surchargeant une méthode de la classe Object
 * La classe Chaise pourra être instanciée avec ou sans paramètres (Constructeur par défaut)
 * 3. Afficher toutes les chaises (Possibilité de simplifier avec une méthode ToString)
 */
public class ExoMain {
    public static void main(String[] args) {

        Chaise chaise1 = new Chaise();
        chaise1.nbPieds = 4;
        chaise1.materiau = "bois";
        chaise1.couleur = "bleue";
        chaise1.prix = 29.99;

        Chaise chaise2 = new Chaise(3, "bambou", "verte", 35.99);
        Chaise chaise3 = new Chaise(5, "métal", "noire", 22);

        System.out.println(chaise1);
        System.out.println(chaise2);
        System.out.println(chaise3);
    }
}
