package org.example.demos.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MainSet {
    public static void main(String[] args) {

        // SortedSet = interface donc non implémentable
        SortedSet<String> competences = new TreeSet<>();

        competences.add("Java");
        // Doublons non autorisés, mais pas de levée d'exception
        competences.add("Java");
        competences.add("Java");

        System.out.println(competences);

        // Les valeurs sont ordonnées (ici ordre alphabétique)
        competences.add("Python");
        competences.add("JavaScript");
        competences.add("PostgreSQL");
        competences.add("MySQL");
        competences.add("Angular");

        System.out.println(competences);

        // Méthodes :
        System.out.println("Premier élément : " + competences.first());
        System.out.println("Dernier élément : " + competences.last());
        System.out.println("Deuxième élément : pas possible !");
        System.out.println("Sous-ensemble avant la valeur \"MySQL\" (non incluse) : "
                + competences.headSet("MySQL"));
        System.out.println("Sous-ensemble à partir de la valeur \"MySQL\" (incluse) : "
                + competences.tailSet("MySQL"));

    }
}
