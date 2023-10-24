package exos.tableaux;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Exercice S95 : Tableau positif
 * Déclarer deux tableaux de 10 éléments
 * Le premier tableau contiendra des nombres négatifs et positifs
 * Ajouter tous les éléments positifs du premier tableau dans le second tableau
 * BONUS : saisie utilisateur
 */
public class ExoS95 {
    public static void main(String[] args) {
        int[] valSource, valPositives;
        int nbValeurs;
        int indice = 0;
        Scanner scanner = new Scanner(System.in);

        // Saisie du premier tableau :

        System.out.println("Combien voulez-vous saisir de valeurs ?");
        nbValeurs = scanner.nextInt();
        valSource = new int[nbValeurs];
        valPositives = new int[nbValeurs];

        for (int i = 0; i < valSource.length; i++) {
            System.out.println("Saisir la valeur n°" + (i + 1));
            valSource[i] = scanner.nextInt();
        }

        // Remplissage du deuxième tableau :

        for (int valeur : valSource) {
            if (valeur > 0) {
                valPositives[indice] = valeur;
                indice++;
            }

        }
        System.out.println("Valeurs source : " + Arrays.toString(valSource));
        System.out.println("Valeurs positives : " + Arrays.toString(valPositives));
    }
}
