package exos.variables;

import java.util.Scanner;

/**
 * Exercice S54 : majeur ou mineur
 * 1. Créer une variable age et lui affecter une valeur
 * 2. Vérifier si la personne est mineure ou majeure à l'aide des opérateurs logiques
 * 3. Afficher le résultat
 * /!\ Ne pas utiliser de structure conditionnelle
 */
public class ExoS54 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel est votre âge ?");
        int age = scanner.nextInt();

        System.out.println("Vous êtes majeur : " + (age >= 18));

        scanner.close();
    }
}
