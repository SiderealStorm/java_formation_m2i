package exos.instructions;

import java.util.Scanner;

/**
Exercice S70 : Maximum de 3 nombres
1. Créer 3 variables : nombre1, nombre2, nombre3
2. Affecter des valeurs aux variables
3. Créer des structures conditionnelles permettant d'afficher le maximum parmis les 3 nombres créés précédemment
 */
public class ExoS70 {
    public static void main(String[] args) {
        int nb1, nb2, nb3, max;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un nombre entier :");
        nb1 = scanner.nextInt();
        System.out.println("Saisir un deuxième nombre entier :");
        nb2 = scanner.nextInt();
        System.out.println("Saisir un troisième nombre entier :");
        nb3 = scanner.nextInt();

        max = nb1;

        if (nb2 > max) {
            max = nb2;
        }

        if (nb3 > max) {
            max = nb3;
        }
        System.out.println("La valeur maximale est " + max);
        scanner.close();
    }
}
