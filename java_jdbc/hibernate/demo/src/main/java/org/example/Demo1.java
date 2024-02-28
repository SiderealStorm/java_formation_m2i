package org.example;

import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Demo1 {
    public static void main(String[] args) {
        // Création d'un registre pour charger la configuration à partir du fichier de configuration
        // Pour instancier le registre, on utilise le builder de la classe
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        // Création de la session
        Session session = sessionFactory.openSession();
        // Dès l'ouverture de la session, hibernate agit sur la BDD
        // L'action effectuée dépend de la propriété hibernate.hbm2ddl.auto du fichier de configuration

        // Ajout de personnes :

        // Comme pour JPA, on passe par une transaction
        session.getTransaction().begin();

        // Création des entités
        Person person1 = new Person();
        person1.setLastName("Lbn");
        person1.setFirstName("Storm");
        person1.setAge(30);

        Person person2 = new Person();
        person2.setLastName("Durand");
        person2.setFirstName("Michèle");
        person2.setAge(56);

        Person person3 = new Person();
        person3.setLastName("Doe");
        person3.setFirstName("John");
        person3.setAge(36);

        Person person4 = new Person();
        person4.setLastName("Doe");
        person4.setFirstName("Jane");
        person3.setAge(36);

        Person person5 = new Person();
        person5.setLastName("Dupont");
        person5.setFirstName("Jacques");
        person5.setAge(68);

        // Enregistrement des entités
        session.save(person1);
        session.save(person2);
        session.save(person3);
        session.save(person4);
        session.save(person5);
        // L'objet Java est mis à jour, on peut récupérer l'ID de la personne
        System.out.println("* ID de la 1e personne enregistrée : " + person1.getId());

        // Commit de la transaction = enregistrement définitif
        session.getTransaction().commit();


        // Récupération d'une personne et modification :

        session.getTransaction().begin();

        Person person = session.load(Person.class, 1);
        System.out.println("* Modification de " + person.getFirstName());

        // Attention : si on souhaite modifier ou supprimer une occurence en BDD,
        // il faut être dans la même transaction que lors de sa réscupération
        person.setAge(29);
        session.update(person);

        session.getTransaction().commit();


        // Suppression d'une personne :

        session.getTransaction().begin();

        Person personSearch = session.load(Person.class, 2);
        System.out.println("* Suppression de " + personSearch.getFirstName());

        session.delete(personSearch);

        session.getTransaction().commit();

        // Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();
    }
}
