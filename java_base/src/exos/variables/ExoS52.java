package exos.variables;

import java.util.Scanner;


/**
 * Exercice S52 : Permuter deux variables
 * Écrire un programme qui permet de permuter les valeurs entre deux variables
 */
public class ExoS52 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un entier a :");
        int a = scanner.nextInt();

        System.out.println("Saisir un entier b :");
        int b = scanner.nextInt();

        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a + " b = " + b);

        scanner.close();
    }
}
