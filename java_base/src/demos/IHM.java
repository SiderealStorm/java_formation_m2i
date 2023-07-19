package demos;

import java.util.Scanner;

public class IHM {
    public static void main(String[] args) {
        // Prints

        System.out.println("J'affiche une ligne dans la console");
        System.out.println("Raccourci (snippet) : sout");

        System.out.print("J'affiche le texte");
        System.out.print(" sans passer ");
        System.out.print("à la ligne");

        // Sauter une ligne
        System.out.println();

        // Chaîne formatés
        int age = 25;
        String nom = "John Doe";
        double taille = 1.72;

        System.out.printf("%s a %d ans et mesure %.2f mètres", nom, age, taille);
        System.out.println();
        System.out.println("Raccourci (snippet) : souf");

        // Caractères spéciaux
        System.out.println("saut\nde ligne");
        System.out.println("\ttabulation");
        System.out.println("Le backspace\befface un caractère");


        // Saisie utilisateur

        Scanner scanner = new Scanner(System.in);

        System.out.println("Demander une chaîne de caractères à l'utilisateur");
        String chaine = scanner.nextLine();
        System.out.println(chaine);

        System.out.println("Demander un entier");
        int entier = scanner.nextInt();
        System.out.println(entier);

        System.out.println("Demander un décimal");
        double decimal = scanner.nextDouble();
        System.out.println(decimal);

        System.out.println("Demander un booléen : l'utilisateur doit taper true ou false");
        boolean bool = scanner.nextBoolean();
        System.out.println(bool);

        System.out.println("Pour pouvoir réutiliser next ou nextLine, il faut vider la mémoire tampon !");
        scanner.nextLine();

        System.out.println("La mémoire est vide, on peut redemander une chaîne");
        chaine = scanner.nextLine();
        System.out.println(chaine);

        System.out.println("Next demande une chaîne mais n'enregistre que jusqu'au premier espace");
        chaine = scanner.next();
        System.out.println(chaine);

        System.out.println("Il faut aussi vider la mémoire tampon");
        scanner.nextLine();

        System.out.println("Demander un caractère requiert d'utiliser charAt(0) afin de ne garder que le permier caractère saisi");
        char caractere = scanner.next().charAt(0);
        System.out.println(caractere);

        // En bonne pratique, il faut fermer le scanner à la fin du programme.
        // Un scanner fermé ne peut plus être réutilisé !
        scanner.close();
    }
}
