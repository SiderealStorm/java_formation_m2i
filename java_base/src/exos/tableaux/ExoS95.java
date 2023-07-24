package exos.tableaux;

import java.util.Arrays;
import java.util.Scanner;

/*
Exercice S95 : Tableau positif
1. Déclarer deux tableaux de 10 éléments
2. Le premier tableau contiendra des nombres négatifs et positifs
3. Ajouter tous les éléments positifs du premier tableau dans le second tableau
BONUS : saisie utilisateur
 */
public class ExoS95 {
    public static void main(String[] args) {
        int[] valSource, valAbsolue;
        int nbValeurs;
        Scanner scanner = new Scanner(System.in);

        // Saisie du premier tableau :

        System.out.println("Combien voulez-vous saisir de valeurs ?");
        nbValeurs = scanner.nextInt();
        valSource = new int[nbValeurs];
        valAbsolue = new int[nbValeurs];

        for (int i = 0 ; i < valSource.length ; i++) {
            System.out.println("Saisir la valeur n°" + (i + 1));
            valSource[i] = scanner.nextInt();
        }

        // Remplissage du deuxième tableau :

        for (int i = 0 ; i < valSource.length ; i++) {
            if (valSource[i] < 0) {
                valAbsolue[i] = - valSource[i];
            } else {
                valAbsolue[i] = valSource[i];
            }
        }

        System.out.println("Valeurs source : " + Arrays.toString(valSource));
        System.out.println("Valeurs absolues : " + Arrays.toString(valAbsolue));
    }
}
