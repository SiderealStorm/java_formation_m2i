package org.example.exos.jdbc.exo2.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.exos.jdbc.exo2.model.BankAccount;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO extends BaseDAO<BankAccount> {

    public BankAccountDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(BankAccount element) throws SQLException {
        query = "INSERT INTO exo2.bank_account (balance, customer_id) VALUES (?, ?)";
        statement = _connection.prepareStatement(query);
        statement.setDouble(1, element.getBalance());
        statement.setInt(2, element.getCustomerId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean update(BankAccount element) throws SQLException {
        query = "UPDATE exo2.bank_account SET balance = ?, customer_id = ? WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setDouble(1, element.getBalance());
        statement.setInt(2, element.getCustomerId());
        statement.setInt(3, element.getId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean delete(BankAccount element) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Erreur : la méthode delete() n'est pas implémentée pour BanKAccountDAO");
    }

    @Override
    public List<BankAccount> get() throws SQLException {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        query = "SELECT * FROM exo2.bank_account ORDER BY id";
        statement = _connection.prepareStatement(query);
        results = statement.executeQuery();

        while (results.next()) {
            BankAccount customer = new BankAccount(
                    results.getInt("id"),
                    results.getDouble("balance"),
                    results.getInt("customer_id")
            );
            accounts.add(customer);
        }

        return accounts;
    }

    @Override
    public BankAccount get(int id) throws SQLException {
        BankAccount account = null;

        query = "SELECT * FROM exo2.bank_account WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        results = statement.executeQuery();

        if (results.next()) {
            account = new BankAccount(
                    results.getInt("id"),
                    results.getDouble("balance"),
                    results.getInt("customer_id")
            );
        }

        return account;
    }
}
