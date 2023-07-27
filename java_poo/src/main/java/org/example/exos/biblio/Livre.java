package org.example.exos.biblio;

public class Livre {

    private String titre;
    private String auteur;
    private int nbPages;
    private boolean estEmprunte;

    public Livre() {}

    public Livre(String titre, String auteur, int nbPages) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.estEmprunte =false;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public boolean isEstEmprunte() {
        return estEmprunte;
    }

    @Override
    public String toString() {
        return "\'" + titre + "\' de " + auteur + " ; " + nbPages + " pages ; emprunté : " + estEmprunte;
    }

    public void empruntRetour() {
        estEmprunte = !estEmprunte;
    }

}
