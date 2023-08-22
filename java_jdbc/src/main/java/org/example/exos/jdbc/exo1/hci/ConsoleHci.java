package org.example.exos.jdbc.exo1.hci;

import org.example.exos.jdbc.exo1.classes.Student;
import org.example.exos.jdbc.util.ConnectDB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ConsoleHci {
    private static final Scanner scanner = new Scanner(System.in);
    private static Connection connection = null;

    public static void start() {
        try {
            connection = ConnectDB.getPostgreConnection();

            menu();

        } catch (SQLException e) {
            System.out.println("Connexion BDD échouée");
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

    private static void menu() throws SQLException {
        int choice;

        do {
            System.out.println();
            System.out.println("=== Menu principal ===");
            System.out.println("1. Afficher tous les étudiants");
            System.out.println("2. Afficher les étudiants d'une classe");
            System.out.println("3. Ajouter un étudiant");
            System.out.println("4. Effacer un étudiant");
            System.out.println("0. Quitter");
            choice = inputChoice();

            switch (choice) {
                case 0 -> System.out.println("A bientôt");
                case 1 -> displayStudents(getAllStudents());
                case 2 -> displayStudents(getStudentsByClass());
                case 3 -> addStudent();
                case 4 -> deleteStudent();
                default -> System.out.println("Veuillez saisir un nombre valide !");
            }

        } while (choice != 0);
    }

    private static int inputChoice() {
        System.out.print("Votre choix : ");
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de saisie !");
        }
        scanner.nextLine();
        return choice;
    }

    private static Date checkDate() {
        Date date = null;
        do {
            System.out.println("Date de diplôme (jj-mm-aaaa) : ");
            String inputDate = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                date = simpleDateFormat.parse(inputDate);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Erreur de saisie de la date !");
            }
        } while (date == null);
        return date;
    }

    private static void addStudent() throws SQLException {
        Student student = new Student();

        // Saisies utilisateur
        System.out.println("=== Ajout d'un étudiant ===");
        System.out.print("Nom : ");
        student.setLastName(scanner.nextLine());
        System.out.print("Prénom : ");
        student.setFirstName(scanner.nextLine());
        System.out.print("Numéro de classe : ");
        student.setClasseNb(scanner.nextInt());
        scanner.nextLine();
        student.setDegreeDate(checkDate());

        // Ajout en BDD
        String query = "INSERT INTO exo1.student (last_name, first_name, class_number, degree_date) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, student.getLastName());
        statement.setString(2, student.getFirstName());
        statement.setInt(3, student.getClasseNb());
        statement.setDate(4, new java.sql.Date(student.getDegreeDate().getTime()));

        int rows = statement.executeUpdate();
        if (rows == 0) {
            System.out.println("Erreur : l'étudiant n'a pas été ajouté à la base de données");
        } else {
            System.out.println("Ajout de " + rows + " étudiant dans la base de données");
        }
    }

    private static ArrayList<Student> getAllStudents() throws SQLException {
        ArrayList<Student> studentsList = new ArrayList<>();
        System.out.println();
        String query = "SELECT * FROM exo1.student";
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            Student student = new Student(
                    results.getInt("id"),
                    results.getString("last_name"),
                    results.getString("first_name"),
                    results.getInt("class_number"),
                    results.getDate("degree_date")
            );
            studentsList.add(student);
        }
        return studentsList;
    }

    private static ArrayList<Student> getStudentsByClass() throws SQLException {
        int classNb;
        ArrayList<Student> studentsList = new ArrayList<>();
        System.out.println();
        System.out.print("Entrez le numéro de la classe : ");
        classNb = scanner.nextInt();
        scanner.nextLine();

        String query = "SELECT * FROM exo1.student WHERE class_number = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, classNb);
        ResultSet results = statement.executeQuery();

        while (results.next()) {
            Student student = new Student(
                    results.getInt("id"),
                    results.getString("last_name"),
                    results.getString("first_name"),
                    results.getInt("class_number"),
                    results.getDate("degree_date")
            );
            studentsList.add(student);
        }
        return studentsList;
    }

    private static void displayStudents(ArrayList<Student> studentsList) {
        for (Student student : studentsList) {
            System.out.println(student);
        }
    }

    private static void deleteStudent() throws SQLException {
        System.out.println();
        System.out.println("Quel étudiant voulez-vous effacer ?");
        displayStudents(getAllStudents());
        int id = inputChoice();
        
        String query = "DELETE FROM exo1.student WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        int rows = statement.executeUpdate();
        if (rows == 0) {
            System.out.println("Erreur : l'étudiant n'a pas été effacé de la base de données");
        } else {
            System.out.println("Suppression de " + rows + " étudiant de la base de données");
        }
    }

}
