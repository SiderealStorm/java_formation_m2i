package org.example.exos.exo3;

/**
 * Exercice S23 : Joueur
 * 1. Créer une classe Joueur
 * 2. Ajouter les attributs suivants : nom, niveau et points d'expérience
 * 3. Ajouter un constructeur, des getters et des setters pour ces attributs
 * 4. Créer une méthode effectuerUneQuete() qui ajoute 15 points d'expérience au joueur
 * 5. Créer qu'une méthode qui augmente le niveau du joueur de +1 si son expérience dépasse 100 points et réinitialise son expérience
 * 6. Tester le programme
 */
public class ExoMain {
    public static void main(String[] args) {

        Joueur joueur1 = new Joueur("Toto");

        System.out.println("Nouveau joueur : " + joueur1);

        for (int i = 1 ; i <= 7 ; i++) {
            System.out.println();
            System.out.println(joueur1.getNom() + " effectue la quête n°" + i);
            joueur1.effectuerUneQuete();
        }

        System.out.println("Stats actuelles : " + joueur1);
        System.out.println();
        joueur1.setNom("T0t0");
        System.out.println("Stats actuelles : " + joueur1);

    }
}
