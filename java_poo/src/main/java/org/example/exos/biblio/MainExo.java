package org.example.exos.biblio;

/*
Exercice Listes 1 : bibliothèque
- Créer une classe "Livre" avec les attributs suivants : titre, auteur, nombre de pages et estEmprunté (par défaut false)
- Ajouter un constructeur, des getters et des setters pour ces attributs
- Créer une méthode pour afficher les informations sur le livre et une autre pour changer l'état d'emprunt
- Créer une classe "Bibliothèque" avec un tableau de "Livre" et les méthodes suivantes :
    - Ajouter un livre à la collection
    - Supprimer un livre de la collection
    - Afficher la liste de tous les livres
    - Emprunter un livre (changer l'état d'emprunt à true)
    - Retourner un livre (changer l'état d'emprunt à false)
- Utiliser la classe "Bibliothèque" pour créer une bibliothèque avec plusieurs livres et afficher la liste de tous les livres
- Emprunter et retournez un livre, puis affichez à nouveau la liste de tous les livres pour vérifier que l'état d'emprunt a bien été modifié
 */
public class MainExo {
    public static void main(String[] args) {

        Bibliotheque biblio = new Bibliotheque();

        Livre hobbit = new Livre("Bilbo le Hobbit", "J.R.R. Tolkien", 843);
        Livre tintin = new Livre("Tintin au Tibet", "Hergé", 62);
        Livre hp1 = new Livre("Harry Potter à l'école des Sorciers", "J.K. Rowling", 578);

        // Ajout des livres
        biblio.ajouterLivre(hobbit);
        biblio.ajouterLivre(tintin);
        biblio.ajouterLivre(hp1);

        // Affichage
        biblio.afficherLivres();
        System.out.println();

        // Emprunt de deux livres :
        biblio.emprunterLivre(0);
        biblio.emprunterLivre(1);

        biblio.afficherLivres();
        System.out.println();

        // Retour d'un livre
        biblio.retournerLivre(1);

        biblio.afficherLivres();
        System.out.println();

        // Test des messages d'erreur emprunt/retour
        biblio.emprunterLivre(0);
        biblio.retournerLivre(1);

        biblio.afficherLivres();
        System.out.println();

        // Suppression d'un livre
        biblio.supprimerLivre(2);

        biblio.afficherLivres();
        System.out.println();

    }
}
