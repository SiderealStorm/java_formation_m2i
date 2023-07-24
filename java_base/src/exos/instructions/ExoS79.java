package exos.instructions;

import java.util.Scanner;

/*
Exercice S79 : Chapitres
1. Créer un programme qui permet d'afficher un nombre de chapitres et de sous-parties
2. Le programme demandera le nombre de chapitres ainsi que le nombre de sous-parties à afficher
 */
public class ExoS79 {
    public static void main(String[] args) {

        int nbChap, nbSousPart;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le nombre de chapitres :");
        nbChap = scanner.nextInt();

        System.out.println("Entrez le nombre de sous-chapitres :");
        nbSousPart = scanner.nextInt();

        for (int i = 1 ; i <= nbChap ; i++) {
            System.out.println("Chapitre " + i);
            for (int j = 1 ; j <= nbSousPart ; j++) {
                System.out.println("\tSous-partie " + i + "." + j);
            }
        }
        scanner.close();
    }
}
