package org.example.demo;

import org.example.Calculatrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Le nom d'une classe de test commence par le nom que la classe qu'elle teste
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
