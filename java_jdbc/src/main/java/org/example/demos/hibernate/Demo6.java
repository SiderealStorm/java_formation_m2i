package org.example.demos.hibernate;

import org.example.demos.hibernate.entity.Company;
import org.example.demos.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Demo6 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Démo Many-To-One

        Transaction transaction = session.getTransaction();
        transaction.begin();

        // Création d'une entreprise
        Company company = new Company();
        company.setName("M2i");

        session.save(company);

        // Création d'une personne

        Person person = new Person();
        person.setFirstName("Toto");
        person.setLastName("Tata");
        person.setCompany(company);

        session.save(person);

        // Récupération des personnes
        Query<Person> personQuery = session.createQuery("FROM Person");
        List<Person> personList = personQuery.list();

        for (Person p : personList) {
            System.out.println(p);
            // En LAZY, on récupère l'entreprise uniquement lorsque l'on s'en sert
            if (p.getCompany() != null) {
                System.out.println("Entreprise : " + p.getCompany().getName());
            }
        }

        // Récupération de l'entreprise en BDD

        Company company1 = session.get(Company.class, 1);

        Person person1 = new Person();
        person1.setLastName("Titi");
        person1.setFirstName("Tata");
        person1.setCompany(company1);
        session.save(person);
        company1.addPerson(person1);
        session.update(company1);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
