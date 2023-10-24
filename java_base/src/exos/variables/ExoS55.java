package exos.variables;

import java.util.Scanner;

/**
 * Exercice S55 : volume d'un cône
 * Créer un programme qui permet de calculer le volume d'un cône
 * La formule est la suivante : 1/3 × π × r² × h
 */
public class ExoS55 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double rayon, hauteur, volume;

        System.out.println("Entrez le rayon du cercle (en cm) :");
        rayon = scanner.nextDouble();

        System.out.println("Entrez la hauteur du cône (en cm) :");
        hauteur = scanner.nextDouble();

        // On ne peut pas écrire 1/3 en début de formule car le résultat est considéré comme un entier, donc il vaut 0
        // On peut éviter ce problème en ajoutant un point : 1./3.
        volume = (Math.PI * Math.pow(rayon, 2) * hauteur) / 3;
        System.out.printf("Le volume du cône est de %.2f cm3", volume);

        System.out.println();
        System.out.println();

        // On peut aussi arrondir avec Math
        System.out.println("Entier inférieur avec Floor : " + Math.floor(volume));
        System.out.println("Entier supérieur avec Ceil : " + Math.ceil(volume));
        System.out.println("Entier le plus proche avec Round : " + Math.round(volume));

        // Pour obtenir 2 chiffre après la virgule :
        System.out.println("Arrondi à deux chiffres avec Round : " + Math.round(volume * 100)/100.);

        scanner.close();
    }
}
