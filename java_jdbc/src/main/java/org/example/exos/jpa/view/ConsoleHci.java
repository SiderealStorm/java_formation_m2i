package org.example.exos.jpa.view;

import org.example.exos.jpa.entity.Category;
import org.example.exos.jpa.entity.Task;
import org.example.exos.jpa.entity.User;
import org.example.exos.jpa.service.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleHci {

    private static Scanner scanner;
    private static Service service;

    public static void start() {
        // Il vaut mieux instancier les attributs dans la méthode
        scanner = new Scanner(System.in);
        service = new Service();

        int choice;
        System.out.println("*** Bienvenue dans ToDoList ***");

        // On fait en sorte qu'il y ait au moins un utilisateur dans la BDD
        // en demandant sa création au premier lancement du programme
        if (service.getAllUsers().isEmpty()) {
            System.out.println("Veuillez créer un utilisateur :");
            addUser();
        }

        do {
            displayMenu();
            choice = inputChoice();

            switch (choice) {
                case 0 -> System.out.println("Au revoir !");
                case 1 -> displayTasks(service.getAllTasks());
                case 2 -> displayInfo();
                case 3 -> addTask();
                case 4 -> markAsCompleted();
                case 5 -> deleteTask();
                case 6 -> addUser();
                case 7 -> displayUserTasks();
                case 8 -> deleteUser();
                case 9 -> displayCategoryTasks();
                case 10 -> addCategory();
                case 11 -> deleteCategory();
                default -> System.out.println("Veuillez entrer un nombre valide !");
            }
        } while (choice !=0);

        scanner.close();
        service.closeDAO();
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("=== Menu principal ===");
        System.out.println("1. Afficher toutes les tâches");
        System.out.println("2. Afficher les détails d'une tâche");
        System.out.println("3. Ajouter une tâche");
        System.out.println("4. Marquer une tâche comme terminée");
        System.out.println("5. Supprimer une tâche");
        System.out.println("6. Ajouter un utilisateur");
        System.out.println("7. Afficher les tâches d'un utilisateur");
        System.out.println("8. Supprimer un utilisateur et ses tâches associées");
        System.out.println("9. Afficher toutes les tâches d'une catégorie");
        System.out.println("10. Ajouter une catégorie");
        System.out.println("11. Supprimer une catégorie");
//        System.out.println("12. Mettre une tâche dans une catégorie");
//        System.out.println("13. Retirer une tâche d'une catégorie");
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

    private static void displayTasks(List<Task> taskList) {
        // La méthode isEmpty() renvoie true si size() > 0
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
        User user = chooseUser();
        System.out.print("Titre de la tâche : ");
        String title = scanner.nextLine();
        System.out.print("Description de la tâche : ");
        String description = scanner.nextLine();
        System.out.print("Date d'échéance (jj-mm-aaaa) : ");
        Date date = inputDate();
        System.out.print("Priorité : ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        if (service.saveTask(title, description, date, priority, user)) {
            System.out.println("Nouvelle tâche enregistrée");
        } else {
            System.out.println("Une erreur est survenue, la tâche n'a pas pû être sauvegardée");
        }

    }

    private static Task chooseTask() {
        System.out.println("Quelle tâche ?");
        displayTasks(service.getAllTasks());
        int choice = inputChoice();
        return service.getTask(choice);
    }

    private static void markAsCompleted() {
        Task task = chooseTask();
        if (service.markTaskAsCompleted(task)) {
            System.out.println("Tâche marquée comme terminée");
        } else {
            System.out.println("Une erreur est survenue, la tâche n'a pas pû être modifiée");
        }
    }

    private static void displayInfo() {
        Task task = chooseTask();
        if (task != null) {
            System.out.println(task);
            System.out.println("Utilisateur : " + task.getUser().getUserName());
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

    private static void addUser() {
        System.out.print("Nom de l'utilisateur : ");
        String userName = scanner.nextLine();
        if (service.saveUser(userName)) {
            System.out.println("Nouvel utilisateur enregistré");
        } else {
            System.out.println("Une erreur est survenue, l'utilisateur n'a pas pû être créé");
        }
    }

    private static void displayAllUsers() {
        List<User> userList = service.getAllUsers();
        if (!userList.isEmpty()) {
            for (User user : userList) {
                System.out.println(user);
            }
        } else {
            System.out.println("Il n'y a aucun utilisateur d'enregistré");
        }
    }

    private static User chooseUser() {
        System.out.println("Quel utilisateur ?");
        displayAllUsers();
        int id = inputChoice();
        return service.getUser(id);
    }

    private static void displayUserTasks() {
        User user = chooseUser();
        System.out.println(user);
        displayTasks(user.getTasks());
    }

    private static void deleteUser() {
        User user = chooseUser();
        if (user != null) {
            if (service.deleteUser(user.getId())) {
                System.out.println("L'utilisateur et ses tâches ont bien été supprimés");
            } else {
                System.out.println("Une erreur est survenue, l'utilisateur n'a pas pû être supprimé");
            }
        }
    }

    private static Category chooseCategory(List<Category> categories) {
        System.out.println("Quelle catégorie ?");
        displayCategories(categories);
        int id = inputChoice();
        return service.getCategory(id);
    }

    private static void displayCategories(List<Category> categoryList) {
        if (!categoryList.isEmpty()){
            for (Category category : categoryList) {
                System.out.println(category);
            }
        } else {
            System.out.println("Il n'y a aucune catégorie enregistrée");
        }
    }

    private static void displayCategoryTasks() {
        Category category = chooseCategory(service.getAllCategories());
        System.out.println(category);
        displayTasks(category.getTasks());
    }

    private static void addCategory() {
        System.out.print("Nom de la catégorie : ");
        String name = scanner.nextLine();
        if (service.saveCategory(name)) {
            System.out.println("Nouvelle catégorie enregistrée");
        } else {
            System.out.println("Une erreur est survenue, la catégorie n'a pas pû être créée");
        }
    }

    private static void deleteCategory() {
        Category category = chooseCategory(service.getAllCategories());
        if (service.deleteCategory(category.getId())) {
            System.out.println("La catégorie a bien été supprimée");
        } else {
            System.out.println("Une erreur est survenue, la catégorie n'a pas pû être supprimée");
        }
    }

    private static void putTaskInCategory() {
        Task task = chooseTask();
        Category category = chooseCategory(service.getAllCategories());
        if (category == null) {
            System.out.println("Veuillez créer une catégorie");
            addCategory();
            // TODO récupérer la catégorie !
        }
        if (service.addTaskToCategory(task, category)){
            System.out.println("La tâche a bien été ajoutée à la catégorie \"" + category.getName() + "\"");
        } else {
            System.out.println("Une erreur est survenue, la tâche n'a pas pû être ajoutée à la catégorie");
        }
    }

    private static void removeTaskFromCategory() {
        Task task = chooseTask();
        if (task.getCategories().isEmpty()) {
            System.out.println("Cette tâche n'appartient à aucune catégorie");
            return;
        }
        Category category = chooseCategory(task.getCategories());
        if (service.removeTaskFromCategory(task, category)) {
            System.out.println("La tâche a bien été retirée de la catégorie \"" + category.getName() + "\"");
        } else {
            System.out.println("Une erreur est survenue, la tâche n'a pas pû être retirée de la catégorie");
        }
    }
}
