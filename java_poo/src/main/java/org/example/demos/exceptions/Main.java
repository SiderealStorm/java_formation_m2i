package org.example.demos.exceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Compte cp = new Compte();
        Scanner clavier = new Scanner(System.in);

        System.out.print("Montant à verser : ");
        double mt1 = clavier.nextDouble();
        cp.verser(mt1);

        System.out.println("Solde actuel : " + cp.getSolde());

        System.out.print("Montant à retirer : ");
        double mt2 = clavier.nextDouble();

        // cp.retirer(mt2); // --> Le compilateur signale qu'il faut gérer une éventuelle exception
        try {
            cp.retirer(mt2);
        } catch (Exception e) {     // On récupère l'exception levée pour l'utiliser dans le bloc "catch"
            // On affiche le message de l'exception levée
            System.out.println(e.getMessage());
        }
        System.out.println("Solde final : " + cp.getSolde());
    }
}
