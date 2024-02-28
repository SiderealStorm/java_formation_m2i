package org.example;

import org.example.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Préparation de la session :
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        // Ouverture de la session :
        Session session = sessionFactory.openSession();
        
        // Création de 5 produits
        Product product1 = new Product();
        product1.setBrand("Test 1");
        product1.setReference("123456ABC");
        product1.setPurchaseDate(new Date());
        product1.setPrice(15.99);
        product1.setStock(12);

        Product product2 = new Product();
        product2.setBrand("Test 2");
        product2.setReference("234567AZE");
        product2.setPurchaseDate(new Date());
        product2.setPrice(159.99);
        product2.setStock(1);

        Product product3 = new Product();
        product3.setBrand("345678QSD");
        product3.setReference("Référence test 3");
        product3.setPurchaseDate(new Date());
        product3.setPrice(5.99);
        product3.setStock(112);

        Product product4 = new Product();
        product4.setBrand("Test 4");
        product4.setReference("456789REZ");
        product4.setPurchaseDate(new Date());
        product4.setPrice(165.99);
        product4.setStock(2);

        Product product5 = new Product();
        product5.setBrand("Test 5");
        product5.setReference("567890QWX");
        product5.setPurchaseDate(new Date());
        product5.setPrice(10.99);
        product5.setStock(25);

        // Ajout des 5 produits en BDD

        session.getTransaction().begin();
        System.out.println("=== Ajout produits ===");
        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);
        session.save(product5);

        session.getTransaction().commit();

        // Affichage du produit 2

        Product product = session.load(Product.class, 2);
        System.out.println("=== Affichage produit 2 ===");
        System.out.println(product);

        // Suppression du produit 3

        session.getTransaction().begin();

        product = session.load(Product.class, 3);
        System.out.println("=== Suppression du produit " + product.getId() + " ===");

        session.delete(product);

        session.getTransaction().commit();

        // Modification du produit 1

        session.getTransaction().begin();

        product = session.load(Product.class, 1);
        System.out.println("=== Modification du produit " + product.getId() + " ===");
        product.setReference("Référence modifiée de test 1");

        session.update(product);

        session.getTransaction().commit();
        
        // Fermeture de Session et SessionFactory
        session.close();
        sessionFactory.close();
    }
}
