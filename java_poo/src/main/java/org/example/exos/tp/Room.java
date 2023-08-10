package org.example.exos.tp;

import java.util.random.RandomGenerator;

public class Room {

    private final int roomNumber;
    private boolean occupied;
    private int beds;
    private double price;

    public Room(int roomNumber, double bedPrice) {
        this.roomNumber = roomNumber;
        this.beds = RandomGenerator.getDefault().nextInt(1, 4);
        this.price = calculateRoomPrice(bedPrice);
        this.occupied = false;
    }

    private double calculateRoomPrice(double bedPrice) {
        return Math.round(bedPrice * beds * (1 - (beds - 1)/100. * 10) * 100) / 100.0;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String status;
        if (occupied) {
            status = "occupée";
        } else {
            status = "libre";
        }
        return "Chambre n°" + roomNumber + " : " + beds + " lit(s), " + price + " € la nuit, " + status;
    }

}
