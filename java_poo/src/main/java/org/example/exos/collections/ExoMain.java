package org.example.exos.collections;

/**
 * Exercice Listes 1 : bibliothèque
 * - Créer une classe "Livre" avec les attributs suivants : titre, auteur, nombre de pages et estEmprunté (par défaut false)
 * - Ajouter un constructeur, des getters et des setters pour ces attributs
 * - Créer une méthode pour afficher les informations sur le livre et une autre pour changer l'état d'emprunt
 * - Créer une classe "Bibliothèque" avec un tableau de "Livre" et les méthodes suivantes :
 *      - Ajouter un livre à la collection
 *      - Supprimer un livre de la collection
 *      - Afficher la liste de tous les livres
 *      - Emprunter un livre (changer l'état d'emprunt à true)
 *      - Retourner un livre (changer l'état d'emprunt à false)
 * - Utiliser la classe "Bibliothèque" pour créer une bibliothèque avec plusieurs livres et afficher la liste de tous les livres
 * - Emprunter et retournez un livre, puis affichez à nouveau la liste de tous les livres pour vérifier que l'état d'emprunt a bien été modifié
 */
public class ExoMain {
    public static void main(String[] args) {

        Bibliotheque biblio = new Bibliotheque();

        Livre hobbit = new Livre("Bilbo le Hobbit", "J.R.R. Tolkien", 843);
        Livre tintin = new Livre("Tintin au Tibet", "Hergé", 62);
        Livre hp1 = new Livre("Harry Potter à l'école des Sorciers", "J.K. Rowling", 578);

        // Ajout des livres
        biblio.ajouterLivre(hobbit);
        biblio.ajouterLivre(tintin);
        biblio.ajouterLivre(hp1);
        biblio.ajouterLivre(new Livre("Toto va à l'école", "Marie Dupont", 12));

        // Affichage
        biblio.afficherLivres();
        System.out.println();

        System.out.println("Emprunt de trois livres :");
        biblio.emprunterLivreParIndice(0);
        biblio.emprunterLivreParIndice(1);
        biblio.emprunterLivreParTitreAuteur("Toto va à l'école", "Marie Dupont");

        biblio.afficherLivres();
        System.out.println();

        System.out.println("Retour de deux livres :");
        biblio.retournerLivreParIndice(1);
        biblio.retournerLivreParTitreAuteur("Toto va à l'école", "Marie Dupont");

        biblio.afficherLivres();
        System.out.println();

        System.out.println("Suppression de deux livres :");
        biblio.supprimerLivreParIndice(2);
        biblio.supprimerLivreParTitreAuteur("Toto va à l'école", "Marie Dupont");

        biblio.afficherLivres();
        System.out.println();

        System.out.println("Test des messages d'erreur :");
        biblio.emprunterLivreParIndice(0);
        biblio.retournerLivreParIndice(1);
        biblio.emprunterLivreParTitreAuteur("Un Livre à emprunter", "Auteur Inconnu");
        biblio.supprimerLivreParTitreAuteur("Un Livre à supprimer", "Auteur Inconnu");

        biblio.afficherLivres();

    }
}
