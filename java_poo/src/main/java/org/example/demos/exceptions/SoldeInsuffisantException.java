package org.example.demos.exceptions;

// Création d'une exception métier (= spécifique au programme)
public class SoldeInsuffisantException
// On hérite de Exception pour une exception surveillée (sinon RuntimeException
extends Exception{

    // On déclare le constructeur pour pouvoir instancier l'exception
    public SoldeInsuffisantException(String message) {
        super(message);
    }
}
