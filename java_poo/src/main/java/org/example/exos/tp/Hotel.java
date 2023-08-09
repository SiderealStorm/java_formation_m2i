package org.example.exos.tp;

import java.util.ArrayList;

public class Hotel {

    public String name;
    public ArrayList<Guest> guestsList;
    public ArrayList<Room> roomsList;
    public ArrayList<Booking> bookingList;

    public Hotel(String name) {
        this.name = name;
        this.guestsList = new ArrayList<>();
        // TODO remplacer par une création de chambres aléatoire
        this.roomsList = new ArrayList<>();
        this.roomsList.add(new Room(101, 39.99));
        this.roomsList.add(new Room(102, 44.99));
        this.roomsList.add(new Room(103, 49.99));

        this.bookingList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + " : " + roomsList.size() + " chambres, " + guestsList.size() + " clients";
    }

    public void addGuest(Guest guest) {
        guestsList.add(guest);
    }

    public void displayGuests() {
        if (guestsList.size() > 0) {
            System.out.println("=== Clients de l'hôtel " + name + " ===");
            for (Guest guest : guestsList) {
                System.out.println(guest);
            }
        } else {
            System.out.println("Il n'y a pas encore de client enregistré");
        }
    }

    public void displayRooms() {
        System.out.println("=== Chambres de l'hôtel " + name + " ===");
        for (Room room : roomsList) {
            System.out.println(room);
        }
    }

    public void displayAllBookings() {
        if (bookingList.size() > 0) {
            System.out.println("=== Réservations de l'hôtel " + name + " ===");
            for (Booking booking : bookingList) {
                booking.printBooking();
            }
        } else {
            System.out.println("Il n'y a aucune réservation pour le moment");
        }
    }

    public void displayOngoingBookings() {
        boolean hasBooking = false;
        if (bookingList.size() > 0) {
            System.out.println("=== Réservations en cours de l'hôtel " + name + " ===");
            for (Booking booking : bookingList) {
                if (booking.ongoing) {
                    booking.printBooking();
                    hasBooking = true;
                }
            }
            if (!hasBooking) {
                System.out.println("Il n'y a aucune réservation en cours");
            }
        } else {
            System.out.println("Il n'y a aucune réservation pour le moment");
        }
    }

    public void displayBookingsByGuest(Guest guest) {
        boolean hasBooking = false;
        System.out.println("=== Réservations du client " + guest.firstName + " " + guest.lastName + " ===");
        for (Booking booking : this.bookingList) {
            // Utilisation de la méthode .equals() surchargée de Guest
            if (booking.occupant.equals(guest)) {
                booking.printBooking();
                hasBooking = true;
            }

        }
            if (!hasBooking) {
                System.out.println("Ce client n'a pas encore fait de réservation");
            }
    }

    public void addBooking(Booking booking) {
        this.bookingList.add(booking);
    }

}
