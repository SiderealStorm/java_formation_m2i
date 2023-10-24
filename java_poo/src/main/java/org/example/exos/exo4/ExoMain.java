package org.example.exos.exo4;

/**
 * Exercice S25 : WaterTank
 * 1. Créer une classe WaterTank
 * 2. Ajouter les attributs suivants: poids à vide, capacité maximale, niveau de remplissage
 * 3. Créer une méthode remplir() qui ajoutera une volume d'eau à la citerne
 * 4. Créer une méthode vider() qui enlèvera un volume d'eau à la citerne
 * 5. Créer un attribut de classe qui contiendra la totalité des volumes d'eau de la citerne
 * /!\ le volume d'eau d'une citerne ne peut pas être négatif ou dépasser le volume maximum
 */
public class ExoMain {
    public static void main(String[] args) {

        WaterTank tank1 = new WaterTank(20, 200);

        System.out.println("Ajout de 160 L dans la citerne 1 :");
        tank1.fill(160);
        System.out.println(tank1);
        System.out.println("Ajout de 160 L dans la citerne 1 :");
        tank1.fill(160);
        System.out.println(tank1);
        System.out.println("Volume total en stock : " + WaterTank.getTotalVolume() + " L");
        System.out.println();

        WaterTank tank2 = new WaterTank(15, 150);

        System.out.println("Ajout de 100 L dans la citerne 2 :");
        tank2.fill(100);
        System.out.println(tank2);
        System.out.println("Volume total en stock : " + WaterTank.getTotalVolume() + " L");
        System.out.println();

        System.out.println("Retrait de 60 L de la citerne 2 :");
        tank2.empty(60);
        System.out.println(tank2);
        System.out.println("Volume total en stock : " + WaterTank.getTotalVolume() + " L");
        System.out.println();

        System.out.println("Retrait de 60 L de la citerne 2 :");
        tank2.empty(60);
        System.out.println(tank2);
        System.out.println("Volume total en stock : " + WaterTank.getTotalVolume() + " L");
    }
}
