package org.example.exos.jdbc.exo2.model;

import java.util.List;

public class BankAccount {

    private int id;
    private double balance;
    // En JDBC, il est plus simple de référencer le client par son ID que par un objet client complet
    private int customerId;
    private List<Transaction> transactions;

    public BankAccount() {}

    public BankAccount(double balance, int customerId) {
        this.balance = balance;
        this.customerId = customerId;
    }

    public BankAccount(int id, double balance, int customerId) {
        this.id = id;
        this.balance = balance;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Compte n°" + id + " : - Solde : " + balance + " €";
    }
}
