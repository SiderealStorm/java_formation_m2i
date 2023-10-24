package exos.instructions;

import java.util.Scanner;

/**
 * Exercice S79 : Chapitres
 * Créer un programme qui permet d'afficher un nombre de chapitres et de sous-parties
 * Le programme demandera le nombre de chapitres ainsi que le nombre de sous-parties à afficher
 */
public class ExoS79 {
    public static void main(String[] args) {

        int nbChap, nbSousPart;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nombre de chapitres :");
        nbChap = scanner.nextInt();

        System.out.println("Entrez le nombre de sous-chapitres :");
        nbSousPart = scanner.nextInt();

        for (int numChap = 1 ; numChap <= nbChap ; numChap++) {
            System.out.println("Chapitre " + numChap);
            for (int numSousPart = 1 ; numSousPart <= nbSousPart ; numSousPart++) {
                System.out.println("\tSous-partie " + numChap + "." + numSousPart);
            }
        }
        scanner.close();
    }
}
