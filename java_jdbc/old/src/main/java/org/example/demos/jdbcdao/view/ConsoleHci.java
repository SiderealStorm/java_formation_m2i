package org.example.demos.jdbcdao.view;

import org.example.demos.jdbcdao.model.Person;
import org.example.demos.jdbcdao.service.PersonService;
import java.util.List;
import java.util.Scanner;

public class ConsoleHci {

    private static final Scanner scanner = new Scanner(System.in);
    private static PersonService personService = new PersonService();

    public static void start() {
        int choice;

        do {
            displayMenu();

            System.out.print("Votre choix : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 0 -> System.out.println("Au revoir !");
                case 1 -> displayAllPersons();
                case 2 -> addPerson();
                case 3 -> updatePerson();
                case 4 -> deletePerson();
                default -> System.out.println("Choix invalide !");
            }

        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("=== Menu principal ===");
        System.out.println("1. Voir toutes les personnes");
        System.out.println("2. Ajouter une personne");
        System.out.println("3. Modifier une personne");
        System.out.println("4. Effacer une personne");
        System.out.println("0. Quitter le programme");
    }

    public static void displayAllPersons() {
        List<Person> personsList = personService.getAllPersons();
        if (personsList != null) {
            System.out.println("=== Liste des personnes enregistrées ===");
            for (Person person : personsList) {
                System.out.println(person);
            }
        } else {
            System.out.println("Il n'y a aucune personne enregistrée pour le moment");
        }
    }

    public static Person inputPerson() {
        System.out.print("Nom  : ");
        String firstName = scanner.nextLine();
        System.out.print("Prenom : ");
        String lastName = scanner.nextLine();

        return new Person(firstName, lastName);
    }

    public static void addPerson() {
        Person person = inputPerson();
        personService.createPerson(person.getFirstName(), person.getLastName());
    }

    private static void updatePerson() {
        System.out.print("ID de la personne à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Person person = personService.getPerson(id);
        if (person == null) {
            System.out.println("La personne n'a pas été trouvée");
            return;
        }

        Person newPerson = inputPerson();
        newPerson.setId(person.getId());

        if(personService.updatePerson(newPerson)){
            System.out.println("Les modifications sont enregistrées");
        }else {
            System.out.println("Une erreur est survenue");
        }
    }

    private static void deletePerson() {
        System.out.print("ID de la personne à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if(personService.deletePerson(id)){
            System.out.println("La personne a été effacée");
        }else {
            System.out.println("Une erreur est survenue");
        }

    }

}
