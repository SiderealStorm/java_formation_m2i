package org.example.exos.jpa.exo1.view;

import org.example.exos.jpa.exo1.entity.Task;
import org.example.exos.jpa.exo1.service.TaskService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleHci {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskService service = new TaskService();

    public static void start() {
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
        if (taskList.size() > 0) {
            for (Task task : taskList) {
                System.out.println(task);
            }
        } else {
            System.out.println("Il n'y a aucune tâche enregistrée");
        }
    }

    private static void addTask() {
        System.out.print("Tâche : ");
        String title = scanner.nextLine();
        service.saveTask(title);
    }

    private static Task chooseTask() {
        System.out.println("Quelle tâche ?");
        displayTasks();
        int choice = inputChoice();
        return service.getById(choice);
    }

    private static void markAsCompleted() {
        Task task = chooseTask();
        task.setCompleted(true);
        service.updateTask(task);
    }

    private static void deleteTask() {
        Task task = chooseTask();
        service.deleteTask(task.getId());
    }
}
