package org.example;

import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();


        // Fonctions d'agragation
        Query<Integer> queryMaxAge = session.createQuery("SELECT MAX(age) FROM Person");
        int maxAge = queryMaxAge.uniqueResult();

        System.out.println("* Âge maximum : " + maxAge);

        double avgAge = (double) session.createQuery("SELECT AVG(age) FROM Person").uniqueResult();
        System.out.println("* Âge moyen : " + avgAge);

        // Utilisation de la clause IN
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");

        Query<Person> inQuery = session.createQuery("FROM Person WHERE firstName IN :names");
        inQuery.setParameterList("names", names);

        List<Person> persons = inQuery.list();

        System.out.println("* Personnes dont le prénom est 'John' ou 'Jane'");
        for (Person p: persons) {
            System.out.println(p);
        }

        // Utilisation de l'executeUpdate (ou Delete) = requiert une transaction
        String updateQuery = "UPDATE Person SET firstName = :fName WHERE id = 5";
        Query query = session.createQuery(updateQuery);
        query.setParameter("fName", "Michel");
        session.getTransaction().begin();
        int success = query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("* Prénom de l'ID 5 modifié : " + (success == 1));

        session.close();
        sessionFactory.close();
    }
}
