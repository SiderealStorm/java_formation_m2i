package com.example.exo3.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private String password;

    private final List<Contact> contacts;

    public User() {
        this.contacts = new ArrayList<>();
    }

    // TODO remove constructor after testing app
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.contacts = new ArrayList<>();
    }

    public User(String firstName, String lastName, LocalDate birthDate, String email, String password) {
        super(firstName, lastName, birthDate, email);
        this.password = password;
        this.contacts = new ArrayList<>();
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

    public void removeContact(Contact contact) {
        this.contacts.remove(contact);
    }
}
