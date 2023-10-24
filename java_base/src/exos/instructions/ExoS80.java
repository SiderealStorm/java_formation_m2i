package exos.instructions;

/**
 * Exercice S80 : Tables de multiplications
 * Créer un programme permettant d'afficher les tables de multiplications de 1 à 10
 */
public class ExoS80 {
    public static void main(String[] args) {
        System.out.println("=== Tables de multiplications ===");
        for (int table = 1; table <= 10; table++) {
            System.out.println("--- Table de " + table + " ---");
            for (int multiple = 1 ; multiple <= 10; multiple++) {
                System.out.println("\t" + multiple + " x " + table + " = " + multiple * table);
            }
        }
    }
}
