package org.example.demos.jpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Demo {
    // Pour pouvoir utiliser la BDD, on crée d'abord une EntityManagerFactory
    // Il faut passer en paramètre le nom de la persistenceUnit du fichier de configuration persistence.xml
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_postgres");

    public static void insertExemple() {

        // On utilise la Factory pour créer un EntityManager, qui permettra de communiquer avec la BDD
        EntityManager em = emf.createEntityManager();

        // On démarre une transaction
        em.getTransaction().begin();

        Person person= new Person("Storm", "Lbn");
        System.out.println("ID avant d'utiliser persist() : " + person.getId());

        // persist() permet de "suivre" l'objet et de le sauvegarder en BDD
        // La ligne n'est pas visible en BDD mais est présente en "cache"
        em.persist(person);
        System.out.println("ID après avoir utilisé persist() : " + person.getId());

        // commit() permet de valider définitivement la transaction
        em.getTransaction().commit();

        // Une fois qu'on en a plus besoin, on peut fermer le Manager et la Factory
        em.close();
        emf.createEntityManager();
    }

    // S'il n'y a pas de modification en BDD, pas besoin de faire une transaction
    public static void findExemple() {
        EntityManager em = emf.createEntityManager();

        // Pour utilider find, il faut passer le type de l'objet (.class) et l'ID
        // Attention : levée d'une exception si la personne n'est pas trouvée !
        Person person = em.find(Person.class, 1L);
        System.out.println(person);

        em.close();
        emf.createEntityManager();
    }

    public static void removeExemple() {
        EntityManager em = emf.createEntityManager();

        // Démarrage de la transaction
        em.getTransaction().begin();

        Person person = em.find(Person.class, 1L);
        // Attention : levée d'une exception si la personne n'est pas trouvée !
        em.remove(person);

        // Validation de la transaction
        em.getTransaction().commit();

        em.close();
        emf.createEntityManager();
    }

    public static void customQueryExample() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person person1 = new Person("Zachary", "Bannerman");
        Person person2 = new Person("Sun", "Graf");

        List<Person> personList = null;

        em.persist(person1);
        em.persist(person2);

        // On pourrait valider (commiter) la transaction ici

        personList = em.createQuery("select p from Person p", Person.class).getResultList();

        for (Person person : personList) {
            System.out.println(person);
        }

        em.getTransaction().commit();

        em.close();
        emf.createEntityManager();
    }

}
