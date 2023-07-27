package org.example.demos.liste;

import java.util.ArrayList;

public class MainListe {
    public static void main(String[] args) {

        // Déclarer une ArrayList : ArrayLis<Type> nomVariable = new ArrayList<>();
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

    }
}
