package org.example.exos.tp.classes;

import java.util.random.RandomGenerator;

public class Room {

    private final int roomNumber;
    private boolean occupied;
    private int beds;
    private double price;

    public Room(int roomNumber, double bedPrice) {
        this.roomNumber = roomNumber;
        // On génère aléatoirement 1 à 3 lits par chambre
        this.beds = RandomGenerator.getDefault().nextInt(1, 4);
        // On calcule le prix de la chambre en fonction du prix d'un lit (en paramètre)
        this.price = calculateRoomPrice(bedPrice);
        this.occupied = false;
    }

    private double calculateRoomPrice(double bedPrice) {
        // Une réduction est appliquée au prix du lit si la chambre en comporte plusieurs ;
        // Plus la chambre a de lits, plus la réduction est importante
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

//        // Condition classique :
//        String status;
//        if (occupied) {
//            status = "occupée";
//        } else {
//            status = "libre";
//        }

        // Utilisation d'un ternaire pour simplifier l'écriture de la condition :
        String status = occupied ? "occupée" : "libre";

        return "Chambre n°" + roomNumber + " : " + beds + " lit(s), " + price + " € la nuit - " + status;
    }

}
