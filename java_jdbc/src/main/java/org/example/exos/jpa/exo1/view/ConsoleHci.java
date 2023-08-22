package org.example.exos.jpa.exo1.view;

import org.example.exos.jpa.exo1.entity.Task;
import org.example.exos.jpa.exo1.service.TaskService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleHci {

    private static Scanner scanner;
    private static TaskService service;

    public static void start() {
        // Il vaut mieux instancier les attributs dans la méthode
        scanner = new Scanner(System.in);
        service = new TaskService();

        int choice;
        System.out.println("*** Bienvenue dans ToDoList ***");

        do {
            displayMenu();
            choice = inputChoice();

            switch (choice) {
                case 0 -> System.out.println("Au revoir !");
                case 1 -> displayTasks();
                case 2 -> addTask();
                case 3 -> markAsCompleted();
                case 4 -> deleteTask();
                case 5 -> displayInfo();
                default -> System.out.println("Veuillez entrer un nombre valide !");
            }
        } while (choice !=0);
        scanner.close();
        service.closeDAO();
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("=== Menu principal ===");
        System.out.println("1. Afficher ma liste de tâches");
        System.out.println("2. Ajouter une tâche à ma liste");
        System.out.println("3. Marquer une tâche comme terminée");
        System.out.println("4. Supprimer une tâche");
        System.out.println("5. Afficher les détails d'une tâche");
        System.out.println("0. Quitter");
    }

    private static int inputChoice() {
        int choice;
        do {
            try {
                System.out.print("Votre choix : ");
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erreur : vous devez saisir un nombre entier !");
                choice = -1;
            }
            scanner.nextLine();
        } while (choice == -1);
        return choice;
    }

    private static void displayTasks() {
        List<Task> taskList = service.getAllTasks();
        // La méthode isEmpty renvoie true si size() > 0
        if (!taskList.isEmpty()) {
            for (Task task : taskList) {
                System.out.println(task);
            }
        } else {
            System.out.println("Il n'y a aucune tâche enregistrée");
        }
    }

    private static Date inputDate() {
        String dateString;
        Date date = null;
        do {
            dateString = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                date = simpleDateFormat.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Erreur de saisie de la date !");
            }
        } while (date == null);
        return date;
    }

    private static void addTask() {
        System.out.print("Titre de la tâche : ");
        String title = scanner.nextLine();
        System.out.print("Description de la tâche : ");
        String description = scanner.nextLine();
        System.out.print("Date d'échéance (jj-mm-aaaa) : ");
        Date date = inputDate();
        System.out.print("Priorité : ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        if (service.saveTask(title, description, date, priority)) {
            System.out.println("Nouvelle tâche enregistrée");
        } else {
            System.out.println("Une erreur est survenue, la tâche n'a pas pû être sauvegardée");
        }

    }

    /*
    TODO Amélioration :
    modifier pour que cette méthode n'utilise plus le service
    et que la task soit récupérée dans un service
     */
    private static Task chooseTask() {
        System.out.println("Quelle tâche ?");
        displayTasks();
        int choice = inputChoice();
        return service.getById(choice);
    }

    private static void markAsCompleted() {
        Task task = chooseTask();
        task.setCompleted(true);
        if (service.updateTask(task)) {
            System.out.println("Tâche marquée comme terminée");
        } else {
            System.out.println("Une erreur est survenue, la tâche n'a pas pû être modifiée");
        }
    }

    private static void displayInfo() {
        Task task = chooseTask();
        if (task != null) {
            System.out.println(task);
            System.out.println(task.getInfo());
        } else {
            System.out.println("Tâche non trouvée");
        }
    }

    private static void deleteTask() {
        Task task = chooseTask();
        if (service.deleteTask(task.getId())) {
            System.out.println("Tâche supprimée");
        } else {
            System.out.println("Une erreur est survenue, la tâche n'a pas pû être supprimée");
        }
    }
}
