package org.example.exos.jdbc.exo2.model;

import java.util.List;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private List<BankAccount> accountsList;

    public Customer() {}

    public Customer(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Customer(int id, String firstName, String lastName, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<BankAccount> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<BankAccount> accountsList) {
        this.accountsList = accountsList;
    }

    @Override
    public String toString() {
        return "Client n°" + id + " : " + firstName + " " + lastName + " - Téléphone : " + phone;
    }
}
