package org.example.exos.biblio;

import java.util.ArrayList;

public class Bibliotheque {

    private ArrayList<Livre> livres;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        this.livres.add(livre);
    }

    public void trouverLivreParTitreAuteur(String titre, String auteur) {
        // TODO Faire en sorte de pouvoir supprimer, emprunter et rendre un livre en donnant son titre et son auteur
    }

    public void supprimerLivreParIndice(int index) {
            this.livres.remove(index);
    }

    public void afficherLivres() {
        for (Livre livre : this.livres) {
            System.out.println(livre.details());
        }
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
