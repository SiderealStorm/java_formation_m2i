package com.example.exo3.model;

public class Contact extends Person {

    private static int count;

    private int id;
    private String phone;

    private String address;
    // TODO utiliser un objet Address à la place d'une String
//    private Address address;


    public Contact() {}

    public Contact(String firstName, String lastName, String email, String phone, String address) {
        super(firstName, lastName, email);
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
