package org.example.exos.exo5;

/**
 * Exercice S27 : Plante
 * 1. Créer une classe "Plante" avec les attributs suivants : nom, hauteur et couleur des feuilles
 * 2. Ajouter un constructeur, des getters et des setters pour ces attributs
 * 3. Créer une méthode pour afficher les informations sur la plante
 * 4. Créer une classe "Arbre" qui hérite de "Plante" et qui ajoute un attribut supplémentaire pour la circonférence du tronc
 * 5. Surcharger la méthode afficher pour qu'elle ajoute les informations à propos de l'arbre
 */
public class ExoMain {
    public static void main(String[] args) {

        Plante plante = new Plante("Iris", 30, "vert");
        System.out.println(plante);

        Arbre arbre = new Arbre("Chêne", 300, "vert", 35);
        System.out.println(arbre);
    }
}
