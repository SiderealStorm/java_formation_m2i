package org.example.exos.bonus;

/*
Exercice bonus : jeu du Pendu
1. Réaliser un jeu du pendu en créant une classe Pendu qui possédera au minimum comme attributs : le masque, le nombre d’essais ainsi que le mot à trouver.
Cette classe aura comme méthodes : TestChar(), TestWin() et GenerateMask().
2. Le joueur aura par défaut 10 chances pour gagner.
3. Utiliser une autre classe servant à générer les mots pour le jeu, à partir d’un tableau d’entrées potentielles
4. Optionnellement, le joueur pourra choisir un nombre de coups pour sa partie
5. Créer une IHM pour tester l'application
 */
public class MainPendu {
    public static void main(String[] args) {
        // Test de la liste de mots
        int compeur = 1;
        while (RandomWord.testList()) {
            System.out.println(compeur + ". " + RandomWord.chooseWord());
            compeur++;
        }
    }
}
