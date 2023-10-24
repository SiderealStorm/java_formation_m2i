package exos.instructions;

import java.util.Scanner;

/**
Exercice S73 : Jours dans le mois
1. Créer une variable mois de type entier
2. Affecter une valeur à la variable mois
3. Afficher le nombre de jours du mois
4. Si le nombre est inférieur à 1 et supérieur à 12, afficher un message d'erreur
 */
public class ExoS73 {
    public static void main(String[] args) {
        int mois;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un mois (en nombre) :");
        mois = scanner.nextInt();

        switch (mois) {
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("Ce mois comporte 31 jours");
            case 4, 6, 9, 11 -> System.out.println("Ce mois comporte 30 jours");
            case 2 -> System.out.println("Ce mois comporte 28 jours (ou 29 des fois)");
            default -> System.out.println("ERREUR : le nombre doit être entre 1 et 12");
        }
        scanner.close();
    }
}
