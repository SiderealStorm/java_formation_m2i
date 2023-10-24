package exos.instructions;

import java.util.Scanner;

/**
 * Exercice S83 : Notes
 * 1. Créer une variable stockant le nombre de notes à saisir
 * 2. Afficher la note la plus haute
 * 3. Afficher la note la plus basse
 * 4. Afficher la moyenne des notes
 * /!\ la note doit être comprise entre 0 et 20
 */
public class ExoS83 {
    public static void main(String[] args) {
        int nbNotes;
        double noteMin = 20;
        double noteMax = 0;
        double somme = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combien de notes voulez-vous saisir ?");
        nbNotes = scanner.nextInt();

        for (int i = 1 ; i <= nbNotes ; i++) {
            System.out.println("Note n°" + i);
            double note = scanner.nextDouble();

            if (note >= 0 && note <= 20) {
                somme += note;

                if (note < noteMin) {
                    noteMin = note;
                }
                if (note > noteMax) {
                    noteMax = note;
                }
            } else {
                System.out.println("Note invalide !");
                // On décrémente i pour que l'utilisateur puisse retaper la note
                i--;
            }

        }
        System.out.println("La note la plus haute est : " + noteMax);
        System.out.println("La note la plus basse est : " + noteMin);
        System.out.println("La moyenne des notes est : " + somme / nbNotes);
        scanner.close();
    }
}
