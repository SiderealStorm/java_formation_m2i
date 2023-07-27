package org.example.demos.abstraction;

// Pour que la classe soit abstraite, on ajoute le mot-clé "abstract"
public abstract class Animal {

    protected String nom;
    protected int age;
    protected String couleur;

    // On peut définir un constructeur, même si la classe ne peut pas être instanciée ; il servira aux classes enfant
    public Animal(String nom, int age, String couleur) {
        this.nom = nom;
        this.age = age;
        this.couleur = couleur;
    }


    // On peut définir des méthodes (complètes), qui seront utilisables telles quelles
    public void manger() {
        System.out.println(nom + " mange");
    }

    // On peut aussi définir des méthodes abstraites : ce sont des  signatures de méthodes, sans corps ; elles servent à forcer l'implémentation dans les classes enfant
    public abstract void crier();



}
