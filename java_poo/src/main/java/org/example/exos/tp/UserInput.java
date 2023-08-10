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
        String name;
        int numberOfRooms;
        double bedPrice;

        System.out.println();
        System.out.println("=== Création de l'hôtel ===");

        System.out.print("Quel est le nom de votre hôtel ? ");
        name = scanner.nextLine();

        System.out.print("Combien y a-t-il de chambres ? ");
        numberOfRooms = scanner.nextInt();

        System.out.print("Quel prix pour un couchage ? ");
        bedPrice = scanner.nextDouble();
        scanner.nextLine();

        return new Hotel(name, numberOfRooms, bedPrice);
    }

    public static void inputGuest(Hotel hotel) {
        String firstName;
        String lastName;
        String phone;
        Title title = Title.MX;
        int choice;

        System.out.println();
        System.out.println("=== Nouveau client ===");

        do {
            System.out.println("Civilité :");
            System.out.println("\t1 : Madame - 2 : Mademoiselle - 3 : Monsieur - 4 : Neutre");
            choice = inputChoice();
            switch (choice) {
                case 1 -> title = Title.MRS;
                case 2 -> title = Title.MS;
                case 3 -> title = Title.MR;
                case 4 -> title = Title.MX;
                default -> System.out.println("Erreur de saisie, recommencez !");
            }
        } while (choice < 1 || choice > Title.values().length);

        System.out.print("Prénom : ");
        firstName = scanner.nextLine();

        System.out.print("Nom de famille : ");
        lastName = scanner.nextLine();

        System.out.print("Numéro de téléphone : ");
        phone = scanner.nextLine();

        hotel.addGuest(new Guest(title, firstName, lastName, phone));
    }

    public static Guest chooseGuest(Hotel hotel) {
        System.out.println();
        System.out.println("Choisissez un client :");
        hotel.displayGuests();
        if (hotel.getGuestsList().size() > 0) {
            int id = inputChoice();

            for (Guest guest : hotel.getGuestsList()) {
                if (guest.getId() == id) {
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
        ArrayList<Room> rooms = hotel.getFreeRooms();

        if (rooms.size() > 0) {
            System.out.println();
            System.out.println("Choisissez un numéro de chambre :");
            System.out.println("=== Chambres libres de l'hôtel " + hotel.getName() + " ===");
            for (Room room : rooms) {
                System.out.println(room);
            }
            id = inputChoice();

            for (Room room : hotel.getRoomsList()) {
                if (room.getRoomNumber() == id) {
                    return room;
                }
            }

            System.out.println("Cette chambre n'existe pas.");
        }
        System.out.println("Il n'y a aucune chambre libre !");
        return null;
    }

    public static Booking chooseBooking(Hotel hotel) {
        int id;
        System.out.println();
        System.out.println("Choisissez une réservation :");
        hotel.displayOngoingBookings();
        if (hotel.getBookingList().size() > 0) {
            id = inputChoice();

            for (Booking booking : hotel.getBookingList()) {
                if (booking.getId() == id) {
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
                if (hotel.getFreeRooms().size() == 0) {
                    System.out.println("Il n'y a plus aucune chambre disponible !");
                    break;
                }

                Room room = chooseRoom(hotel);
                if (room != null) {
                    roomsList.add(room);
                    room.setOccupied(true);
                }

                System.out.print("Tapez 'y' pour ajouter une autre chambre : ");
                choice = scanner.next().toLowerCase().charAt(0);
                scanner.nextLine();


            } while (choice == 'y');

            if (roomsList.size() > 0) {
                hotel.addBooking(new Booking(roomsList, guest));
                System.out.println("Réservation enregistrée");
            }
        }
    }

    public static void cancelBooking(Hotel hotel) {
        Booking booking = chooseBooking(hotel);
        if (booking != null) {
            booking.cancelBooking();
            System.out.println("Réservation n°" + booking.getId() + " annulée");
        }
    }

}
