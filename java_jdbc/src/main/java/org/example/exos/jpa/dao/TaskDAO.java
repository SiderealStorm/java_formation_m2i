package org.example.exos.jpa.dao;

import org.example.exos.jpa.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TaskDAO implements BaseDAO<Task> {

    private final EntityManagerFactory emf;

    public TaskDAO(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    public void closeDAO() {
        emf.close();
    }

    public boolean add(Task task) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            // begin() rend la transaction active
            transaction.begin();
            em.persist(task);
            // commit() valide les changements et rend la transaction inactive
            transaction.commit();
            return true;
        } catch (Exception e) {     // Récupération de toute exception
            // On affiche l'erreur
            e.printStackTrace();
            // Si la transaction était en cours...
            if (transaction.isActive()) {
                // ... On annule la transaction pour éviter les problèmes en BDD
                // rollback() permet de revenir à l'état de la BDD avant begin()
                transaction.rollback();
                return false;
            }
            // Si le problème ne vient pas de la BDD, on renvoie true car l'entité est sauvegardée
            return true;
        } finally {
            // Malgré le return, le programme passe par le finally donc on peut s'en servir pour fermer l'EntityManager
            em.close();
        }
    }

    public List<Task> get() {
        List<Task> taskList;
        EntityManager em = emf.createEntityManager();
        taskList = em.createQuery("SELECT t FROM Task t ORDER BY id", Task.class).getResultList();
        em.close();

        return taskList;
    }

    public Task get(int id) {
        EntityManager em = emf.createEntityManager();
        Task task = em.find(Task.class, id);
        em.close();

        return task;
    }

    public boolean update(Task newTask) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Task task = em.find(Task.class, newTask.getId());
            task.setTitle(newTask.getTitle());
            task.setCompleted(newTask.isCompleted());

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

    public boolean delete(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Task task = em.find(Task.class, id);
            em.remove(task);
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
