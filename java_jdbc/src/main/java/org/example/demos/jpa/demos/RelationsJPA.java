package org.example.demos.jpa.demos;

import org.example.demos.jpa.entity.Address;
import org.example.demos.jpa.entity.House;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RelationsJPA {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_postgres");

    public static void oneToOneExample() {
        EntityManager em = emf.createEntityManager();

        // Début de transaction
        em.getTransaction().begin();

        // Création d'un objet Address
        Address address = new Address();
        address.setNumber(123);
        address.setStreet("rue Bidon");
        address.setPostalCode("99999");
        address.setCity("FakeCity");

        // Création d'un objet House
        House house = new House();
        house.setSize(125);
        house.setAddress(address);

        // Enregistrement de la maison ET de l'adresse CAR CascadeType = ALL
        em.persist(house);

        // Fin de transaction
        em.getTransaction().commit();

        // Récupération de la maison sauvegardée
        House houseSearch = em.find(House.class, house.getId());
        // Affichage de l'objet récupéré
        // L'adresse fait partie de l'objet maison, elle est donc disponible
        System.out.println(houseSearch);

        em.close();
    }

    public static void oneToManyExample() {

    }

    public static void manyToManyExample() {

    }
}
