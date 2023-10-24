package exos.instructions;

import java.util.Scanner;

/**
Exercice S76 : Etat de l'eau
1. Définir une variable température
2. Affecter une valeur à la variable temperature
3. Selon la température, affiche l'état de l'eau :
SOLIDE : température inférieure à 0°C
LIQUIDE : température entre 0 et 100°C
GAZEUX : température supérieure à 100°C
 */
public class ExoS76 {
    public static void main(String[] args) {

        double temperature;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quelle est la température de l'eau (en Celcius) ?");
        temperature = scanner.nextDouble();

        if (temperature >= 0 && temperature <= 100) {
            System.out.println("L'eau est à l'état liquide");
        } else if (temperature < 0) {
            System.out.println("L'eau est à l'état solide");
        } else {
            System.out.println("L'eau est à l'état gazeux");
        }
        scanner.close();
    }
}
