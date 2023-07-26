package org.example.exos.exo3;

public class Joueur {

    private String nom;
    private int niveau;
    private int experience;

    public Joueur() {}

    // Les valeurs de niveau et expérience sont mises par défaut pour tout nouveau joueur
    public Joueur(String nom) {
        this.nom = nom;
        this.niveau = 1;
        this.experience = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        System.out.print(this.nom + " change de pseudo pour : " + nom + "\n");
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getExperience() {
        return experience;
    }

    // Pas de setters pour le niveau et l'expérience car leur valeur ne changent qu'en cas de quête

    @Override
    public String toString() {
        return nom + ", niveau " + niveau + ", " + experience + " xp";
    }

    public void effectuerUneQuete() {
        this.experience += 15;
        System.out.println("Quête accomplie ! " + nom + " gagne 15 xp (Total : " + experience + " xp)");
        // On peut aussi appeler la méthode à chaque fois, et vérifier la condition dans la méthode
        if (this.experience >= 100) {
            monterDeNiveau();
        }
    }

    // La méthode est privée car on ne devrait pas pouvoir l'appeler depuis le main
    private void monterDeNiveau() {
        this.experience -= 100;
        this.niveau += 1;
        System.out.println("Montée de niveau : " + nom + " passe niveau " + this.niveau + " !");
    }

}
