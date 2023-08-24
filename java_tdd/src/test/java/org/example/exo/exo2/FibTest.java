package org.example.exo.exo2;

import org.example.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibTest {

    private Fib fib;

    private void initFib(int range) {
        fib = new Fib(range);
    }

    @Test
    public void testGetFibSeriesRange1ShouldBeNotNull() {
        // Arrange
        initFib(1);

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetFibSeriesRange1ShouldContain0() {
        initFib(1);

        List<Integer> result = fib.getFibSeries();

        List<Integer> expected = List.of(0);

        Assertions.assertIterableEquals(expected, result);
    }

    @Test
    public void testGetFibSeriesRange6ShouldContain3() {
        initFib(6);

        List<Integer> result = fib.getFibSeries();

        Assertions.assertTrue(result.contains(3));
    }

    @Test
    public void testGetFibSeriesRange6SizeShouldBe6() {
        initFib(6);

        List<Integer> result = fib.getFibSeries();

        Assertions.assertEquals(6, result.size());
    }

    @Test
    public void testGetFibSeriesRange6ShouldNotContain4() {
        initFib(6);

        List<Integer> result = fib.getFibSeries();

        Assertions.assertFalse(result.contains(4));
    }

    @Test
    public void testGetFibSeriesRange6ShouldContain011235() {
        initFib(6);

        List<Integer> result = fib.getFibSeries();

        List<Integer> expected = List.of(0, 1, 1, 2, 3, 5);

        Assertions.assertIterableEquals(expected, result);

    }


    @Test
    public void testGetFibSeriesRange6ShouldBeSorted() {
        initFib(6);

        List<Integer> result = fib.getFibSeries();

        // TODO

    }
}
