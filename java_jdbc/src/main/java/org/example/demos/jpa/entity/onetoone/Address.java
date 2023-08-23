package org.example.demos.jpa.entity.onetoone;

import javax.persistence.*;

/**
 * Exemple d'entité avec relation one-to-one
 * Cette entité est liée à House
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;

    // On peut ajouter d'autres propriétés avec @Column
    @Column(nullable = false)
    private Integer number;

    private String street;

    @Column(name = "postal_code", length = 5)
    private String postalCode;

    private String city;

    // Attribut House facultatif : la relation devient bidirectionnelle
    // La relation est définie dans House, il faut juste indiquer comment elle est mappée avec mappedBy
    // mappedBy prend comme valeur le nom de la propriété, pas de la colonne !
    @OneToOne(mappedBy = "address")
    private House house;

    public Address() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number=" + number +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
