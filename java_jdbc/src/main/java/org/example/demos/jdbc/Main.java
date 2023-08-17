package org.example.demos.jdbc;

import org.example.demos.jdbc.util.DatabaseManager;

import java.sql.*;
import java.util.Scanner;

/*
Etapes pour utiliser JDBC :
    1. Ajouter la dépendance du driver JDBC au pom.xml (via mvnrepository.com ou l'outil d'ajout de dépendances de l'IDE)
    2. Créer une connexion, si possible dans une classe spécifique (généralement dans le package util)
    3. Ouvrir la connexion
    4. Faire les traitements voulus
    5. Fermer la connexion
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            // Tentative de connexion
            connection = DatabaseManager.getPostgreConnection();
            System.out.println("Connexion à la base de données établie !");
            System.out.println();

            // Saisie utilisateur
            System.out.println("Saisir le prénom de l'utilisateur");
            String firstName = scanner.nextLine();
            System.out.println("Saisir le nom de l'utilisateur");
            String lastName = scanner.nextLine();


            // Faire une requête avec Statement

            // Préparation de la requête :
            String request = "INSERT INTO person (first_name, last_name) VALUES ('" + firstName + "','" + lastName + "');";     // Ne pas oublier les quotes pour les varchars !

            // Création du statement :
            Statement statement = connection.createStatement();

            // Exécution de la requête :
            statement.execute(request);     // execute() renvoie toujours false
            System.out.println("Exécution d'une requête avec Statement");


            // Faire une requête avec PreparedStatement

            // Préparation de la requête :
            request = "INSERT INTO person (first_name, last_name) VALUES (?, ?);";      // Pas besoin de quotes car le PreparedStatement gère les types

            // Création du statement :
            PreparedStatement preparedStatement = connection.prepareStatement(request);

            // Préparation du statement :
            preparedStatement.setString(1, firstName);      // Attention l'index commence à 1 !
            preparedStatement.setString(2, lastName);

            // Exécution de la requête :
            int result = preparedStatement.executeUpdate();     // Pas de paramètre car le statement est préparé
            System.out.println("Exécution d'une requête avec PreparedStatement");
            System.out.println("Nombre de lignes affectées : " + result);    // executeUpdate() renvoie le nombre de lignes affectées


            // Idem en récupérant l'id de la ligne insérée

            preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();     // Pas de changement ici
            System.out.println("Exécution d'une requête PreparedStatement en récupérant l'ID");

            // Possibilité de récupérer un ResultSet :
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                System.out.println("Index de la ligne insérée : " + resultSet.getInt(1));
            }


            // Faire une requête avec lecture

            // Préparation de la requête :
            request = "SELECT * FROM person";

            // Création du statement :
            statement = connection.createStatement();

            // Exécution de la requête :
            resultSet = statement.executeQuery(request);     // executeQuery() renvoie toujours un ResultSet
            System.out.println("Exécution d'une requête de lecture");

            // Récupération des données du ResultSet :
            while (resultSet.next()) {
                int id = resultSet.getInt("id");    // On peut aussi passer l'indice de la colonne
                System.out.println(id + " : " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }


        } catch (SQLException e) {
            // L'utilisation d'un try/catch permet de ne pas interrompre l'exécution du programme en cas de problème de connexion
            System.out.println("Erreur de connexion à la base de données !");
            e.printStackTrace();
        } finally {
            // Si la connexion a bien été établie, on finit par la refermer
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}