package demos;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tableaux {
    public static void main(String[] args) {

        // Déclaration d'un tableau :
        int[] ages;

        // Instanciation = allocation de la mémoire pour 4 éléments :
        ages = new int[4];

        // Instanciation + déclaration d'un tableau vide :
        String[] prenoms = new String[5];

        // Instanciation + déclaration d'un tableau avec des valeurs :
        double notes[] = {12.5, 16, 19, 15.5, 8};   // Le tableau aura une longueur de 5

        // Donner/modifier une valeur :
        prenoms[0] = "Storm";

        // Afficher une valeur :
        System.out.println(prenoms[0]);

        // Afficher tout un tableau :
        System.out.println("Notes : " + Arrays.toString(notes));

        // Parcourrir un tableau :
        for (double note : notes) {
            System.out.println(note);
        }

        // Parcourrir un tableau avec l'index :
        for (int i = 0 ; i < notes.length ; i++) {
            System.out.println("Note n°" + (i + 1) + " : " + notes[i]);
        }


        // Tableau à deux dimensions :

        String[][] titresNoms = {
                {"M.", "Mme", "Mlle"},
                {"Dupont", "Legrand"}
        };

        System.out.println(titresNoms[0][0] + " " + titresNoms[1][0]);
        System.out.println(titresNoms[0][2] + " " + titresNoms[1][1]);

        // Afficher la taille d'un tableau :
        System.out.println(titresNoms.length);
        System.out.println(titresNoms[0].length);

    }
}
