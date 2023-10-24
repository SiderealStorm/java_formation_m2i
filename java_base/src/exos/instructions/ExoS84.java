package exos.instructions;

import java.util.Scanner;

/**
 * Exercice S84 : Nombres premiers
 * Un nombre premier est un nombre divisible par 1 et par soit-même uniquement
 * 1 n'est pas un nombre premier
 * Écrire un programme qui permet de savoir si un nombre est premier
 */
public class ExoS84 {
    public static void main(String[] args) {
        int nombre;
        boolean divisible = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre entier :");
        nombre = scanner.nextInt();

        for (int i = 2 ; i < nombre ; i++) {
            if (nombre % i == 0) {
                divisible = true;
                // Pas besoin de vérifier si le nombre est divisible pas plusieurs nombres, donc on arrête la boucle
                break;
            }
        }

        if (divisible || nombre == 1) {
            System.out.println(nombre + " n'est pas un nombre premier");
        } else {
            System.out.println(nombre + " est un nombre premier");
        }
        scanner.close();
    }
}
