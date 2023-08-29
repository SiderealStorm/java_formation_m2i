package org.example.demo.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatriceTestBis {

    /*
    Amélioration :
    Comme dans toute classe Java, on peut utiliser des attributs et des méthodes dans les test,
    par exemple :
    - des attributs pour les ... souvent utilisés
    - une méthode d'initialisation, appelée dans les tests, pour créer l'objet avec arguments (cf. exo1)
    - une méthode setUp(), avec l'annotation @BeforeEach, qui se lance avant chaque test (pour créer l'objet "vide" par exemple)
     */

    private Calculatrice calculatrice;

    @BeforeEach
    public void setUp() {
        calculatrice = new Calculatrice();
    }

    @Test
    public void testAddition() {
        double result = calculatrice.addition(10, 20);
        Assertions.assertEquals(30, result);
    }

    @Test
    public void testDivisionAvecBDiff0() {
        double result = calculatrice.division(10, 2);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testDivisionAvecBEgal0() {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            calculatrice.division(10, 0);
        });
    }
}
