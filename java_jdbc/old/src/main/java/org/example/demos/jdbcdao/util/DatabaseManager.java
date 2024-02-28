package org.example.demos.jdbcdao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe de connexion à la BDD
public class DatabaseManager {
    // Données de connexion :
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/demo_jdbc";
    private static final String user = "postgres";
    private static final String password = "Storm";

    // Méthode pour créer une connexion
    public static Connection getPostgreConnection() throws SQLException {

        // Création de la connexion :
        return DriverManager.getConnection(dbUrl, user, password);
    }
}
