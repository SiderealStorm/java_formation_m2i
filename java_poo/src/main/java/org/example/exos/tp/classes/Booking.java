package org.example.exos.tp.classes;

import java.util.ArrayList;

public class Booking {

    private final int id;
    private boolean ongoing;
    private ArrayList<Room> roomsList;
    private Guest guest;
    private static int bookingCount;

    public Booking(ArrayList<Room> roomsList, Guest guest) {
        this.id = ++bookingCount;
        this.ongoing = true;
        this.roomsList = roomsList;
        this.guest = guest;
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

    public void displayBooking() {
        String status;
        if (ongoing) {
            status = "en cours";
        } else {
            status = "terminée";
        }
        System.out.println("Réservation n°" + id + " - " + status +
                "\n\tClient : " + guest.getFirstName() + " " + guest.getLastName() + " - téléphone : " + guest.getPhone() +
                "\n\tChambres :");
        for (Room room : roomsList) {
            System.out.println("\t\t- " + room);
        }
    }

    public void cancelBooking() {
        this.ongoing = false;
        for (Room room : this.roomsList) {
            room.setOccupied(false);
        }
    }

}
