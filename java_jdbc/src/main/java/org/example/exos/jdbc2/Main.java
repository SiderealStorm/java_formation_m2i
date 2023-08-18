package org.example.exos.jdbc2;

import org.example.exos.jdbc2.dao.TransactionDAO;
import org.example.exos.jdbc2.model.Customer;
import org.example.exos.jdbc2.model.Transaction;
import org.example.exos.jdbc2.model.TransactionType;
import org.example.exos.jdbc2.view.ConsoleHci;
import org.example.exos.util.ConnectDB;

import java.sql.SQLException;

/*
- Créer une classe CompteBancaire Cette classe aura : un solde, un client et une liste d'opérations(dépôt ou retrait).
- Créer une classe Client avec les attributs suivants : nom, prénom, identifiant, liste des comptes et numéro de téléphone. On créera le client au début de l'application
- Créer une classe Opération avec les attributs suivants : numéro, montant et statut (depot/retrait en enum)
- Créer une IHM pour tester l'application. Pour un compte au choix de l'utilisateur on pourra effectuer un dépôt, un retrait ou afficher le solde et les opérations
- Ajouter une couche base de données pour gérer les comptes bancaires.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleHci.start();
    }
}
