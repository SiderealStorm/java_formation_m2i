package org.example.exos.tp;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Guest> guestsList;
    private ArrayList<Room> roomsList;
    private ArrayList<Booking> bookingList;

    public Hotel(ArrayList<Room> roomsList) {
        this.guestsList = new ArrayList<>();
        // TODO remplacer par une création de chambres aléatoire
        this.roomsList = roomsList;
        this.bookingList = new ArrayList<>();
    }

}
