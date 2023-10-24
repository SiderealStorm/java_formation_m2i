package exos.instructions;

import java.util.Scanner;

/**
Exercice S77 : Candidature
1. Ecrire un programme qui permet de vérifier si un profil est valable pour une candidature
2. Le profil contient trois critères :
    age : supérieur à 30 ans
    salaire demandé : maximum 40 000€
    années d'expériences : minimum 5 ans
3. Afficher un message pour chaque condition non respectée
 */
public class ExoS77 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int age, salaire, exp;
        boolean estEmbauchable = true;

        System.out.println("Entrez votre âge :");
        age = scanner.nextInt();
        System.out.println("Entrez votre salaire annuel souhaité :");
        salaire = scanner.nextInt();
        System.out.println("Entrez votre nombre d'années d'expérience :");
        exp = scanner.nextInt();

        if (age <= 30 ) {
            System.out.println("Vous êtes trop jeune");
            estEmbauchable = false;
        }
        if (salaire > 40000) {
            System.out.println("Vos prétentions salariales sont trop élevées");
            estEmbauchable = false;
        }
        if (exp < 5) {
            System.out.println("Vous manquez d'expérience");
            estEmbauchable = false;
        }

        if (estEmbauchable) {
            System.out.println("Candidature acceptée");
        }

        scanner.close();
    }
}
