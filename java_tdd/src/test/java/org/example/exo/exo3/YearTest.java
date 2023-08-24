package org.example.exo.exo3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YearTest {

    private Year year;
    private boolean result;

    // Test pour année divisible par 400 (= true)
    @Test
    public void testIsLeapYearShoudBeTrueWhenYearIs2000() {
        year = new Year(2000);

        result = year.isLeapYear();

        Assertions.assertTrue(result);
    }

    // Test pour année divisible par 4000 (= true)
    @Test
    public void testIsLeapYearShoudBeTrueWhenYearIs4000() {
        year = new Year(4000);

        result = year.isLeapYear();

        Assertions.assertTrue(result);
    }

    // Test pour année divisible par 4 mais pas par 100 (= true)
    @Test
    public void testIsLeapYearShoudBeTrueWhenYearIs2012() {
        year = new Year(2012);

        result = year.isLeapYear();

        Assertions.assertTrue(result);
    }

    // Test pour année divisible par 100 mais PAS par 400 (= false)
    @Test
    public void testIsLeapYearShoudBeFalseWhenYearIs1900() {
        year = new Year(1900);

        result = year.isLeapYear();

        Assertions.assertFalse(result);
    }

    // Test pour année non divisible par 4 (= false)
    @Test
    public void testIsLeapYearShoudBeFalseWhenYearIs2002() {
        year = new Year(1994);

        result = year.isLeapYear();

        Assertions.assertFalse(result);
    }
}
