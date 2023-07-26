package org.example.exos.bonus;

import java.util.Arrays;

public class Pendu {

    // Le mot et le masque sont deux tableaux de char, pour qu'on puisse les comparer lors du déroulement du jeu
    private char[] word;
    private char[] mask;
    private int tries;

    // Constructeurs
    public Pendu() {}

    public Pendu(String word) {
        this.word = word.toCharArray();
        this.mask = new char[word.length()];
        this.tries = 10;
        // A l'initialisation, on remplit le masque avec des étoiles
        Arrays.fill(this.mask, '*');
    }

    // Getters et setters
    public char[] getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word.toCharArray();
    }

    public char[] getMask() {
        return this.mask;
    }

    public int getTries() {
        return this.tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    // Méthodes

    public void testChar(char character) {

    }

    public boolean testWin() {
        return false;
    }



}
