package exos.instructions;

import java.util.Scanner;

/**
Exercice S72 : Jour de la semaine
1. Créer une variable jour de type entier
2. Affecter une valeur à la variable jour
3. Afficher le jour de la semaine en lettre en fonction du nombre passé
4. Si le nombre est inférieur à 1 et supérieur à 7, afficher un message d'erreur
 */
public class ExoS72 {
    public static void main(String[] args) {
        int jour;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un jour de la semaine (en nombre) :");
        jour = scanner.nextInt();

        switch (jour) {
            case 1 -> System.out.println("Lundi");
            case 2 -> System.out.println("Mardi");
            case 3 -> System.out.println("Mercredi");
            case 4 -> System.out.println("Jeudi");
            case 5 -> System.out.println("Vendredi");
            case 6 -> System.out.println("Samedi");
            case 7 -> System.out.println("Dimanche");
            default -> System.out.println("ERREUR : le nombre doit être entre 1 et 7");
        }
        scanner.close();
    }
}
