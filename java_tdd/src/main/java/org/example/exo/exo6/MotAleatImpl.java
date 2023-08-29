package org.example.exo.exo6;

import java.util.Random;

public class MotAleatImpl implements MotAleat {

    private final String[] mots = {
            "TEST",
            "JAVA",
            "PROGRAMMATION",
            "JAVASCRIPT"
    };


    public String genererMot() {
        return mots[new Random().nextInt(0, mots.length)];
    }
}
