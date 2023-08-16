package org.example.exos.tp.hci;

import org.example.exos.tp.classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleHCI {

    private static final Scanner scanner = new Scanner(System.in);

    private static Hotel hotel;

    public static void menu() {
        int choice;

        ConsoleHCI.createHotel();

        do {
            System.out.println();
            System.out.println("=== Menu principal ===");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Voir la liste des clients");
            System.out.println("3. Voir les réservations d'un client");
            System.out.println("4. Faire une réservation");
            System.out.println("5. Annuler une réservation");
            System.out.println("6. Afficher toutes les réservations");
            System.out.println("7. Afficher toutes les chambres");
            System.out.println("0. Quitter");

            choice = ConsoleHCI.inputChoice();

            switch (choice) {
                // TODO refactoriser pour avoir toutes les méthodes dans ConsoleHCI et plus dans Hotel
                // TODO idem pour les autres classes : vérifier et déplacer tous les sout ici
                case 0 -> System.out.println("Au revoir");
                case 1 -> inputGuest();
                case 2 -> hotel.displayGuests();
                case 3 -> displayBookingsByGuest();
                case 4 -> makeBooking();
                case 5 -> cancelBooking();
                case 6 -> hotel.displayAllBookings();
                case 7 -> hotel.displayAllRooms();
                default -> System.out.println("Erreur de saisie, recommencez");
            }
            // TODO Faire en sorte qu'il faille faire entrée pour réafficher le menu

        } while (choice !=0);

        scanner.close();

    }

    private static int inputChoice() {
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

    private static void createHotel() {
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
        // Il faut vider le cache avant de réutiliser .nextLine()
        scanner.nextLine();

        hotel = new Hotel(name, numberOfRooms, bedPrice);
        System.out.println("Hôtel " + hotel.getName() + " créé");
    }

    private static void inputGuest() {
        String firstName;
        String lastName;
        String phone;
        Title title = Title.MX;
        int choice;

        System.out.println();
        System.out.println("=== Nouveau client ===");

        do {
            System.out.println("Civilité :");
            System.out.println("\t1 : Madame - 2 : Mademoiselle - 3 : Monsieur - 4 : Autre");
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

    private static Guest chooseGuest() {
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

    private static void displayBookingsByGuest() {
        Guest guest = chooseGuest();
        if (guest != null) {
            hotel.displayBookingsByGuest(guest);
        }
    }

    private static Room chooseRoom() {
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

            for (Room room : rooms) {
                if (room.getRoomNumber() == id) {
                    return room;
                }
            }

            System.out.println("Cette chambre n'existe pas.");
            return null;
        }
        System.out.println("Il n'y a aucune chambre libre !");
        return null;
    }

    private static Booking chooseBooking() {
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

    private static void makeBooking() {
        ArrayList<Room> roomsList = new ArrayList<>();
        char choice;
        Guest guest = chooseGuest();
        if (guest != null) {
            do {
                if (hotel.getFreeRooms().size() == 0) {
                    System.out.println("Il n'y a plus aucune chambre disponible !");
                    break;
                }

                Room room = chooseRoom();
                if (room != null) {
                    roomsList.add(room);
                    room.setOccupied(true);
                }

                // TODO simplifier en remplaçant par une autre condition en int : si choix == 0
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

    private static void cancelBooking() {
        Booking booking = chooseBooking();
        if (booking != null) {
            booking.cancelBooking();
            System.out.println("Réservation n°" + booking.getId() + " annulée");
        }
    }

}
