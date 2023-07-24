package exos.instructions;

/*
Exercice S80 : Tables de multiplications
1. Créer un programme permettant d'afficher les tables de multiplications de 1 à 10
 */
public class ExoS80 {
    public static void main(String[] args) {
        System.out.println("\t=== Tables de multiplications ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println("--- Table de " + i + " ---");
            for (int j = 1 ; j <= 10; j++) {
                System.out.println(j + " x " + i + " = " + j*i);
            }
        }
    }
}
