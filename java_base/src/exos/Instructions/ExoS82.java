package exos.Instructions;

import java.util.Scanner;

/*
Exercice S82 : Sommes consécutives
1. Déclarer une variable nombre
2. À l'aide de boucles, afficher les suites de nombres qui permettent d'arriver au nombre inscrit précédemment
 */
public class ExoS82 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez un nombre entier :");
        int nombre = scanner.nextInt();

        for (int i = 1 ; i <= nombre ; i++) {
            int somme = 0;
            String suite = nombre + " = ";
            for (int j = i ; j < nombre ; j++) {
                suite += j;
                somme += j;
                if (somme != nombre) {
                    suite += " + ";
                } else {
                    System.out.println(suite);
                    break;
                }
            }
        }
    }
}
