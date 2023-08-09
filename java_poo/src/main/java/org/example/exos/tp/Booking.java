package org.example.exos.tp;

import java.util.ArrayList;

public class Booking {

    public int id;
    //TODO remplacer par une énum : en cours (true) ou terminée (false)
    public boolean ongoing;
    public ArrayList<Room> roomsList;
    public Guest occupant;
    public static int bookingCount;

    public Booking(ArrayList<Room> roomsList, Guest occupant) {
        this.id = ++bookingCount;
        this.ongoing = true;
        this.roomsList = roomsList;
        this.occupant = occupant;
    }

    @Override
    public String toString() {
        String status;
        if (ongoing) {
            status = "en cours";
        } else {
            status = "terminée";
        }
        return "Réservation n°" + id + " - " + status +
                "\n\tClient : " + occupant.firstName + " " + occupant.lastName + ", téléphone : " + occupant.phone +
                "\n\tChambres : " + roomsList;
    }

    public void printBooking() {
        String status;
        if (ongoing) {
            status = "en cours";
        } else {
            status = "terminée";
        }
        System.out.println("Réservation n°" + id + " - " + status +
                "\n\tClient : " + occupant.firstName + " " + occupant.lastName + ", téléphone : " + occupant.phone +
                "\n\tChambres :");
        for (Room room : roomsList) {
            System.out.println("\t\t- " + room);
        }
    }


    public void cancelBooking() {
        this.ongoing = false;
        for (Room room : this.roomsList) {
            room.occupied = false;
        }
    }

}
