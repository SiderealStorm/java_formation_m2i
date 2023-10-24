package exos.tableaux;

/**
Exercice S94 : 100 éléments
1. Déclarer un tableau de 100 éléments et l'initialiser
2. Afficher les éléments par dizaine séparés d'une virgule
 */
public class ExoS94 {
    public static void main(String[] args) {

        int[] tableau = new int[100];
        for (int i = 0 ; i < tableau.length ; i++) tableau[i] = i;

        for (int i = 0 ; i < tableau.length ; i++) {
            System.out.print(tableau[i]);
            if (i % 10 == 9) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
    }
}
