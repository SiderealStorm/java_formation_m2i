package org.example.exo.exo6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LePenduTest {

    private LePendu pendu;

    @Test
    public void testGenererMasqueShouldBe6StarsWhenMotIsTester() {
        pendu = new LePendu(new FakeMotAleatTesterImpl());
        pendu.genererMasque();

        String result = pendu.getMasque();

        Assertions.assertEquals("******", result);
    }

    @Test
    public void testTestCharShouldBeTrueWhenCharIsE() {
        pendu = new LePendu(new FakeMotAleatTesterImpl());

        boolean result = pendu.testChar('E');

        Assertions.assertTrue(result);
    }

    @Test
    public void testTestCharShouldBeFalseWhenCharIsA() {
        pendu = new LePendu(new FakeMotAleatTesterImpl());

        boolean result = pendu.testChar('A');

        Assertions.assertFalse(result);
    }

    @Test
    public void testTestVictoireShoulbBeTrueWhenMasqueIsMot() {
        pendu = new LePendu(new FakeMotAleatTesterImpl());
        pendu.setMasque("TESTER");

        boolean result = pendu.testVictoire();

        Assertions.assertTrue(result);
    }

    @Test
    public void testTestVictoireShoulbBeFalseWhenMasqueHasStars() {
        pendu = new LePendu(new FakeMotAleatTesterImpl());
        pendu.setMasque("TESTE*");

        boolean result = pendu.testVictoire();

        Assertions.assertFalse(result);
    }
}
