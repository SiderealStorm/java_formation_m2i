package org.example.demos.collections;

import java.util.HashMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MainMap {
    public static void main(String[] args) {
        // TODO inverser les chats et les moyennes AVANT de push !

        HashMap<String, Integer> agesChats = new HashMap<>();

        // Ajouter des valeurs :
        agesChats.put("Poupette", 8);
        agesChats.put("Cookie", 4);
        agesChats.put("Melody", 10);
        // Si on essaie d'ajouter une clé existante, on modifie juste la valeur à cette clé
        agesChats.put("Melody", 11);

        System.out.println("Âge des chats : " + agesChats);

        // Méthodes :
        System.out.println("Taille de la collection : " + agesChats.size());
        System.out.println("Liste des clés : " + agesChats.keySet());
        System.out.println("Liste des valeurs : " + agesChats.values());
        System.out.println("Valeur à la clé \"Cookie\" : " + agesChats.get("Cookie"));
        System.out.println("Est-ce que la clé \"Poupette\" existe ? --> " + agesChats.containsKey("Poupette"));
        System.out.println("Est-ce que la valeur \"10\" existe ? --> " + agesChats.containsValue(10));
        System.out.print("Suppression de la clé \"Melody\" : ");
        agesChats.remove("Melody");
        System.out.println(agesChats);

        System.out.println("-----------------------------------------------------------------------");

        // Map ordonnée (par rapport aux clés)

        SortedMap<String, Double> moyennes = new TreeMap<>();

        // Ajouter des valeurs :
        moyennes.put("Maths", 16.5);
        moyennes.put("Chimie", 17.);
        moyennes.put("Français", 14.);
        moyennes.put("Histoire", 12.);
        moyennes.put("Philo", 8.);

        System.out.println("Moyennes par matière : " + moyennes);

        // Méthodes :
        System.out.println("Liste des clés : " + moyennes.keySet());
        System.out.println("Liste des valeurs : " + moyennes.values());
        System.out.print("Suppression de \"Philo\" : ");
        agesChats.remove("Philo");
        System.out.println(moyennes);

    }
}
