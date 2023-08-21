package org.example.exos.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/exos_jdbc";
    private static final String user = "postgres";
    private static final String password = "Storm";

    public static Connection getPostgreConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, user, password);
    }
}
