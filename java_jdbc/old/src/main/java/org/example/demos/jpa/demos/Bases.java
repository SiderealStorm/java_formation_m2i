package org.example.demos.jpa.demos;

import org.example.demos.jpa.entity.Person;

import javax.persistence.*;
import java.util.List;

public class Bases {
    // Pour pouvoir utiliser la BDD, on crée d'abord une EntityManagerFactory
    // Il faut passer en paramètre le nom de la persistenceUnit du fichier de configuration persistence.xml
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_postgres");

    public static void closeEmf() {
        emf.close();
    }

    public static void insertExample() {

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

        // flush() permet de valider les modifications (= mettre à jour la table) mais pas de terminer la transaction donc il ne suffit pas ici

        // commit() permet de valider (comme flush) et terminer la transaction
        em.getTransaction().commit();

        // Une fois qu'on en a plus besoin, on peut fermer le Manager et la Factory
        em.close();
    }

    // S'il n'y a pas de modification en BDD, pas besoin de faire une transaction
    public static void findExample() {
        EntityManager em = emf.createEntityManager();

        // Pour utilider find, il faut passer le type de l'objet (.class) et l'ID
        // Renvoie null si l'entité n'est pas trouvée
        System.out.println("Avec find :");
        Person person = em.find(Person.class, 1L);
        System.out.println(person);

        // Idem avec getReference()
        // Lève une exception si l'entité n'est pas trouvée
        System.out.println("Avec getReference :");
        person = em.getReference(Person.class, 1L);
        System.out.println(person);

        em.close();
    }

    public static void removeExample() {
        EntityManager em = emf.createEntityManager();

        // Démarrage de la transaction
        em.getTransaction().begin();

        Person person = em.find(Person.class, 1L);
        // Attention : levée d'une exception si la personne n'est pas trouvée !
        em.remove(person);
        System.out.println("Personne à l'ID 1 supprimée !");

        // Validation de la transaction
        em.getTransaction().commit();

        em.close();
    }

    public static void createQueryExample() {
        EntityManager em = emf.createEntityManager();

        // On peut aussi stocker la transaction à part :
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Person person1 = new Person("Zachary", "Bannerman");
        Person person2 = new Person("Sun", "Graf");

        List<Person> personList;

        em.persist(person1);
        em.persist(person2);

        System.out.println("Ajout de 2 personnes");

        // On pourrait valider (commiter) la transaction ici

        personList = em.createQuery("select p from Person p", Person.class).getResultList();

        for (Person person : personList) {
            System.out.println(person);
        }

        transaction.commit();

        em.close();
    }

    public static void namedParameterExample() {
        EntityManager em = emf.createEntityManager();

        System.out.println("Avec un paramètre nommé");

        // On crée la requête :
        Query query = em.createQuery("SELECT p FROM Person p WHERE p.id = :id");
        // On passe la valeur au paramètre :
        query.setParameter("id", 1L);
        // On utilise getSingleResult() car la requête ne renvoie qu'un seul résultat
        // Il faut caster le résultat en objet Person
        Person person = (Person) query.getSingleResult();

        System.out.println(person);

        em.close();
    }

}
