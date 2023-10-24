package exos.variables;

import java.util.Scanner;

/**
 * Exercice S51 : Prénom NOM
 * 1. Créer une variable nom et une variable prenom
 * 2. Afficher la phrase suivante "Bonjour {prenom} {NOM}."
 * 3. Remplacer les valeurs entre chevrons par les variables créées précédemment
 */
public class ExoS51 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir votre nom :");
        String nom = scanner.nextLine();
        System.out.println("Saisir votre prénom :");
        String prenom = scanner.nextLine();

        System.out.println("Bonjour " + prenom + " " + nom.toUpperCase() + ".");

        scanner.close();
    }

}
