package org.example.demos.jdbcdao.service;

import org.example.demos.jdbcdao.dao.PersonDAO;
import org.example.demos.jdbcdao.model.Person;
import org.example.demos.jdbcdao.util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// En général, on crée un service par DAO, mais on peut aussi en regrouper plusieurs dans un seul service
public class PersonService {

    private PersonDAO personDAO;
    private Connection connection;

    public PersonService() {
        try {
            connection = DatabaseManager.getPostgreConnection();
            personDAO = new PersonDAO(connection);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BDD");
            e.printStackTrace();
        }
    }

    public boolean createPerson(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        try {
            if(personDAO.save(person)) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BDD");
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePerson(Person person) {
        try {
            if(personDAO.update(person)) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BDD");
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePerson(int id) {
        Person person;
        try {
            person = personDAO.get(id);
            if(person != null) {
                return personDAO.delete(person);
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BDD");
            e.printStackTrace();
        }
        return false;
    }

    public Person getPerson(int id) {
        try {
            return personDAO.get(id);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BDD");
            e.printStackTrace();
        }
        return null;
    }

    public List<Person> getAllPersons() {
        try {
            return personDAO.getAll();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BDD");
            e.printStackTrace();
        }
        return null;
    }
}
