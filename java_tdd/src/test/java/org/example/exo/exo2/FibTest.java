package org.example.exo.exo2;

import org.example.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FibTest {

    private Fib fib;

    private void initFib(int range) {
        fib = new Fib(range);
    }

    /*
    Correction :
    Un test ne doit pas contenir de logique !
    Uniquement des vérifications (= asserts)
     */

    @Test
    public void testGetFibSeriesShouldBeNotEmptyWhenRangeIs1() {
        // Arrange
        initFib(1);

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    public void testGetFibSeriesShouldContainOnly0WhenRangeIs1() {
        initFib(1);

        List<Integer> result = fib.getFibSeries();

        Assertions.assertEquals(List.of(0), result);
    }

    @Test
    public void testGetFibSeriesShouldContain3WhenRangeIs6() {
        initFib(6);

        List<Integer> result = fib.getFibSeries();

        Assertions.assertTrue(result.contains(3));
    }

    @Test
    public void testGetFibSeriesSizeShouldHave6ElementWhenRangeIs6() {
        initFib(6);

        List<Integer> result = fib.getFibSeries();

        Assertions.assertEquals(6, result.size());
    }

    @Test
    public void testGetFibSeriesShouldNotContain4WhenRangeIs6() {
        initFib(6);

        List<Integer> result = fib.getFibSeries();

        Assertions.assertFalse(result.contains(4));
    }

    @Test
    public void testGetFibSeriesShouldContainAllValuesSortedWhenRangeIs6() {
        initFib(6);

        List<Integer> result = fib.getFibSeries();

        // La consigne n'est pas claire : on ne sait pas si la liste doit contenir uniquement ces valeurs
        // On part du principe qu'on veut une égalité, comme dans le 2e test
        Assertions.assertIterableEquals(List.of(0, 1, 1, 2, 3, 5), result);
    }

    // Méthode inutile car cette condition est vérifiée dans le test précédent
//    @Test
//    public void testGetFibSeriesRange6ShouldBeSorted() {
//        initFib(6);
//
//        List<Integer> result = fib.getFibSeries();
//
//        List<Integer> sorted = result.stream().sorted().toList();
//
//        Assertions.assertIterableEquals(sorted, result);
//
//    }
}
