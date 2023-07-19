package exos.Variables;

import java.util.Scanner;

/*
Exercice S55 : volume d'un cône
1. Créer un programme qui permet de calculer le volume d'un cône
2. La formule est la suivante : 1/3 × π × r² × h
 */
public class ExoS55 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le rayon du cercle (en cm) :");
        double rayon = scanner.nextDouble();

        System.out.println("Entrez la hauteur du cône (en cm) :");
        double hauteur = scanner.nextDouble();

        double volume = (Math.PI * Math.pow(rayon, 2) * hauteur) / 3;
        System.out.printf("Le volume du cône est de %.2f cm3", volume);

        scanner.close();
    }
}
