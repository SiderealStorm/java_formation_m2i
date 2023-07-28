package org.example.demos.collections;

import java.util.ArrayList;
import java.util.Vector;

public class MainList {
    public static void main(String[] args) {

        // Déclarer une ArrayList : ArrayList<Type> nomVariable = new ArrayList<>();
        ArrayList<String> prenoms = new ArrayList<>();

        // Ajouter des éléments (à la fin de la liste)
        prenoms.add("Storm");
        prenoms.add("Alex");
        prenoms.add("Toto");
        prenoms.add("Zack");

        // Afficher un élément avec son indice
        System.out.println(prenoms.get(3));

        // Modifier un élément avec son indice
        prenoms.set(3, "Zackarie");

        // Supprimer un élément avec son indice
        prenoms.remove(2);

        // Récupérer la taille de la liste
        System.out.println("Taille de la liste : " + prenoms.size());

        // Parcourir tous les éléments avec un "for each"
        for (String element : prenoms) {
            System.out.println(element);
        }

        // Parcourir tous les éléments avec un "for"
        for (int i = 0; i < prenoms.size(); i++) {
            System.out.println("Prénom n°" + (i+1) + " : " + prenoms.get(i));
        }

        System.out.println();

        // Vecteurs

        Vector<String> vector = new Vector<>();
        vector.add("Pomme");
        vector.add("Banane");
        vector.add("Pomme");
        vector.add("Orange");

        // Les collections ont une méthode toString :
        System.out.println("Vecteur : " + vector);

        // Méthodes
        System.out.println("Taille du vecteur : " + vector.size());
        System.out.println("Elément à l'indice 1 : " + vector.get(1));
        System.out.println("Est-ce que l'élément \"banane\" est présent ? --> " + vector.contains("banane"));

    }
}
