package exos.instructions;

import java.util.Scanner;

/**
Exercice S75 : Lettre, nombre ou caractère spécial
1. Créer une variable caractere
2. Affecter une valeur à la variable caractere
3. Afficher un message en fonction du type du caractère (lettre, nombre, ou caractère spécial)
 */
public class ExoS75 {
    public static void main(String[] args) {

        char caractere;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir un caractère :");
        caractere = scanner.next().charAt(0);

        if (Character.isLetter(caractere)) {
            System.out.println(caractere + " est une lettre de l'alphabet");
        } else if (Character.isDigit(caractere)) {
            System.out.println(caractere + " est un chiffre");
        } else {
            System.out.println(caractere + " est un caractère spécial");
        }
        scanner.close();
    }
}
