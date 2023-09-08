package com.example.exo3.model;

public class Address {

    private String number;
    private String street;
    private String postcode;
    private String city;

    public Address() {}

    public Address(String number, String street, String postcode, String city) {
        this.number = number;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
