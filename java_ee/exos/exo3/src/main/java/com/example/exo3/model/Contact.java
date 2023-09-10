package com.example.exo3.model;

import java.time.LocalDate;

public class Contact extends Person {

    private static int count;

    private int id;
    private String phone;

    private String address;
    // TODO improvement : use Address object instead of String
//    private Address address;


    public Contact() {}

    public Contact(String firstName, String lastName, LocalDate birthDate, String email, String phone, String address) {
        super(firstName, lastName, birthDate, email);
        this.phone = phone;
        this.address = address;
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
