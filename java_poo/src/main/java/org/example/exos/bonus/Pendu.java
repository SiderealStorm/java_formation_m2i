package org.example.exos.bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pendu {

    // Le mot et le masque sont deux tableaux de char, pour qu'on puisse les comparer lors du déroulement du jeu
    private String word;
    private char[] wordArray;
    private char[] mask;
    private char letter;
    private ArrayList<Character> testedLetters;
    private int tries;

    private final Scanner scanner = new Scanner(System.in);

    // Constructeurs
    public Pendu() {}

    public Pendu(String word, int tries) {
        this.word = word;
        this.wordArray = word.toCharArray();
        this.mask = new char[word.length()];
        this.tries = tries;
        this.testedLetters = new ArrayList<>();
        // A l'initialisation, on remplit le masque avec des étoiles
        Arrays.fill(this.mask, '*');
    }

    // Getters et setters
    public char[] getWordArray() {
        return this.wordArray;
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

    public ArrayList<Character> getTestedLetters() {
        return testedLetters;
    }

    // Méthodes

    public void play() {
        System.out.println("Devinez le mot caché :");
        do {
            System.out.println(mask);
            inputLetter();
            testLetter();
        } while (tries > 0 && !Arrays.equals(mask, wordArray));
        testWin();
        System.out.println("Le mot à trouver était : " + word);
    }

    public void inputLetter() {
        System.out.println("Lettre à tester (sans accent) :");
        letter = scanner.next().toUpperCase().charAt(0);
    }

    public void testLetter() {
        boolean isFound = false;
        if (!testedLetters.contains(letter)) {
            testedLetters.add(letter);
            for (char element : wordArray) {
                if (element == letter) {
                    System.out.println("Bien joué !");
                    isFound = true;
                    changeMask();
                    break;
                }
            }
        } else {
            System.out.println("Cette lettre a déjà été testée");
            isFound = true;
        }

        if (!isFound) {
            tries--;
            System.out.println("Pas de chance... Il vous reste " + tries + " essais");
        }
    }

    public void testWin() {
        if (Arrays.equals(mask, wordArray)) {
            System.out.println("Félicitations, vous avez gagné !");
        } else {
            System.out.println("Vous n'avez plus de vies... game over !");
        }
    }

    public void changeMask() {
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] == letter) {
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
