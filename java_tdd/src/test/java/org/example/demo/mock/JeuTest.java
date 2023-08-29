package org.example.demo.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JeuTest {

    private Jeu jeu;

    @Test
    public void testWin() {
        // Pour les tests, on utilise les classes de mock
        jeu = new Jeu(new FakeDeWinImpl());

        boolean result = jeu.jouer();

        Assertions.assertTrue(result);
    }


    @Test
    public void testLose() {
        // Pour les tests, on utilise les classes de mock
        jeu = new Jeu(new FakeDeLoseImpl());

        boolean result = jeu.jouer();

        Assertions.assertFalse(result);
    }
}
