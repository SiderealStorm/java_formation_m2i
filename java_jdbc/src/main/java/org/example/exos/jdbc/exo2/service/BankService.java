package org.example.exos.jdbc.exo2.service;

import org.example.exos.jdbc.exo2.model.BankAccount;
import org.example.exos.jdbc.exo2.model.Customer;
import org.example.exos.jdbc.exo2.model.Transaction;
import org.example.exos.jdbc.exo2.model.TransactionType;
import org.example.exos.jdbc.util.ConnectDB;
import org.example.exos.jdbc.exo2.dao.BankAccountDAO;
import org.example.exos.jdbc.exo2.dao.CustomerDAO;
import org.example.exos.jdbc.exo2.dao.TransactionDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankService {

    private TransactionDAO transactionDAO;
    private BankAccountDAO bankAccountDAO;
    private CustomerDAO customerDAO;

    public BankService() {
        try {
            Connection connection = ConnectDB.getPostgreConnection();
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

    // Une partie de cette méthode aurait pu être gérée par le modèle BankAccount
    public boolean makeTransaction(int accountId, double amount, TransactionType type) {
        try {
            BankAccount account = bankAccountDAO.get(accountId);
            if (account != null && bankAccountDAO.update(account)) {
                Transaction transaction = new Transaction(amount, type, accountId);
                if(transactionDAO.save(transaction)) {
                    if (type.equals(TransactionType.WITHDRAWAL)) {
                        amount = -amount;
                    }
                    account.setBalance(account.getBalance() + amount);
                    bankAccountDAO.update(account);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkWithdrawal(BankAccount account, Double amount) {
        return account.getBalance() > amount;
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

    public List<Transaction> getTransactions(int id) {
        try {
            return transactionDAO.getByAccount(id);
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
