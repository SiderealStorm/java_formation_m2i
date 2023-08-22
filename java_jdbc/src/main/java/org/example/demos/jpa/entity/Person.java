package org.example.demos.jpa.entity;

import javax.persistence.*;

// Annotation pour lier la classe à la BDD
@Entity
// Annotation optionnelle pour définir le nom de la table
@Table(name = "person")
public class Person {

    // Annotation pour la clé primaire
    @Id
    // Annotation pour spécifier la génération automatique pour une clé primaire ou unique :
    // GenerationType.TABLE : Utilisation d'une table de génération de clés
    // GenerationType.SEQUENCE : Utilisation de séquences = un compteur pour chaque table (Oracle, PostgreSQL, etc.)
    // GenerationType.IDENTITY : Génération par auto-incrémentation par JPA = un compteur pour TOUTES les tables (utilisé dans MySQL, PostgreSQL, etc.)
    // GenerationType.AUTO : Sélection automatique de la meilleure stratégie entre SEQUENCE et IDENTITY (par défaut)
    // GenerationType.NONE : Pas de génération automatique, valeurs fournies manuellement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Basic est automatique, donc inutile de le mettre
    // Annotation optionnelle pour définir le nom de la colonne
    @Column(name = "first_name")
    private String firstName;

    // Par défaut le nom de colonne sera identique au nom de l'attribut, TOUT en minuscule !
    private String lastName;

    // Annotation permettant de ne pas tenir compte du champ en BDD
    // L'attribut est donc défini pour l'objet, mais n'est pas mappé
    @Transient
    private int age;

    // Le constructeur vide est nécessaire pour le fonctionnement de l'entité
    public Person() {}

    // On peut toujours définir d'autres constructeurs
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
