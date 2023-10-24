package exos.variables;

import java.util.Scanner;

/**
 * Exercice S56 : Mise en forme de chaînes
 * 1. Saisir une chaine et la stocker dans une variable
 * 2. Effectuer les traitements suivants :
 * - Afficher la chaîne en minuscule
 * - Afficher la chaîne en majuscule
 * > Bonus
 * 1. Convertir la chaîne en tableau puis afficher les caractères séparés d'une virgule
 * 2. Afficher la première lettre de chaque mot en majuscule
 */
public class ExoS56 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir une chaîne de caractères :");
        String chaine = scanner.nextLine();

        System.out.println("En minuscule : " + chaine.toLowerCase());
        System.out.println("En majuscule : " + chaine.toUpperCase());

        String[] tableau = chaine.toLowerCase().split("");
        System.out.print("En tableau : " + tableau[0]);
        for (int i = 1; i < tableau.length; i++) {
            System.out.print(", " + tableau[i]);
        }
        System.out.println();

        // Version plus simple, sans tableau :
        System.out.println("Sans tableau : " + String.join(", ", chaine.toLowerCase().split("")));


        String[] capitale = chaine.split(" ");
        System.out.print("Avec capitales : ");
        for (String mot : capitale) {
            System.out.print(mot.substring(0,1).toUpperCase() + mot.substring(1).toLowerCase() + " ");
        }

        scanner.close();
    }
}
