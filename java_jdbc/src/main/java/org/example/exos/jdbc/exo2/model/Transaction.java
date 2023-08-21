package org.example.exos.jdbc.exo2.model;

public class Transaction {

    private int id;
    private double amount;
    private TransactionType type;
    private int accountId;

    public Transaction() {}

    public Transaction(double amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
    }

    public Transaction(double amount, TransactionType type, int accountId) {
        this(amount, type);
        this.accountId = accountId;
    }

    public Transaction(int id, double amount, TransactionType type, int accountId) {
        this(amount, type, accountId);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return id + " - " + type.getLabel() + " de " + amount + " € sur le compte n°" + accountId;
    }
}
