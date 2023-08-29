package org.example.demo.mock;

public class Jeu {

    // Au lieu d'utiliser le DeImpl, on passe par l'interface
    private De de;

    public Jeu(De de) {
        this.de = de;
    }

    public boolean jouer() {
        if (de.getValue() == 6) {
            System.out.println("Bravo !");
            return true;
        } else {
            System.out.println("Perdu...");
            return false;
        }
    }
}
