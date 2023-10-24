package exos.variables;

import java.util.Scanner;

/**
 * Exercice S57 : Périmètre et aire d'un carré
 * 1. Saisir la longueur du côté du carré et la stocker dans une variable
 * 2. Calculer l'aire et le périmètre du carré
 */
public class ExoS57 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir la longueur du côté :");
        double cote = scanner.nextDouble();

        double perimetre = cote * 4;
        double aire = cote * cote;

        System.out.println("Le périmètre du carré est " + perimetre);
        System.out.printf("L'aire du carré est %.2f", aire);
    }
}
