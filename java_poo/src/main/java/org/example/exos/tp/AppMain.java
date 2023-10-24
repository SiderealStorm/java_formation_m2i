package org.example.exos.tp;

import org.example.exos.tp.hci.ConsoleHCI;

/**
 * TP : hôtel
 * Créer une classe Client possédant : un identifiant, un nom, un prénom et un numéro de téléphone
 * Créer une classe Chambre ayant : un numéro, un statut, un nombre de lits et un tarif.
 * Créer une classe Réservation possédant : un identifiant, un statut, une liste de chambres et un client
 * Créer une classe Hotel comportant : une liste de clients, une liste de chambres et une liste de réservations
 * Créer une IHM pour tester l'application
 */
public class AppMain {
    public static void main(String[] args) {

        ConsoleHCI.menu();

        // TODO améliorations possibles :
        /*
            - Formatter le texte utilisateur (nom, prénom client, nom hôtel)
            - Modifier un client
            - Modifier une réservation (ajouter/supprimer chambres)
            Pour cela, faire plusieurs menus et simplifier le menu principal pour pouvoir sélectionner "Gestion clients" et "gestion réservations" par exemple
         */
    }
}
