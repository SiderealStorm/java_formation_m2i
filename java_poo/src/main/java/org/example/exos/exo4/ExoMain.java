package org.example.exos.exo4;

/*
Exercice S25 : WaterTank
1. Créer une classe WaterTank
2. Ajouter les attributs suivants: poids à vide, capacité maximale, niveau de remplissage
3. Créer une méthode remplir() qui ajoutera une volume d'eau à la citerne
4. Créer une méthode vider() qui enlèvera un volume d'eau à la citerne
5. Créer un attribut de classe qui contiendra la totalité des volumes d'eau de la citerne
6. /!\ le volume d'eau d'une citerne ne peut pas être négatif ou dépasser le volume maximum
 */
public class ExoMain {
    public static void main(String[] args) {

        WaterTank wt1 = new WaterTank(20, 200);

        System.out.println("Ajout de 160 L dans la citerne 1 :");
        wt1.fill(160);
        System.out.println(wt1);
        System.out.println("Ajout de 160 L dans la citerne 1 :");
        wt1.fill(160);
        System.out.println(wt1);
        System.out.println("Volume total en stock : " + WaterTank.totalVolume);

        WaterTank wt2 = new WaterTank(15, 150);

        System.out.println("Ajout de 100 L dans la citerne 2 :");
        wt2.fill(100);
        System.out.println(wt2);
        System.out.println("Volume total en stock : " + WaterTank.totalVolume);

        System.out.println("Retrait de 60 L de la citerne 2 :");
        wt2.empty(60);
        System.out.println(wt2);
        System.out.println("Volume total en stock : " + WaterTank.totalVolume);

        System.out.println("Retrait de 60 L de la citerne 2 :");
        wt2.empty(60);
        System.out.println(wt2);
        System.out.println("Volume total en stock : " + WaterTank.totalVolume);
    }
}
