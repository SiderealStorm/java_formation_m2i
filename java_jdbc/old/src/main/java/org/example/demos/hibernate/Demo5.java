package org.example.demos.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Demo5 {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Native SQL
        NativeQuery query = session.createSQLQuery("SELECT * FROM person");
        List persons = query.list();    // Le résultat est une liste de tableaux objet non typé !


        for (Object o: persons) {
            Object[] p = (Object[]) o;
            System.out.println(p[0] + " - âge : " + p[1] + " - Prénom : " + p[2]);
        }

        session.close();
        sessionFactory.close();
    }
}
