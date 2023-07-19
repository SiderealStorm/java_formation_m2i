package exos.Variables;

import java.util.Scanner;

/*
Exercice S53 : Somme des carrés
1. Écrire un programme avec les variables suivantes : a, b
2. Afficher la somme des carrés de ces deux nombres
 */
public class ExoS53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez un nombre entier a :");
        int a = scanner.nextInt();

        System.out.println("Entrez un nombre entier b :");
        int b = scanner.nextInt();

        int sommeCarres = a*a + b*b;
        System.out.println("a² + b² = " + sommeCarres);

        scanner.close();
    }
}
