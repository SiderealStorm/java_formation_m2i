package org.example.exos.tp.classes;

import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Guest> guestsList;
    private ArrayList<Room> roomsList;
    private ArrayList<Booking> bookingList;

    public Hotel(String name, int numberOfRooms, double bedPrice) {
        this.name = name;
        this.guestsList = new ArrayList<>();
        this.roomsList = new ArrayList<>();
        for (int i = 1 ; i <= numberOfRooms ; i++) {
            this.roomsList.add(new Room(i, bedPrice));
        }
        this.bookingList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Guest> getGuestsList() {
        return guestsList;
    }

    public ArrayList<Room> getRoomsList() {
        return roomsList;
    }

    public ArrayList<Booking> getBookingList() {
        return bookingList;
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

    public void displayAllRooms() {
        System.out.println("=== Chambres de l'hôtel " + name + " ===");
        for (Room room : roomsList) {
            System.out.println(room);
        }
    }

    public ArrayList<Room> getFreeRooms() {
        ArrayList<Room> freeRooms = new ArrayList<>();
        for (Room room : roomsList) {
            if (!room.isOccupied()) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public void displayAllBookings() {
        if (bookingList.size() > 0) {
            System.out.println("=== Réservations de l'hôtel " + name + " ===");
            for (Booking booking : bookingList) {
                System.out.println(booking);;
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
                if (booking.isOngoing()) {
                    System.out.println(booking);
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
        System.out.println("=== Réservations de " + guest.getTitle().getValue() + " " + guest.getFirstName() + " " + guest.getLastName() + " ===");
        for (Booking booking : this.bookingList) {
            // Utilisation de la méthode .equals() surchargée de Guest
            if (booking.getGuest().equals(guest)) {
                System.out.println(booking);
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
