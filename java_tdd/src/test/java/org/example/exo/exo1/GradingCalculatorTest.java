package org.example.exo.exo1;

import org.example.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {
    /*
     Améliorations suite à la correction :
     On déclare un attribut GradingCalculator
     et une méthode pour lui donner les valeurs voulues
    */
    private GradingCalculator gradingCalculator;

    private void initGradingCalculator(int score, int attendance) {
        gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(score);
        gradingCalculator.setAttendancePercentage(attendance);
    }

    // Modification suite à l'amélioration :
    @Test
    public void testGetGradeScore95Attend90ShouldBeA() {
        // Arrange
        initGradingCalculator(95, 90);

        // Act
        char result = gradingCalculator.getGrade();

        // Assert
        Assertions.assertEquals('A', result);
    }

    @Test
    public void testGetGradeScore85Attend90ShouldBeB() {
        initGradingCalculator(85, 90);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('B', result);
    }

    @Test
    public void testGetGradeScore65Attend90ShouldBeC() {
        initGradingCalculator(65,90);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('C', result);
    }

    @Test
    public void testGetGradeScore95Attend65ShouldBeB() {
        initGradingCalculator(95,65);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('B', result);
    }

    // Méthodes avant amélioration :
    @Test
    public void testGetGradeScore95Attend55ShouldBeF() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(55);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('F', result);
    }

    @Test
    public void testGetGradeScore65Attend55ShouldBeF() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(55);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('F', result);
    }

    @Test
    public void testGetGradeScore50Attend90ShouldBeF() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);

        char result = gradingCalculator.getGrade();

        Assertions.assertEquals('F', result);
    }

}
