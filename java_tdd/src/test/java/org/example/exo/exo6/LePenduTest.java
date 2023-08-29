package org.example.exo.exo6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LePenduTest {

    private LePendu pendu;

    @BeforeEach
    void setup() {
        pendu = new LePendu(new FakeMotAleatTesterImpl());
        pendu.genererMasque();
    }

    @Test
    public void testGenererMasqueShouldBe6StarsWhenMotIsTester() {
        String result = pendu.getMasque();

        Assertions.assertEquals("******", result);
    }

    @Test
    public void testTestCharShouldBeTrueWhenCharIsE() {
        boolean result = pendu.testChar('E');

        Assertions.assertTrue(result);
    }

    @Test
    public void testTestCharShouldBeFalseWhenCharIsA() {
        boolean result = pendu.testChar('A');

        Assertions.assertFalse(result);
    }

    @Test
    public void testTestCharShouldChangeMasqueWhenCharIsR() {
        pendu.testChar('R');

        Assertions.assertEquals("*****R", pendu.getMasque());
    }

    @Test
    public void testTestCharShouldChangeMasqueTwiceWhenCharIsE() {
        pendu.testChar('E');

        Assertions.assertEquals("*E**E*", pendu.getMasque());
    }

    @Test
    public void testTestCharShouldNotChangeMasqueWhenCharIsA() {
        boolean result = pendu.testChar('A');

        Assertions.assertFalse(result);
    }

    @Test
    public void testTestCharShouldDecreaseViesWhenCharIsA() {
        pendu.setVies(5);
        pendu.testChar('A');

        Assertions.assertEquals(4, pendu.getVies());
    }

    @Test
    public void testTestVictoireShoulbBeTrueWhenMasqueIsMot() {
        // On peut tester en settant le masque...
//        pendu.setMasque("TESTER");
        // ... ou en lançant la méthode qui modifie le masque
        pendu.testChar('T');
        pendu.testChar('E');
        pendu.testChar('S');
        pendu.testChar('R');

        boolean result = pendu.testVictoire();

        Assertions.assertTrue(result);
    }

    @Test
    public void testTestVictoireShoulbBeFalseWhenMasqueHasStars() {
//        pendu.setMasque("TESTE*");
        pendu.testChar('T');
        pendu.testChar('E');
        pendu.testChar('S');

        boolean result = pendu.testVictoire();

        Assertions.assertFalse(result);
    }
}
