package org.example.exos.bonus;

import java.util.ArrayList;
import java.util.Random;

public class RandomWord {

    private static final ArrayList<String> wordsList = new ArrayList<>() {
        {
            add("AGENCE");
            add("AGITER");
            add("ANANAS");
            add("ARMURE");
            add("BANANE");
            add("BATEAU");
            add("BRANCHE");
            add("CACTUS");
            add("CAFARD");
            add("CAISSE");
            add("CANARD");
            add("CHARGE");
            add("CHIFFRE");
            add("CLOUER");
            add("COFFRE");
            add("COURIR");
            add("CUISINER");
            add("DANGER");
            add("DENTELLE");
            add("ECURIE");
            add("EMOTIF");
            add("EMPIRE");
            add("ENIGME");
            add("FUMOIR");
            add("GARAGE");
            add("GATEAU");
            add("GLACER");
            add("GORILLE");
            add("GRAND");
            add("HURLER");
            add("IGNARE");
            add("IMMENSE");
            add("JARDIN");
            add("JOYEUX");
            add("JUNGLE");
            add("LIVRER");
            add("LOVER");
            add("MEUBLE");
            add("MONTER");
            add("MUSIQUE");
            add("NAUFRAGE");
            add("OCCUPE");
            add("OMBRES");
            add("OUBLIER");
            add("PASSEUR");
            add("PILOTE");
            add("PIRANHA");
            add("POLICE");
            add("QUETE");
            add("RAMPER");
        }
    };
    // Pour ne pas sélectionner deux fois le même mot, on les stocke dans une liste
//    private static final ArrayList<String> usedWords = new ArrayList<>();

//    public static boolean testUsedWords() {
//        return (usedWords.size() < words.length);
//    }

    public static String chooseWord() {
        int index;
        String word;

//        do {
            index = (new Random()).nextInt(0, wordsList.size());
            word = wordsList.get(index);
//        } while (usedWords.contains(word)); // = tant que le mot choisi est dans la liste des mots déjà utilisés

//        usedWords.add(word);
        wordsList.remove(index);
        return word;
    }

    public static boolean testList() {
        return wordsList.size() != 0;
    }
}
