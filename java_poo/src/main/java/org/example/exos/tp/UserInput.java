package org.example.exos.tp;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputChoice() {
        System.out.println();
        System.out.print("Votre choix : ");
        String input = scanner.nextLine();
        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Veuillez saisir un nombre !");
            choice = -1;
        }
        return choice;
    }

    public static Hotel createHotel() {
        System.out.println();
        System.out.println("=== Création de l'hôtel ===");
        System.out.print("Quel est le nom de votre hôtel ? ");
        // TODO demander le nombre de chambres ?
        return new Hotel(scanner.nextLine());
    }

    public static void inputGuest(Hotel hotel) {
        String firstName;
        String lastName;
        String phone;

        System.out.println();
        System.out.println("=== Nouveau client ===");
        System.out.print("Prénom : ");
        firstName = scanner.nextLine();
        System.out.print("Nom de famille : ");
        lastName = scanner.nextLine();
        System.out.print("Numéro de téléphone : ");
        phone = scanner.nextLine();

        hotel.addGuest(new Guest(firstName, lastName, phone));
    }

    public static Guest chooseGuest(Hotel hotel) {
        System.out.println();
        System.out.println("Choisissez un client :");
        hotel.displayGuests();
        if (hotel.guestsList.size() > 0) {
            int id = inputChoice();

            for (Guest guest : hotel.guestsList) {
                if (guest.id == id) {
                    return guest;
                }
            }

            System.out.println("Ce client n'existe pas.");
        }
        System.out.println("Retour au menu");
        return null;
    }

    public static void displayBookingsByGuest(Hotel hotel) {
        Guest guest = chooseGuest(hotel);
        if (guest != null) {
            hotel.displayBookingsByGuest(guest);
        }
    }

    public static Room chooseRoom(Hotel hotel) {
        int id;
        System.out.println();
        System.out.println("Choisissez un numéro de chambre :");
        hotel.displayRooms();
        id = inputChoice();

        for (Room room : hotel.roomsList) {
            if (room.roomNumber == id) {
                return room;
            }
        }

        System.out.println("Cette chambre n'existe pas.");
        return null;
    }

    public static Booking chooseBooking(Hotel hotel) {
        int id;
        System.out.println();
        System.out.println("Choisissez une réservation :");
        hotel.displayOngoingBookings();
        if (hotel.bookingList.size() > 0) {
            id = inputChoice();

            for (Booking booking : hotel.bookingList) {
                if (booking.id == id) {
                    return booking;
                }
            }

            System.out.println("Cette réservation n'existe pas.");
        }

        return null;
    }

    public static void makeBooking(Hotel hotel) {
        ArrayList<Room> roomsList = new ArrayList<>();
        char choice;
        Guest guest = chooseGuest(hotel);
        if (guest != null) {
            do {
                Room room = chooseRoom(hotel);
                if (room != null) {
                    roomsList.add(room);
                    room.occupied = true;
                }
                System.out.print("Tapez 'y' pour ajouter une autre chambre : ");
                choice = scanner.next().toLowerCase().charAt(0);
                scanner.nextLine();
            } while (choice == 'y');
            hotel.addBooking(new Booking(roomsList, guest));
            System.out.println("Réservation enregistrée");
        }
    }

    public static void cancelBooking(Hotel hotel) {
        Booking booking = chooseBooking(hotel);
        if (booking != null) {
            booking.cancelBooking();
            System.out.println("Réservation n°" + booking.id + " annulée");
        }
    }

}
