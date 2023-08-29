package org.example.demo.mock;

import java.util.Random;

public class DeImpl implements De {

    private final Random random;

    public DeImpl() {
        random = new Random();
    }

    public int getValue() {
        return random.nextInt(1, 7);
    }
}
