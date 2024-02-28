package org.example.exos.jpa.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.exos.jpa.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UserDAO implements BaseDAO<User> {
    
    private final EntityManagerFactory emf;
    
    public UserDAO(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }
    
    @Override
    public void closeDAO() {
        emf.close();
    }

    @Override
    public boolean add(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(user);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
                return false;
            }
            return true;
        } finally {
            em.close();
        }
    }

    @Override
    public List<User> get() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u ORDER BY id", User.class).getResultList();
        em.close();
        return users;
    }

    @Override
    public User get(int id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    @Override
    public boolean update(User user) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Erreur : la méthode update() n'est pas implémentée pour UserDAO");
    }

    @Override
    public boolean delete(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            User user = em.find(User.class, id);
            em.remove(user);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
                return false;
            }
            return true;
        } finally {
            em.close();
        }
    }
}
