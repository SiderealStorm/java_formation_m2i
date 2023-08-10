package org.example.exos.tp;

/*
TP : hôtel
Créer une classe Client possédant : un identifiant, un nom, un prénom et un numéro de téléphone
Créer une classe Chambre ayant : un numéro, un statut, un nombre de lits et un tarif.
Créer une classe Réservation possédant : un identifiant, un statut (énumérable ?), une liste de chambres et un client
Créer une classe Hotel comportant : une liste de clients, une liste de chambres et une liste de réservations
Créer une IHM pour tester l'application
 */
public class AppMain {
    public static void main(String[] args) {

        // Program
        int choice;

        Hotel hotel = UserInput.createHotel();

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

            choice = UserInput.inputChoice();

            switch (choice) {
                case 0 -> System.out.println("Au revoir");
                case 1 -> UserInput.inputGuest(hotel);
                case 2 -> hotel.displayGuests();
                case 3 -> UserInput.displayBookingsByGuest(hotel);
                case 4 -> UserInput.makeBooking(hotel);
                case 5 -> UserInput.cancelBooking(hotel);
                case 6 -> hotel.displayAllBookings();
                case 7 -> hotel.displayAllRooms();
                default -> System.out.println("Erreur de saisie, recommencez");
            }

        } while (choice !=0);

    }
}
