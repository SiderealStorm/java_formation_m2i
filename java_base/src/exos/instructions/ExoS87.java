package exos.instructions;

import java.util.Scanner;

/**
 * Exercice S87 : Nombre fort
 * Un nombre fort est un nombre dont la somme de la factorielle des chiffres qui le constitue est égale à ce nombre
 * Par exemple : 145 = 1! + 4! + 5! soit 145 = 1 + 24 + 120
 * Écrire un programme qui permet de savoir si un nombre est fort
 */
public class ExoS87 {
    public static void main(String[] args) {
        String[] chiffres;
        int nombre;
        int somme = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre entier :");
        nombre = scanner.nextInt();
        // La saisie est transformée en tableau de chiffres
        chiffres = String.valueOf(nombre).split("");

        for (String caractere : chiffres) {
            int chiffre = Integer.parseInt(caractere);
            int factorielle = 1;

            for (int j = 1; j <= chiffre; j++) {
                factorielle *= j;
            }

            somme += factorielle;
        }

        if (somme == nombre) {
            System.out.println(nombre + " est un nombre fort");
        } else {
            System.out.println(nombre + " n'est pas un nombre fort");
        }
        scanner.close();
    }
}
