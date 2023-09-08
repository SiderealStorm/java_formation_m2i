package com.example.exo3.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private String password;

    private List<Contact> contacts;

    public User() {
        this.contacts = new ArrayList<>();
    }

    public User(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
}
