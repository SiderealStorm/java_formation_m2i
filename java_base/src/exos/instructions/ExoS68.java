package exos.instructions;

import java.util.Scanner;

/**
Exercice S68 : majeur ou mineur
1. Créer une variable age
2. Affecter une valeur à la variable age
3. Créer une condition qui permet d'afficher si la personne est majeure ou mineure
 */
public class ExoS68 {
    public static void main(String[] args) {

        int age;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir votre âge : ");
        age = scanner.nextInt();

        if (age < 18) {
            System.out.println("Vous êtes mineur");
        } else {
            System.out.println("Vous êtes majeur");
        }

        scanner.close();
    }
}
