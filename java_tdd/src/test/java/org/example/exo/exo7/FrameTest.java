package org.example.exo.exo7;

import org.example.exo.exo7.exception.FinishedFrameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FrameTest {

    @Mock
    private PinNumberGenerator generator;
    private Frame frame;

    @BeforeEach
    void setup() {
        // Arrange
        generator = new PinNumberGenerator();
        frame = new Frame(generator, false);
    }

    @Test
    void testMakeRollFirstTryShouldIncreaseScore() {
        Mockito.when(generator.generate()).thenReturn(4);

        // Act
        frame.makeRoll();

        // Assert
        Assertions.assertEquals(6, frame.getScore());
    }

    @Test
    void testMakeRollSecondTryShouldIncreaseScore() {
        Mockito.when(generator.generate()).thenReturn(4);

        // Act
        frame.makeRoll();
        frame.makeRoll();

        // Assert
        Assertions.assertEquals(8, frame.getScore());
    }

    @Test
    void testMakeRollShouldThrowFinishedFrameExceptionAfterFirstTryWhenIsStrike() {
        Mockito.when(generator.generate()).thenReturn(10);

        frame.makeRoll();

        Assertions.assertThrowsExactly(FinishedFrameException.class, () -> frame.makeRoll());
    }

    @Test
    void testMakeRollShouldThrowFinishedFrameExceptionAfterSecondTry() {
        Mockito.when(generator.generate()).thenReturn(4);

        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertThrowsExactly(FinishedFrameException.class, () -> frame.makeRoll());
    }

    @Test
    void testMakeRollShouldNotThrowFinishedFrameExceptionAfterFirstTryWhenIsStrikeAndLastRoll() {
        Mockito.when(generator.generate()).thenReturn(10);

        frame.setLastRoll(true);
        frame.makeRoll();

        Assertions.assertDoesNotThrow(() -> frame.makeRoll());
    }

    @Test
    void testMakeRollSecondTryShouldIncreaseScoreWhenFirstIsStrikeAndLastRoll() {
        frame.setLastRoll(true);

        Mockito.when(generator.generate()).thenReturn(10);
        frame.makeRoll();

        Mockito.when(generator.generate()).thenReturn(4);
        frame.makeRoll();

        Assertions.assertEquals(14, frame.getScore());
    }


    @Test
    void testMakeRollShouldNotThrowFinishedFrameExceptionAfterSecondTryWhenFirstIsStrikeAndLastRoll() {
        frame.setLastRoll(true);

        Mockito.when(generator.generate()).thenReturn(10);
        frame.makeRoll();

        Assertions.assertDoesNotThrow(() -> frame.makeRoll());

    }

    @Test
    void testMakeRollThirdTryShouldIncreaseScoreWhenFirstIsStrikeAndLastRoll() {
        frame.setLastRoll(true);

        Mockito.when(generator.generate()).thenReturn(10);
        frame.makeRoll();

        Mockito.when(generator.generate()).thenReturn(4);
        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertEquals(18, frame.getScore());
    }

    @Test
    void testMakeRollShouldNotThrowFinishedFrameExceptionAfterSecondTryWhenSpareAndLastRoll() {
        frame.setLastRoll(true);

        Mockito.when(generator.generate()).thenReturn(5);
        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertDoesNotThrow(() -> frame.makeRoll());

    }

    @Test
    void testMakeRollThirdTryShouldIncreaseScoreWhenSpareAndLastRoll() {
        frame.setLastRoll(true);

        Mockito.when(generator.generate()).thenReturn(5);
        frame.makeRoll();
        frame.makeRoll();

        Mockito.when(generator.generate()).thenReturn(4);
        frame.makeRoll();

        Assertions.assertEquals(14, frame.getScore());
    }

    // Utilité du test ?
    @Test
    void testMakeRollShouldThrowFinishedFrameExceptionAfterSecondTryWhenLastRoll() {
        frame.setLastRoll(true);
        
        Mockito.when(generator.generate()).thenReturn(4);

        frame.makeRoll();
        frame.makeRoll();

        Assertions.assertThrowsExactly(FinishedFrameException.class, () -> frame.makeRoll());
    }

}
