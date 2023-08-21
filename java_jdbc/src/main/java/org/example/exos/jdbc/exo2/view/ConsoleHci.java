package org.example.exos.jdbc.exo2.view;

import org.example.exos.jdbc.exo2.model.BankAccount;
import org.example.exos.jdbc.exo2.model.Customer;
import org.example.exos.jdbc.exo2.model.Transaction;
import org.example.exos.jdbc.exo2.model.TransactionType;
import org.example.exos.jdbc.exo2.service.BankService;

import java.util.List;
import java.util.Scanner;

public class ConsoleHci {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BankService service = new BankService();

    public static void start() {
        int choice;
        System.out.println("***** Bienvenue *****");
        do {
            displayMenu();
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 0 -> System.out.println("Merci d'avoir utilisé nos services.");
                case 1 -> addCustomer();
                case 2 -> createAccount();
                case 3 -> creditAccount();
                case 4 -> debitAccount();
                case 5 -> displayAccountDetails();
                default -> System.out.println("Veuillez saisir un nombre valide");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Ouvrir un compte");
        System.out.println("3. Faire un dépôt");
        System.out.println("4. Faire un retrait");
        System.out.println("5. Afficher les détails d'un compte");
        System.out.println("0. Quitter le programme");
    }

    private static void displayCustomers() {
        List<Customer> customers = service.getAllCustomers();
        if (customers != null) {
            if (customers.size() > 0) {
                for (Customer customer : customers) {
                    System.out.println(customer);
                }
            } else {
                System.out.println("Il n'y a pas encore de client");
            }
        }
    }

    private static void displayAccounts() {
        List<BankAccount> accounts = service.getAllAccounts();
        if (accounts != null) {
            if (accounts.size() > 0) {
                for (BankAccount account : accounts) {
                    System.out.println(account);
                }
            } else {
                System.out.println("Il n'y a pas encore de comptes");
            }
        }
    }

    private static void addCustomer() {
        System.out.println("=== Nouveau client ===");
        System.out.print("Nom : ");
        String lastName = scanner.nextLine();
        System.out.print("Prénom : ");
        String firstName = scanner.nextLine();
        System.out.print("Téléphone : ");
        String phone = scanner.nextLine();

        if (service.addCustomer(firstName, lastName, phone)) {
            System.out.println("Le client a bien été ajouté");
        } else {
            System.out.println("Une erreur est survenue");
        }
    }

    private static Customer chooseCustomer() {
        System.out.println("Pour quel client ?");
        displayCustomers();
        System.out.print("Votre choix : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        return service.getCustomer(id);
    }

    private static void createAccount() {
        System.out.println("=== Ouvrir un compte ===");

        Customer customer = chooseCustomer();

        if (customer != null) {
            if (service.createAccount(customer.getId())) {
                System.out.println("Le compte de " + customer.getFirstName() + " " + customer.getLastName() + " a bien été créé");
            }
        } else {
            System.out.println("Client non trouvé");
        }
    }

    private static BankAccount chooseAccount() {
        System.out.println("Pour quel compte ?");
        displayAccounts();
        System.out.print("Votre choix : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        return service.getAccount(id);
    }

    private static void creditAccount() {
        double amount;
        System.out.println("=== Créditer un compte ===");
        BankAccount account = chooseAccount();
        if (account != null) {
            do {
                System.out.print("Montant à créditer : ");
                amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Veuillez entrer un nombre positif !");
                }
            } while (amount <= 0);
            if (service.makeTransaction(account.getId(), amount, TransactionType.DEPOSIT)) {
                System.out.println("Le compte n°" + account.getId() + " a bien été crédité de " + amount + " €");
            }
        } else {
            System.out.println("Compte non trouvé");
        }
    }

    private static void debitAccount() {
        double amount;
        System.out.println("=== Débiter un compte ===");
        BankAccount account = chooseAccount();
        if (account != null) {
            do {
                System.out.print("Montant à débiter : ");
                amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Veuillez entrer un nombre positif !");
                }
            } while (amount <= 0);
            if (!service.checkWithdrawal(account, amount)) {
                System.out.println("Il n'y a pas assez d'argent sur le compte");
            } else {
                if (service.makeTransaction(account.getId(), amount, TransactionType.WITHDRAWAL)) {
                    System.out.println("Le compte n°" + account.getId() + " a bien été débité de " + amount + " €");
                }
            }
        } else {
            System.out.println("Compte non trouvé");
        }
    }

    private static void displayAccountDetails() {
        BankAccount account = chooseAccount();
        if (account != null) {
            System.out.println();
            account.setTransactions(service.getTransactions(account.getId()));
            Customer customer = service.getCustomer(account.getCustomerId());
            System.out.println(account);
            System.out.println(customer);
            System.out.println("Historique des transactions :");
            for (Transaction transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Compte non trouvé");
        }
    }

}
