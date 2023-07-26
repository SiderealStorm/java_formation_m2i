package org.example.exos.bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pendu {

    // Le mot et le masque sont deux tableaux de char, pour qu'on puisse les comparer lors du déroulement du jeu
    private char[] word;
    private char[] mask;
    private char letter;
    private ArrayList<Character> testedLetters;
    private int tries;

    private final Scanner scanner = new Scanner(System.in);

    // Constructeurs
    public Pendu() {}

    public Pendu(String word, int tries) {
        this.word = word.toCharArray();
        this.mask = new char[word.length()];
        this.tries = tries;
        this.testedLetters = new ArrayList<>();
        // A l'initialisation, on remplit le masque avec des étoiles
        Arrays.fill(this.mask, '*');
    }

    // Getters et setters
    public char[] getWord() {
        return this.word;
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

    public void setLetter(char letter) {
        this.letter = letter;
    }

    // Méthodes

    public void play() {
        System.out.println("Bienvenue au jeu du Pendu !");
        System.out.println("Devinez le mot caché :");
        do {
            displayMask();
            inputLetter();
            testLetter();
            // TODO
        } while (tries > 0 && mask != word);

    }

    public void inputLetter() {
        System.out.println("Lettre à tester :");
        letter = scanner.next().charAt(0);
    }

    public void testLetter() {
        if (!testedLetters.contains(letter)) {
            for (char element : word) {
                if (element == letter) {
                    changeMask();
                    break;
                } else {
                    tries--;
                    testedLetters.add(letter);
                }
            }
        } else {
            System.out.println("Cette lettre a déjà été testée");
        }
    }


    public boolean testWin() {
        // TODO
        return false;
    }

    public void changeMask() {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter) {
                mask[i] = letter;
            }
        }
    }

    // TODO voir si utile ou non...
    public String displayMask() {
        String chain = "";
        for (char letter : mask ) {
            chain += letter + " ";
        }
        return chain;
    }


}
