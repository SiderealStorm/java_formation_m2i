package exos.instructions;

import java.util.Scanner;

/**
Exercice S69 : Pair ou impair
1. Créer une variable nombre de type entier
2. Affecter une valeur à la variable nombre
3. Créer une condition qui permet d'afficher si le nombre est pair ou impair
 */
public class ExoS69 {
    public static void main(String[] args) {
        int nombre;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre entier :");
        nombre = scanner.nextInt();

        if (nombre % 2 == 0) {
            System.out.println("Le nombre est pair");
        } else {
            System.out.println("Le nombre est impair");
        }
        scanner.close();
    }
}
