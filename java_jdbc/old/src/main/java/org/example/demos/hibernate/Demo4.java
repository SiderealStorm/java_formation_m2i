package org.example.demos.hibernate;

import org.example.demos.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Utilisation de Like

        String search = "J";
        Query<Person> personQuery = session.createQuery("FROM Person WHERE firstName LIKE :fName");
        // La clause LIKE requiert d'utiliser %
        // setParameter prend en paramètres le
        personQuery.setParameter("fName", search + "%", StringType.INSTANCE);
        List<Person> personList = personQuery.list();
        personList.forEach(System.out::println);

        // Paramètres positionnés
        personQuery = session.createQuery("FROM Person WHERE firstName LIKE ?1");
        personQuery.setParameter(1, search + "%", StringType.INSTANCE);
        personList = personQuery.list();
        personList.forEach(System.out::println);

        // Select + alias
        personQuery = session.createQuery("SELECT lastName, firstName FROM Person AS p where p.lastName LIKE ?1");
        personQuery.setParameter(1, search + "%", StringType.INSTANCE);
        // Attention :  le resultat sera sous forme d'un arraylist de tableau d'objet
        List result = personQuery.list();

        List<Person> personneList = new ArrayList<>();

        // Convertir le resultat en list d'objet Personne
        for (Object o: result) {
            Object[] res = (Object[]) o;
            Person pr = new Person();
            pr.setLastName((String) res[0]);
            pr.setFirstName((String) res[1]);
            personneList.add(pr);
        }

        for (Person p :personneList) {
            System.out.println(p.getLastName());
            System.out.println(p.getFirstName());
        }

        session.close();
        sessionFactory.close();
    }
}
