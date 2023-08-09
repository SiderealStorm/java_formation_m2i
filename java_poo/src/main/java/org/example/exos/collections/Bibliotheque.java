package org.example.exos.collections;

import java.util.ArrayList;

public class Bibliotheque {

    private ArrayList<Livre> livres;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        this.livres.add(livre);
    }

    public void afficherLivres() {
        for (Livre livre : this.livres) {
            System.out.println(livre.details());
        }
    }

    public int trouverLivreParTitreAuteur(String titre, String auteur) {
        Livre livreCherche = new Livre(titre, auteur, 0);
        for (Livre livre : livres) {
            if (livre.equals(livreCherche)) {
                return livres.indexOf(livre);
            }
        }
        System.out.println("Le livre \'" + titre + "\' de " + auteur + " n'existe pas dans la bibliothèque");
        return -1;
    }

    public void supprimerLivreParTitreAuteur(String titre, String auteur) {
        if (trouverLivreParTitreAuteur(titre, auteur) >= 0) {
            this.livres.remove(trouverLivreParTitreAuteur(titre, auteur));
        }
    }

    public void emprunterLivreParTitreAuteur(String titre, String auteur) {
        if (trouverLivreParTitreAuteur(titre, auteur) >= 0) {
            emprunterLivreParIndice(trouverLivreParTitreAuteur(titre, auteur));
        }
    }

    public void retournerLivreParTitreAuteur(String titre, String auteur) {
        if (trouverLivreParTitreAuteur(titre, auteur) >= 0) {
            retournerLivreParIndice(trouverLivreParTitreAuteur(titre, auteur));
        }
    }

    public void supprimerLivreParIndice(int index) {
        this.livres.remove(index);
    }


    public void emprunterLivreParIndice(int index) {
        if (!livres.get(index).isEstEmprunte()) {
            livres.get(index).empruntRetour();
        } else {
            System.out.println("Le livre \'" + livres.get(index).getTitre() + "\' est déjà emprunté");
        }
    }

    public void retournerLivreParIndice(int index) {
        if (livres.get(index).isEstEmprunte()) {
            livres.get(index).empruntRetour();
        } else {
            System.out.println("Le livre \'" + livres.get(index).getTitre() + "\' est déjà dans la bibliothèque");
        }
    }



}
