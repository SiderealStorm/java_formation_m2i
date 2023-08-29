package org.example.demo.mock;

public class FakeDeWinImpl implements De {

    // Dans la méthode, on renvoie la valeur attendue pour gagner
    @Override
    public int getValue() {
        return 6;
    }
}
