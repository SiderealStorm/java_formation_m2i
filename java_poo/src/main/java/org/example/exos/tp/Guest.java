package org.example.exos.tp;

public class Guest {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private static int guestCount;

    public Guest(String firstName, String lastName, String phone) {
        this.id = ++guestCount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

}
