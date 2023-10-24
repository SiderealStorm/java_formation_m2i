package exos.instructions;

import java.util.Scanner;

/**
Exercice S71 : Voyelle ou consonne
1. Créer une variable caractere
2. Affecter une valeur à la variable caractere
3. A l'aide des structures conditionnelles, déterminer si le caractère est une consonne ou une voyelle
 */
public class ExoS71 {
    public static void main(String[] args) {
        char caractere;
        String voyelles = "aeiouyéèàùâêîôûäëïöü";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir une lettre");
        caractere = scanner.next().toLowerCase().charAt(0);

        if (Character.isAlphabetic(caractere)) {
            if (voyelles.contains(Character.toString(caractere))) {
                System.out.println("Le caractère " + caractere + " est une voyelle");
            } else {
                System.out.println("Le caractère " + caractere + " est une consonne");
            }
        } else {
            System.out.println("Le caractère " + caractere + " n'est pas une lettre de l'alphabet");
        }
        scanner.close();
    }
}
