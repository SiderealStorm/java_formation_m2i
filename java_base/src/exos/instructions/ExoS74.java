package exos.instructions;

import java.util.Scanner;

/**
Exercice S74 : Année bissextile
1. Créer une variable annee de type entier
2. Affecter une valeur à la variable annee
3. Une année est bissextile si elle est divisible par 4 mais non divisible par 100.
4. L'année est également bissextile si elle est divisible par 400
 */
public class ExoS74 {
    public static void main(String[] args) {
        int annee;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir une année :");
        annee = scanner.nextInt();

        if ((annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0) {
            System.out.println("L'année " + annee + " est bissextile");
        } else {
            System.out.println("L'année " + annee + " n'est pas bissextile");
        }
        scanner.close();
    }
}
