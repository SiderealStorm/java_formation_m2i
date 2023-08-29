package org.example.exo.exo7;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private final PinNumberGenerator generator;
    private List<Integer> rolls;
    private boolean lastRoll;

    public Frame(PinNumberGenerator generator, boolean lastRoll) {
        this.generator = generator;
        this.rolls = new ArrayList<>();
        this.lastRoll = lastRoll;
    }

    public List<Integer> getRolls() {
        return rolls;
    }

    public void setRolls(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public boolean isLastRoll() {
        return lastRoll;
    }

    public void setLastRoll(boolean lastRoll) {
        this.lastRoll = lastRoll;
    }

    // Les méthodes qui ne contiennent pas de logique n'ont pas à être testées
    public int getScore() {
        int score = 0;
        for (Integer roll : rolls) {
            score += roll;
        }
        return score;
    }

    public void makeRoll() {
        throw new RuntimeException();
    }
}
