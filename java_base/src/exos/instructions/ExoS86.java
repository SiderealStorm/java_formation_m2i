package exos.instructions;

import java.util.Scanner;

/**
 * Exercice S86 : Factorielle
 * La factorielle d'un nombre positif est le quotient cumulatif des nombres allant de 1 à ce nombre
 * Exemple : la factorielle de 3 est 1 x 2 x 3 = 6
 * Réaliser un programme qui affiche la factorielle d'un nombre
 */
public class ExoS86 {
    public static void main(String[] args) {
        int nombre, factorielle;
        String affichage;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre entier :");
        nombre = scanner.nextInt();
        factorielle = 1;
        affichage = nombre + "! = ";

        for (int i = 1 ; i <= nombre ; i++) {
            factorielle *= i;
            affichage += i;
            if (i != nombre) {
                affichage += " x ";
            }
        }
        System.out.println(affichage + " = " + factorielle);
        scanner.close();
    }
}
