package org.example.exos.tp;

import java.util.ArrayList;

public class Booking {

    private int id;
    // TODO remplacer par une énum : en cours (true) ou terminée (false)
    private boolean status;
    private ArrayList<Room> roomsList;
    private Guest occupant;
    private static int bookingCount;

    public Booking(ArrayList<Room> roomsList, Guest occupant) {
        this.id = ++bookingCount;
        this.status = true;
        this.roomsList = roomsList;
        this.occupant = occupant;
    }

}
