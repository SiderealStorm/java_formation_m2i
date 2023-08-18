package org.example.demos.jdbcdao.dao;

import org.example.demos.jdbcdao.model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Chaque classe de DAO hérite de BaseDAO
public class PersonDAO extends BaseDAO<Person> {

    // Les attributs de la classe BaseDAO sont disponibles ici grâce à l'héritage

    // Le constructeur fait appel à celui du parent
    public PersonDAO(Connection connection) {
        super(connection);
    }

    // Les méthodes de la classe abstraite DOIVENT être implémentées
    @Override
    public boolean save(Person element) throws SQLException {
        query = "INSERT INTO person (first_name, last_name) VALUES (?, ?);";
        statement = _connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        int nbRows = statement.executeUpdate();
        results = statement.getGeneratedKeys();
        if(results.next()) {
            element.setId(results.getInt(1));
        }
        // On renvoie true si tout c'est bien passé, donc si on entre 1 ligne en BDD
        return nbRows == 1;
    }

    @Override
    public boolean update(Person element) throws SQLException {
        query = "UPDATE person SET first_name = ?, last_name = ? WHERE id = ?;";
        statement = _connection.prepareStatement(query);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setInt(3, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean delete(Person element) throws SQLException {
        query = "DELETE FROM person WHERE id = ?;";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public List<Person> getAll() throws SQLException {
        ArrayList<Person> personsList = new ArrayList<>();
        query = "SELECT * FROM person ORDER BY id;";
        statement = _connection.prepareStatement(query);
        results = statement.executeQuery();
        while (results.next()) {
            Person person = new Person(
                    results.getInt("id"),
                    results.getString("first_name"),
                    results.getString("last_name")
            );
            personsList.add(person);
        }
        return personsList;
    }

    @Override
    public Person get(int id) throws SQLException {
        Person person = null;
        query = "SELECT * FROM person WHERE id = ?;";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        results = statement.executeQuery();
        if (results.next()) {
            person = new Person(
                    results.getInt("id"),
                    results.getString("first_name"),
                    results.getString("last_name")
            );
        }
        return person;
    }
}
