package org.example.exos.collections;

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
        this.estEmprunte = false;
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
    public boolean equals(Object obj) {
        if (obj instanceof Livre) {
            return this.titre.equals(((Livre) obj).getTitre())
                    && this.auteur.equals(((Livre) obj).getAuteur());
        }
        return false;
    }

    public String details() {
        String dispo = "";
        if (!estEmprunte) {
            dispo = "disponible";
        } else {
            dispo = "emprunté";
        }
        return "\'" + titre + "\' de " + auteur + " ; " + nbPages + " pages ; " + dispo;
    }

    public void empruntRetour() {
        estEmprunte = !estEmprunte;
    }

}
