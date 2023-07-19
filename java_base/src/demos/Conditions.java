package demos;

public class Conditions {
    public static void main(String[] args) {

        double note = 12.5;

        // Si

        // Oneline :
        if (note < 20) System.out.println("Note valide");

        // Plusieurs instructions :
        if (note > 0) {
            System.out.println("La note est valide");
            System.out.println("On peut écrire plusieurs instructions");
        }

        // Si-sinon
        if (note < 10) {
            System.out.println("Vous n'avez pas la moyenne");
        } else {
            System.out.println("Vous avez la moyenne !");
        }

        // Enchaînements :
        if (note >= 16) {
            System.out.println("Très bien");
        } else if (note >= 14) {
            System.out.println("Bien");
        } else if (note >= 12) {
            System.out.println("Bien");
        } else {
            System.out.println("Bof...");
        }

        System.out.println();

        // Switch case

        System.out.println("1- Dire bonjour");
        System.out.println("2- Dire au revoir");
        System.out.println("3- Dire bonne nuit");

        int choix = 2;

        // Syntaxe de base
        switch (choix) {
            case 1:
                System.out.println("Bonjour !");
                break;
            case 2:
                System.out.println("Au revoir !");
                break;
            case 3:
                System.out.println("Bonne nuit...");
            default:
                System.out.println("Mauvais choix...");
                break;
        }

        // Syntaxe oneline (plus récente)
        switch (choix) {
            case 1 -> System.out.println("Bonjour !");
            case 2 -> System.out.println("Au revoir !");
            case 3 -> System.out.println("Bonne nuit...");
            default -> System.out.println("Mauvais choix...");
        }

    }
}
