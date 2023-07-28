package org.example.exos.tp;

public class Room {

    private int roomNumber;
    private boolean occupied;
    private int beds;
    private double price;

    public Room (int roomNumber, int beds, double price) {
        this.roomNumber = roomNumber;
        // TODO remplacer par un nombre de lits aléatoire ?
        this.beds = beds;
        this.price = price;
        this.occupied = false;
    }

}
