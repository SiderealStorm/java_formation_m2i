package org.example.exos.tp.classes;

import java.util.ArrayList;

public class Booking {

    private final int id;
    private boolean ongoing;
    private ArrayList<Room> roomsList;
    private Guest guest;
    private double totalCost;
    private static int bookingCount;

    public Booking(ArrayList<Room> roomsList, Guest guest) {
        this.id = ++bookingCount;
        this.ongoing = true;
        this.roomsList = roomsList;
        this.guest = guest;
        // Calcul du prix total de la réservation :
        calculateTotalCost();
    }

    public int getId() {
        return id;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public ArrayList<Room> getRoomsList() {
        return roomsList;
    }

    public Guest getGuest() {
        return guest;
    }

    @Override
    public String toString() {
        String status = ongoing ? "en cours" : "terminée";
        String message = "Réservation n°" + id + " - " + status +
                "\n\tClient : " + guest +
                "\n\tChambres :\n";
        for (Room room : roomsList) {
            message += "\t\t- " + room + "\n";
        }

        return message;
    }

    private void calculateTotalCost() {
        for (Room room : roomsList) {
            this.totalCost += room.getPrice();
        }
    }

//    // Ancienne méthode avant création du toString()
//    public void displayBooking() {
//        String status;
//        if (ongoing) {
//            status = "en cours";
//        } else {
//            status = "terminée";
//        }
//        System.out.println("Réservation n°" + id + " - " + status +
//                "\n\tClient : " + guest +
//                "\n\tChambres :");
//        for (Room room : roomsList) {
//            System.out.println("\t\t- " + room);
//        }
//        System.out.println("\tCoût total : " + totalCost + " € par nuit");
//    }

    public void cancelBooking() {
        this.ongoing = false;
        for (Room room : this.roomsList) {
            room.setOccupied(false);
        }
    }

}
