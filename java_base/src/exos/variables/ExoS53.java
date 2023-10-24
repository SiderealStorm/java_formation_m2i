package exos.variables;

import java.util.Scanner;

/**
 * Exercice S53 : Somme des carrés
 * 1. Écrire un programme avec les variables suivantes : a, b
 * 2. Afficher la somme des carrés de ces deux nombres
 */
public class ExoS53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Déclarer plusieurs variables en une ligne :
        int a, b, sommeCarres;

        System.out.println("Entrez un nombre entier a :");
        a = scanner.nextInt();

        System.out.println("Entrez un nombre entier b :");
        b = scanner.nextInt();

        sommeCarres = a*a + b*b;
        System.out.println("a² + b² = " + sommeCarres);

        scanner.close();
    }
}
