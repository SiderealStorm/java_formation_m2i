package org.example.demos.hibernate;

import org.example.demos.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        // Création d'un registre pour charger la configuration à partir du fichier de configuration
        // Pour instancier le registre, on utilise le builder de la classe
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        // Création de la session
        Session session = sessionFactory.openSession();
        // Dès l'ouverture de la session, hibernate agit sur la BDD
        // L'action effectuée dépend de la propriété hibernate.hbm2ddl.auto du fichier de configuration

        // Ajout d'une personne :

        // Comme pour JPA, on passe par une transaction
        session.getTransaction().begin();

        // Création de l'entité
        Person person = new Person();
        person.setName("Lbn");
        person.setFirstName("Storm");

        // Enregistrement de l'entité
        session.save(person);
        // L'objet Java est mis à jour, on peut récupérer l'ID de la personne
        System.out.println("ID de la personne enregistrée : " + person.getId());

        // Commit de la transaction = enregistrement définitif
        session.getTransaction().commit();


        // Récupération d'une personne et modification :

        session.getTransaction().begin();

        Person person1 = session.load(Person.class, 1);
        System.out.println(person1.getFirstName());

        // Attention : si on souhaite modifier ou supprimer une occurence en BDD,
        // il faut être dans la même transaction que lors de sa réscupération
        person1.setAge(29);
        session.update(person1);

        session.getTransaction().commit();


        // Suppression d'une personne :

        session.getTransaction().begin();

        Person person2 = session.load(Person.class, 1);
        System.out.println(person2);

        session.delete(person2);

        session.getTransaction().commit();

        // Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();
    }
}
