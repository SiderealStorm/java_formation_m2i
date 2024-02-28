package org.example.exos.jdbc.exo2.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.exos.jdbc.exo2.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends BaseDAO<Customer> {

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Customer element) throws SQLException {
        query = "INSERT INTO exo2.customer (first_name, last_name, phone) VALUES (?, ?, ?)";
        statement = _connection.prepareStatement(query);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setString(3, element.getPhone());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean update(Customer element) throws SQLException {
        query = "UPDATE exo2.customer SET first_name = ?, last_name = ?, phone = ? WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setString(3, element.getPhone());
        statement.setInt(4, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean delete(Customer element) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Erreur : la méthode delete() n'est pas implémentée pour CustomerDAO");
    }

    @Override
    public List<Customer> get() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();

        query = "SELECT * FROM exo2.customer ORDER BY id";
        statement = _connection.prepareStatement(query);
        results = statement.executeQuery();

        while (results.next()) {
            Customer customer = new Customer(
                    results.getInt("id"),
                    results.getString("first_name"),
                    results.getString("last_name"),
                    results.getString("phone")
            );
            customers.add(customer);
        }

        return customers;
    }

    @Override
    public Customer get(int id) throws SQLException {
        Customer customer = null;

        query = "SELECT * FROM exo2.customer WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        results = statement.executeQuery();

        if (results.next()) {
            customer = new Customer(
                    results.getInt("id"),
                    results.getString("first_name"),
                    results.getString("last_name"),
                    results.getString("phone")
            );
        }

        return customer;
    }
}
