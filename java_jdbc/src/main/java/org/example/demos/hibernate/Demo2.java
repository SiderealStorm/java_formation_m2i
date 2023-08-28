package org.example.demos.hibernate;

import org.example.demos.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // HQL

        // Récupérer la liste des personnes

        Query<Person> personQuery = session.createQuery("from Person");

        // avec la liste
        System.out.println("=== Liste des personnes avec .list() ===");
        List<Person> persons = personQuery.list();
        for (Person p: persons) {
            System.out.println(p);
        }

        // avec l'iterator
        System.out.println("=== Liste des personnes avec .iterate() ===");
        Iterator<Person> personIterator = personQuery.iterate();
        while(personIterator.hasNext()){
            Person p = (Person) personIterator.next();
            System.out.println(p);
        }

        // Une rêquete avec filtre pour récupérer une liste
        System.out.println("=== Personnes dont le nom est 'Doe' ===");
        Query<Person> personQuery1 = session.createQuery("from Person where name = 'Doe' ");
        List<Person> personList = personQuery1.list();
        for (Person p: personList) {
            System.out.println(p);
        }

        // Une requete avec un filtre pour recuperer un seul element
        System.out.println("=== Personne avec l'ID 2 ===");
        Query<Person> personQuery2 = session.createQuery("from Person where id = 2");
        Person p = personQuery2.uniqueResult();
        System.out.println(p);

        // Fermetures
        session.close();
        sessionFactory.close();
    }
}
