package org.example.demos.collections;

import java.util.LinkedList;

public class MainQueue {
    public static void main(String[] args) {

        // LinkedList implémente à la fois List et Queue

        LinkedList<Double> notes = new LinkedList<>();

        notes.add(20.);
        notes.add(12.5);
        notes.add(18.);
        notes.add(16.);
        notes.add(10.75);

        System.out.println(notes);

        // Récupération :
        System.out.println("Premier élément : " + notes.getFirst());
        System.out.println("Dernier élément : " + notes.getLast());
        System.out.println("Autre élément : " + notes.get(2));

        // Suppression :
        System.out.print("Suppression du premier élément : ");
        notes.removeFirst();
        System.out.println(notes);
        System.out.print("Suppression du deuxième élément : ");
        notes.remove(1);
        System.out.println(notes);
    }
}
