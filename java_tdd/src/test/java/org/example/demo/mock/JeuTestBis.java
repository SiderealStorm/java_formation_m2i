package org.example.demo.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// Avec utilisation de Mockito

// On déclare que la classe utilise (extends) Mockito
@ExtendWith(MockitoExtension.class)
public class JeuTestBis {

    // On précise quelle classe ou interface on veut simuler
    @Mock
    private DeImpl de;
    private Jeu jeu;

    @Test
    public void testWin() {
        // Plus besoin de redéfinir les méthodes dans une classe implémentée
        Mockito.when(de.getValue()).thenReturn(6);

        jeu = new Jeu(de);

        boolean result = jeu.jouer();

        Assertions.assertTrue(result);
    }


    @Test
    public void testLose() {
        Mockito.when(de.getValue()).thenReturn(1);

        boolean result = jeu.jouer();

        Assertions.assertFalse(result);
    }
}
