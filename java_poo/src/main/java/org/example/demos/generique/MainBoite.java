package org.example.demos.generique;

import org.example.demos.heritage.Chat;

public class MainBoite {
    public static void main(String[] args) {
        // Boîte pour une chaîne de caractères
        Boite<String> boiteString = new Boite<>("Contenu de la boîte String");
        System.out.println(boiteString.getContenu());

        // Boîte pour un objet
        Chat monChat = new Chat("Poupette", 8, "tabi", 7);
        Boite<Chat> boiteChat = new Boite<>(monChat);
        System.out.println("Chat dans la boîte : " + boiteChat.getContenu());

        // Boîte pour un type primitif : il faut utiliser leur classe objet
        Boite<Double> boiteDouble = new Boite<>(12.25);
        System.out.println("Décimal de la boîte + 10 : " + (boiteDouble.getContenu() + 10));

    }
}
