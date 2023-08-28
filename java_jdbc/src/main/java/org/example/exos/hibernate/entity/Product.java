package org.example.exos.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "exo")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String reference;

    @Column(name = "purchase_date")
    private Date purchaseDate;
    private double price;
    private int stock;

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", reference='" + reference + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
