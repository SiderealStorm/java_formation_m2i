package exos.instructions;

import java.util.Random;
import java.util.Scanner;

/**
 * Exercice S85 : Nombre mystère
 * 1. Générer un nombre aléatoire entre 1 et 100
 * 2. Faire saisir un nombre à l'utilisateur
 * 3. Si le chiffre saisi est plus grand, écrire : Le nombre est plus petit
 * 4. Si le chiffre saisi est plus petit, écrire : Le nombre est plus grand
 * 5. Si le chiffre saisi est égal au chiffre aléatoire, écrire : Vous avez gagné en X tentatives
 */
public class ExoS85 {
    public static void main(String[] args) {
        int saisie = 0;
        int essais = 0;
        int nombre = new Random().nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Jeu du nombre à deviner ===");
        while (saisie != nombre) {
            System.out.println("Saisir un nombre entier :");
            saisie = scanner.nextInt();
            essais++;
            if (saisie < nombre) {
                System.out.println("Le nombre à deviner est plus grand");
            } else if (saisie > nombre) {
                System.out.println("Le nombre à deviner est plus petit");
            }
        }

        System.out.println("Vous avez deviné le nombre en " + essais + " tentatives.");
        scanner.close();
    }
}
