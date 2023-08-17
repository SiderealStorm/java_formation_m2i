package org.example.exos.jdbc1;

import org.example.exos.jdbc1.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

/*
Exercice JDBC 1 :
Réalisez une application en java qui demande à l'utilisateur de saisir :
- Nom
- Prénom
- numéro de classe
- Date de diplôme
L'application ajoutera les données dans une table student.
On souhaite modifier notre application pour ajouter les fonctionnalités suivantes :
- Afficher la totalité des étudiants.
- Afficher les étudiants d'une classes.
- Supprimer un étudiant.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            connection = ConnectDB.getPostgreConnection();

            // Saisies utilisateur
            System.out.println("=== Ajout d'un étudiant ===");
            System.out.print("Nom : ");
            String lastName = scanner.nextLine();
            System.out.print("Prénom : ");
            String firstName = scanner.nextLine();
            System.out.print("Numéro de classe : ");
            int classNum = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Date de diplôme (jj-mm-aaaa) : ");
            String inputDate = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date diplomaDate = simpleDateFormat.parse(inputDate);

            // Ajout en BDD
            String query = "INSERT INTO student (last_name, first_name, class_number, diploma_date) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setInt(3, classNum);
            statement.setDate(4, new java.sql.Date(diplomaDate.getTime()));

            int rows = statement.executeUpdate();
            if (rows == 0) {
                System.out.println("Erreur : l'étudiant n'a pas été ajouté à la base de données");
            } else {
                System.out.println("Ajout de " + rows + " étudiant dans la base de données");
            }

            

        } catch (SQLException e) {
            System.out.println("Connexion BDD échouée");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
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
