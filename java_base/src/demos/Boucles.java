package demos;

import java.util.Scanner;

public class Boucles {
    public static void main(String[] args) {

        // Pour

        for (int compteur = 1 ; compteur <= 5 ; compteur++) {
            System.out.println("Boucle n°" + compteur);
        }

        System.out.println();

        // Itération sur un tableau

        String[] listePrenoms = {"Storm", "Alex", "Liz", "Zack"};

        for (String prenom : listePrenoms) {
            System.out.println("Bonjour " + prenom + " !");
        }

        System.out.println();


        // Tant que

        int compteur = 0;

        while (compteur < 10) {
            System.out.println("Le compteur vaut " + compteur + ", il est supérieur à 0");
            compteur++;
        }
        System.out.println("Le compteur vaut " + compteur + ", on sort de la boucle");

        System.out.println();


        // Version "inversée" = do while

        do {
            System.out.println("Le compteur vaut " + compteur + ", il est inférieur à 10");
            compteur--;
        } while (compteur > 0);
        System.out.println("Le compteur vaut " + compteur + ", on sort de la boucle");


        // break et continue

        for (int i = 0 ; i < 10 ; i++) {
            if(i == 3) {
                continue;
                // La boucle "for" s'interromp et passe directement à l'itération suivante
            }
            if (i == 8 ) {
                break;
                // La boucle "for" s'arrête définitivement
            }
            System.out.println("i = " + i);
        }


        // Menu en boucle infinie

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Saisir 'y' pour sortir");
            String valeur = scanner.nextLine();

            if (valeur.equals("y")) {
                break;
            }
        }
    }
}
