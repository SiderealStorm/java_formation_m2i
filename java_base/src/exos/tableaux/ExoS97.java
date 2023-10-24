package exos.tableaux;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Exercice S97 : Tableaux égaux
 * 1. Ecrire un programme qui permet de vérifier si 2 tableaux sont égaux
 * 2. Vérifier la taille des tableaux et l'ordre des valeurs
 * BONUS : saisie utilisateur
 */
public class ExoS97 {
    public static void main(String[] args) {
        int[] tableau1, tableau2;
        boolean sontEgaux = true;
        Scanner scanner = new Scanner(System.in);

        // Saisie des tableaux :

        System.out.println("=== Saisie du premier tableau ===");
        System.out.println("Combien voulez-vous saisir de valeurs ?");
        tableau1 = new int[scanner.nextInt()];
        for (int i = 0 ; i < tableau1.length ; i++) {
            System.out.println("Saisir la valeur n°" + (i + 1));
            tableau1[i] = scanner.nextInt();
        }

        System.out.println("=== Saisie du deuxième tableau ===");
        System.out.println("Combien voulez-vous saisir de valeurs ?");
        tableau2 = new int[scanner.nextInt()];
        for (int i = 0 ; i < tableau2.length ; i++) {
            System.out.println("Saisir la valeur n°" + (i + 1));
            tableau2[i] = scanner.nextInt();
        }

        // Vérification de l'égalité des tableaux :

        System.out.println("Tableau n°1 : " + Arrays.toString(tableau1));
        System.out.println("Tableau n°2 : " + Arrays.toString(tableau2));

        if (tableau1.length == tableau2.length) {
            for (int i = 0; i < tableau1.length; i++) {
                if (tableau1[i] != tableau2[i]) {
                    sontEgaux = false;
                    break;
                }
            }
        } else {
            sontEgaux = false;
        }

        if (sontEgaux) {
            System.out.println("Les deux tableaux sont égaux");
        } else {
            System.out.println("Les deux tableaux ne sont pas égaux");
        }

        scanner.close();
    }
}
