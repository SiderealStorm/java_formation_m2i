package org.example.demos.abstraction;

public class Chat extends Animal {

    private int nbVies;

    public Chat(String nom, int age, String couleur, int nbVies) {
        super(nom, age, couleur);
        this.nbVies = nbVies;
    }

    @Override
    public void crier() {
        System.out.println(nom + " : 'Miaou !'");
    }
}
