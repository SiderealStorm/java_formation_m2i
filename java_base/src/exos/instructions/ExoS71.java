package exos.instructions;

import java.util.Scanner;

/*
Exercice S71 : Voyelle ou consonne
1. Créer une variable caractere
2. Affecter une valeur à la variable caractere
3. A l'aide des structures conditionnelles, déterminer si le caractère est une consonne ou une voyelle
 */
public class ExoS71 {
    public static void main(String[] args) {
        char caractere;
        String voyelles = "aeiouyAEIOUY";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir une lettre");
        caractere = scanner.next().charAt(0);

        if (voyelles.contains(Character.toString(caractere))) {
            System.out.println("Le caractère est une voyelle");
        } else {
            System.out.println("Le caractère est une consonne");
        }
        scanner.close();
    }
}
