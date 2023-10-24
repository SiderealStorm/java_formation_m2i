package org.example.exos.bonus;

import java.util.Scanner;

/**
 * Exercice bonus : jeu du Pendu
 * Réaliser un jeu du pendu en créant une classe Pendu qui possédera au minimum comme attributs : le masque, le nombre d’essais ainsi que le mot à trouver.
 * Cette classe aura comme méthodes : TestChar(), TestWin() et GenerateMask().
 * Le joueur aura par défaut 10 chances pour gagner.
 * Utiliser une autre classe servant à générer les mots pour le jeu, à partir d’un tableau d’entrées potentielles
 * Optionnellement, le joueur pourra choisir un nombre de coups pour sa partie
 * Créer une IHM pour tester l'application
 */
public class MainPendu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Boucle du jeu
        char play;
        do {
            System.out.println("Bienvenue au jeu du Pendu !");
            Pendu pendu = new Pendu(RandomWord.chooseWord(), 10);
            pendu.play();
            System.out.println("Voulez-vous rejouer ? (y)");
            play = scanner.next().toLowerCase().charAt(0);
        } while (RandomWord.testList() && play == 'y');
        System.out.println("Merci d'avoir joué !");

    }
}
