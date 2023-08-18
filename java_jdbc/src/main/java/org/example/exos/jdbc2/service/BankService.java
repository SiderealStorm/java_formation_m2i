package org.example.exos.jdbc2.service;

import org.example.demos.jdbcdao.util.DatabaseManager;
import org.example.exos.jdbc2.dao.BankAccountDAO;
import org.example.exos.jdbc2.dao.CustomerDAO;
import org.example.exos.jdbc2.dao.TransactionDAO;
import org.example.exos.jdbc2.model.BankAccount;
import org.example.exos.jdbc2.model.Customer;
import org.example.exos.jdbc2.model.Transaction;
import org.example.exos.jdbc2.model.TransactionType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankService {

    private TransactionDAO transactionDAO;
    private BankAccountDAO bankAccountDAO;
    private CustomerDAO customerDAO;

    public BankService() {
        try {
            Connection connection = DatabaseManager.getPostgreConnection();
            bankAccountDAO = new BankAccountDAO(connection);
            transactionDAO = new TransactionDAO(connection);
            customerDAO = new CustomerDAO(connection);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BDD");
            e.printStackTrace();
        }
    }

    public boolean addCustomer(String firstName, String lastName, String phone) {
        Customer customer = new Customer(firstName, lastName, phone);
        try {
            if (customerDAO.save(customer)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createAccount(int customerId) {
        BankAccount account = new BankAccount(0, customerId);
        try {
            if(bankAccountDAO.save(account)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean makeTransaction(int accountId, double amount, TransactionType type) {
        try {
            BankAccount account = bankAccountDAO.get(accountId);
            if (account != null && bankAccountDAO.update(account)) {
                if (type.equals(TransactionType.WITHDRAWAL)) {
                    amount = -amount;
                }
                Transaction transaction = new Transaction(amount, type, accountId);
                if(transactionDAO.save(transaction)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Customer> getAllCustomers() {
        try {
            return customerDAO.get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer getCustomer(int id) {
        try {
            return customerDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Transaction> getAllTransactions() {
        try {
            return transactionDAO.get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BankAccount> getAllAccounts() {
        try {
            return bankAccountDAO.get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BankAccount getAccount(int id) {
        try {
            return bankAccountDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
