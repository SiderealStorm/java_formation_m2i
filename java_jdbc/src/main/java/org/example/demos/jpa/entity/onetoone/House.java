package org.example.demos.jpa.entity.onetoone;

import javax.persistence.*;

/**
 * Exemple d'entité avec relation one-to-one
 * Cette entité est liée à Address
 * Cette classe est l'entité maître
 */
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "house_id")
    private Long id;

    // Pas d'annotation donc @Basic par défaut
    private Integer size;

    // Annotation pour définir la relation one-to-one
    // On précise la stratégie en cas de modification ou suppression avec cascade
    // L'option cascade s'applique à l'entité où elle est déclarée
    @OneToOne(cascade = CascadeType.ALL)
    // Annotation pour joindre l'autre entité via sa clé étrangère
    // Si on voulait référencer une autre colonne, on utiliserait referencedColumnName en plus
    // On précise le nom de la colonne qui contiendra la clé étrangère
    // On ajoute unique = true sinon la table pourraît cnotenir des données avec une relation one-to-many
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    public House() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", size=" + size +
                ", address=" + address +
                '}';
    }
}
