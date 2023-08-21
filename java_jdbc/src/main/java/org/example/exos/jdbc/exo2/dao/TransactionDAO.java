package org.example.exos.jdbc.exo2.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.exos.jdbc.exo2.model.Transaction;
import org.example.exos.jdbc.exo2.model.TransactionType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO extends BaseDAO<Transaction> {

    public TransactionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Transaction element) throws SQLException {
        query = "INSERT INTO exo2.transaction (amount, type, account_id) VALUES (?, ?, ?)";
        statement = _connection.prepareStatement(query);
        statement.setDouble(1, element.getAmount());
        statement.setString(2, element.getType().toString());
        statement.setInt(3, element.getAccountId());
        int nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean update(Transaction element) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Erreur : la méthode update() n'est pas implémentée pour TransactionDAO");
    }

    @Override
    public boolean delete(Transaction element) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Erreur : la méthode delete() n'est pas implémentée pour TransactionDAO");
    }

    @Override
    public List<Transaction> get() throws SQLException {
        ArrayList<Transaction> transactions = new ArrayList<>();

        query = "SELECT * FROM exo2.transaction ORDER BY id";
        statement = _connection.prepareStatement(query);
        results = statement.executeQuery();

        while (results.next()) {
            Transaction transaction = new Transaction(
                    results.getInt("id"),
                    results.getDouble("amount"),
                    getTransactionType(results.getString("type")),
                    results.getInt("account_id")
            );
            transactions.add(transaction);
        }

        return transactions;
    }

    @Override
    public Transaction get(int id) throws SQLException {
        Transaction transaction = null;

        query = "SELECT * FROM exo2.transaction WHERE id = ?";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        results = statement.executeQuery();

        if (results.next()) {
            transaction = new Transaction(
                    results.getInt("id"),
                    results.getDouble("amount"),
                    getTransactionType(results.getString("type")),
                    results.getInt("account_id")
            );
        }

        return transaction;
    }

    public List<Transaction> getByAccount(int id) throws SQLException {
        ArrayList<Transaction> transactions = new ArrayList<>();

        query = "SELECT * FROM exo2.transaction WHERE account_id = ? ORDER BY id";
        statement = _connection.prepareStatement(query);
        statement.setInt(1, id);
        results = statement.executeQuery();

        while (results.next()) {
            Transaction transaction = new Transaction(
                    results.getInt("id"),
                    results.getDouble("amount"),
                    getTransactionType(results.getString("type")),
                    results.getInt("account_id")
            );
            transactions.add(transaction);
        }

        return transactions;
    }

    private TransactionType getTransactionType(String stringType) {
        if (stringType.equals(TransactionType.DEPOSIT.toString())) {
            return TransactionType.DEPOSIT;
        } else {
            return TransactionType.WITHDRAWAL;
        }
    }
}
