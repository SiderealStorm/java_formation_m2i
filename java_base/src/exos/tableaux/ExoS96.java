package exos.tableaux;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Exercice S96 : Valeur maximale
 * Ecrire un programme qui permet de trouver la valeur maximale dans un tableau
 * BONUS : saisie utilisateur
 */
public class ExoS96 {
    public static void main(String[] args) {
        int[] tableau;
        int nbValeurs, valMax;
        int indiceMax = -1;
        Scanner scanner = new Scanner(System.in);

        // Saisie du tableau :

        System.out.println("Combien voulez-vous saisir de valeurs ?");
        nbValeurs = scanner.nextInt();
        tableau = new int[nbValeurs];

        for (int i = 0 ; i < tableau.length ; i++) {
            System.out.println("Saisir la valeur n°" + (i + 1));
            tableau[i] = scanner.nextInt();
        }

        // Recherche du maximum :

        valMax = tableau[0];
        indiceMax = 0;

        for (int i = 1 ; i < tableau.length ; i++) {
            if (tableau[i] > valMax) {
                indiceMax = i;
                valMax = tableau[i];
            }
        }

        System.out.println("Valeurs : " + Arrays.toString(tableau));
        System.out.println("La valeur maximale est la valeur n°" + (indiceMax + 1) + " : " + valMax);

        scanner.close();
    }
}
