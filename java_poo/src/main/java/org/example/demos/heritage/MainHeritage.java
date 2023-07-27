package org.example.demos.heritage;

public class MainHeritage {
    public static void main(String[] args) {

        Animal animal = new Animal("Titi", 2, "bleu");
        animal.crier();
        animal.manger();
        System.out.println("Cet animal est né en : " + animal.anneeNaissance());
        System.out.println(animal);
        System.out.println();

        Chat chat = new Chat("Mimi", 5, "roux", 9);
        chat.crier();
        chat.manger();
        System.out.println("Ce chat est né en " + chat.anneeNaissance());
        System.out.println(chat);
        System.out.println();

        Chien chien = new Chien("Toutou", 3, "sable", 55);
        chien.crier();
        chien.manger();
        System.out.println("Ce chien est né en " + chien.anneeNaissance());
        System.out.println(chien);

    }
}
