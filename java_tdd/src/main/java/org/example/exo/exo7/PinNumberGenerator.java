package org.example.exo.exo7;

import java.util.Random;

public class PinNumberGenerator {

    private final Random random;

    public PinNumberGenerator() {
        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(1, 11);
    }
}
