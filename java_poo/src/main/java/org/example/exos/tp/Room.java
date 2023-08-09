package org.example.exos.tp;

import java.util.random.RandomGenerator;

public class Room {

    public int roomNumber;
    public boolean occupied;
    public int beds;
    public double price;

    public Room (int roomNumber, double price) {
        this.roomNumber = roomNumber;
        this.beds = RandomGenerator.getDefault().nextInt(1, 4);
        this.price = price;
        this.occupied = false;
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
