package org.example.exos.hibernate;

import org.example.exos.hibernate.dao.ProductDAO;
import org.example.exos.hibernate.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // PARTIE 1 :
        
        // Création de 5 produits
        Product product1 = new Product();
        product1.setBrand("Test 1");
        product1.setReference("123456ABC");
        product1.setPurchaseDate(LocalDate.of(2023, 3, 26));
        product1.setPrice(15.99);
        product1.setStock(12);

        Product product2 = new Product();
        product2.setBrand("Test 2");
        product2.setReference("234567AZE");
        product2.setPurchaseDate(LocalDate.of(2023, 4, 6));
        product2.setPrice(159.99);
        product2.setStock(1);

        Product product3 = new Product();
        product3.setBrand("345678QSD");
        product3.setReference("Référence test 3");
        product3.setPurchaseDate(LocalDate.of(2023, 7, 2));
        product3.setPrice(5.99);
        product3.setStock(112);

        Product product4 = new Product();
        product4.setBrand("Test 4");
        product4.setReference("456789REZ");
        product4.setPurchaseDate(LocalDate.of(2023, 5, 16));
        product4.setPrice(165.99);
        product4.setStock(2);

        Product product5 = new Product();
        product5.setBrand("Test 5");
        product5.setReference("567890QWX");
        product5.setPurchaseDate(LocalDate.of(2023, 2, 12));
        product5.setPrice(10.99);
        product5.setStock(25);

        // Ajout des 5 produits en BDD

        ProductDAO dao = new ProductDAO();
        dao.openSession();

        dao.save(product1);
        dao.save(product2);
        dao.save(product3);
        dao.save(product4);
        dao.save(product5);

        // Affichage du produit 2

        Product product = dao.get(2);
        System.out.println("=== Affichage produit 2 ===");
        System.out.println(product);

        dao.closeSession();
        // Suppression du produit 3

        System.out.println("=== Suppression du produit 3 ===");
        dao.delete(3);

        // Modification du produit 1

        System.out.println("=== Modification du produit 1 ===");
        product1.setBrand("Test 1 modifié");

        dao.update(product1);


        // PARTIE 2 :

        // Affichage de tous les produits

        List<Product> products = dao.get();
        System.out.println("=== Affichage des produits ===");
        products.forEach(System.out::println);

        // Affichage des produits à plus de 100€

        products = dao.getByMinPrice(100);
        System.out.println("=== Produits à plus de 100€ ===");
        products.forEach(System.out::println);

        // Affichage des produits achetés entre février et avril 2023

        LocalDate minDate = LocalDate.of(2023, 2, 28);
        LocalDate maxDate = LocalDate.of(2023, 4, 30);
        products = dao.getByPurchasedDateRange(minDate, maxDate);
        System.out.println("=== Produits achetés entre février et avril 2023 ===");
        products.forEach(System.out::println);

    }
}
