package org.example.demos.jpa.demos;

import org.example.demos.jpa.entity.onetomany.Department;
import org.example.demos.jpa.entity.onetomany.Employee;
import org.example.demos.jpa.entity.onetoone.Address;
import org.example.demos.jpa.entity.onetoone.House;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;

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
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Création d'employés
        Employee employee = new Employee();
        Employee employee1 = new Employee();

        // Attention les ID ne sont pas gérés automatiquement !
        employee.setId(6);
        employee1.setId(8);

        // Création de départements
        Department department = new Department();
        department.setId(1);
        department.setDeptName("Science");

        // Mise en relation des entités, dans les DEUX sens
        employee.setDept(department);
        employee1.setDept(department);

        Collection<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        department.setEmployees(list);

        // Mise en BDD
        // On enregistre d'abord l'entité ayant la relation one-to-many
        // car on aura besoin de son ID dans la table contenant la clé étrangère
        em.persist(department);
        em.persist(employee);
        em.persist(employee1);

        em.getTransaction().commit();

        // Récupération et affichage des entités
        Department deptSearch = em.find(Department.class, 1);
        System.out.println(deptSearch);
        for (Employee emp : deptSearch.getEmployees()) {
            System.out.println(emp);
        }

        em.close();
    }

    public static void manyToManyExample() {

    }
}
