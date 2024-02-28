package org.example.exos.hibernate.dao;

import org.example.exos.hibernate.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ProductDAO {
    SessionFactory sessionFactory;
    Query<Product> productQuery;

    public ProductDAO () {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public void close() {
        sessionFactory.close();
    }

    public void save(Product product) {
        Session  session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.save(product);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Product product = session.load(Product.class, id);
        session.delete(product);

        session.getTransaction().commit();
        session.close();
    }

    public void update(Product product) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Product productSearch = session.load(Product.class, product.getId());

        productSearch.setBrand(product.getBrand());
        productSearch.setReference(product.getReference());
        productSearch.setStock(product.getStock());
        productSearch.setPrice(product.getPrice());
        productSearch.setPurchaseDate(product.getPurchaseDate());

        session.update(productSearch);

        session.getTransaction().commit();
        session.close();
    }

    public Product get(int id) {
        Session session = sessionFactory.openSession();

        Product product = session.load(Product.class, id);

        session.close();

        return product;
    }

    public List<Product> get() {
        Session session = sessionFactory.openSession();

        List<Product> products = session.createQuery("FROM Product ORDER BY id").list();

        session.close();

        return products;
    }

    public List<Product> getByMinPrice(double price) {
        Session session = sessionFactory.openSession();

        productQuery = session.createQuery("FROM Product WHERE price > :price");
        productQuery.setParameter("price", price);
        List<Product> products = productQuery.list();

        session.close();
        return products;
    }

    public List<Product> getByPurchasedDateRange(LocalDate minDate, LocalDate maxDate) {
        Session session = sessionFactory.openSession();

        productQuery = session.createQuery("FROM Product WHERE purchaseDate > :minDate AND purchaseDate < :maxDate");
        productQuery.setParameter("minDate", minDate);
        productQuery.setParameter("maxDate", maxDate);
        List<Product> products = productQuery.list();

        session.close();
        return products;
    }
}
