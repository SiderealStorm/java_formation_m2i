package org.example.exo.exo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    @Test
    public void testGetGradeScore95Attend90() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('A', result);
    }

    @Test
    public void testGetGradeScore85Attend90() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(85);
        gradingCalculator.setAttendancePercentage(90);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('B', result);
    }

    @Test
    public void testGetGradeScore65Attend90() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(90);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('C', result);
    }

    @Test
    public void testGetGradeScore95Attend65() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(65);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('B', result);
    }

    @Test
    public void testGetGradeScore95Attend55() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(55);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('F', result);
    }

    @Test
    public void testGetGradeScore65Attend55() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(55);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('F', result);
    }

    @Test
    public void testGetGradeScore50Attend90() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('F', result);
    }

}
