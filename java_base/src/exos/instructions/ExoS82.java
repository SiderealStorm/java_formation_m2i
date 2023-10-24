package exos.instructions;

import java.util.Scanner;

/**
 * Exercice S82 : Sommes consécutives
 * 1. Déclarer une variable nombre
 * 2. À l'aide de boucles, afficher les suites de nombres qui permettent d'arriver au nombre inscrit précédemment
 */
public class ExoS82 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez un nombre entier :");
        int nombre = scanner.nextInt();

        // Si nombre = 45, inutile de tester au-delà de i = 22 (22 + 23)
        for (int i = 1 ; i < nombre / 2 + 1 ; i++) {
            int somme = 0;
            String suite = nombre + " = ";
            // Dans l'absolu on peut limiter j à (nombre / 2 + 2) mais avec le "break", la boucle s'arrête quoi qu'il arrive
            for (int j = i ; j < nombre ; j++) {
                suite += j;
                somme += j;
                if (somme > nombre) {
                    // Inutile de continuer à faire la somme si on dépasse déjà le nombre
                    break;
                } else if (somme != nombre) {
                    // Si on n'a pas encore atteint le nombre, on continue en ajoutant " + " au résultat
                    suite += " + ";
                } else {
                    // Si somme == nombre, on arrête de faire la somme et on imprime le résultat
                    System.out.println(suite);
                    break;
                }
            }
        }
        scanner.close();
    }
}
