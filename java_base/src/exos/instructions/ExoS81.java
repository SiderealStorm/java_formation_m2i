package exos.instructions;

import java.util.Scanner;

/**
 * Exercice S81 : Population
 * L'accroissement de la population de Tourcoing est de 0.89%
 * En 2015 la ville comptait 96809 habitants
 * 1. Combien d'années faut-il pour atteindre 120 000 habitants ?
 * 2. Combien d'habitants y aura-t-il cette année-là ?
 * Écrire un programme permettant de résoudre ce problème
 */
public class ExoS81 {
    public static void main(String[] args) {
        double txAccroissement = 0.89;
        double popActuelle = 96_809;
        int popFinale = 120_000;
        int annee = 2015;

        while (popActuelle < popFinale) {
            popActuelle = popActuelle * (1 + txAccroissement/100);
            annee++;
        }

        // Séparateur de milliers : ajouter une virgule après le % ; fonctionne avec les entiers et les décimaux
        System.out.printf("La population de Tourcoing dépassera les %,d habitants en %d avec environ %,.0f habitants", popFinale, annee, popActuelle);
        System.out.println();


        // BONUS : avec saisies utilisateur

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quelle est la population actuelle ?");
        popActuelle = scanner.nextDouble();
        System.out.println("Quelle population faut-il atteindre ?");
        popFinale = scanner.nextInt();
        System.out.println("Quel est le taux d'acroissement de la ville ? (en %)");
        txAccroissement = scanner.nextDouble();

        int nbAnnees = 0;

        while (popActuelle < popFinale) {
            popActuelle = popActuelle * (1 + txAccroissement/100);
            nbAnnees++;
        }

        // Séparateur de milliers : ajouter une virgule après le % ; fonctionne avec les entiers et les décimaux
        System.out.printf("La population dépassera les %,d habitants en %d ans avec environ %,.0f habitants", popFinale, nbAnnees, popActuelle);

    }
}
