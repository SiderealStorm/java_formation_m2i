package org.example.demo.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Le nom d'une classe de test commence par le nom que la classe qu'elle teste
public class CalculatriceTest {

    /*
    Conventions d'écriture d'une méthode test :
        - toujours public void
        - nom de la méthode : test + nom de la méthode à tester + résultat
        Exemple :
            * test ... Given ... When ...
            * ShouldBe ... When ...
     */

    // Test de la méthode addition :

    // Il faut ajouter l'annotation pour déclarer la méthode en tant que méthode de test
    @Test
    public void testAddition() {
        // Arrange
        Calculatrice calculatrice = new Calculatrice();

        // Act
        double result = calculatrice.addition(10, 20);

        // Assert
        // En clean code, on ne fait qu'un assert par méthode de test
        Assertions.assertEquals(30, result);
    }

    // Test de la méthode division

    // On peut tester l'intégralité d'une méthode dans un seul test,
    // ou tester ses "branches" une à une dans des méthodes séparées (plus propre)
    @Test
    public void testDivisionAvecBDiff0() {
        Calculatrice calculatrice = new Calculatrice();

        double result = calculatrice.division(10, 2);

        Assertions.assertEquals(5, result);
    }

    @Test
    public void testDivisionAvecBEgal0() {
        Calculatrice calculatrice = new Calculatrice();

        // Quand on teste une exception, l'Act et l'Assert se font en même temps
        // Assert
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            // Act
            calculatrice.division(10, 0);
        });
    }
}
