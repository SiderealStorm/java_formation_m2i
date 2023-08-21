package org.example.exos.jpa.exo1.dao;

import org.example.exos.jpa.exo1.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TaskDAO {

    private EntityManagerFactory emf;

    public TaskDAO(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    public void close() {
        emf.close();
    }

    public void add(Task task)  {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(task);

        em.getTransaction().commit();

        em.close();
    }

    public List<Task> get() {
        List<Task> taskList;

        EntityManager em = emf.createEntityManager();
        taskList = em.createQuery("select task from Task task order by id", Task.class).getResultList();

        return taskList;
    }

    public Task get(int id) {
        EntityManager em = emf.createEntityManager();
        Task task = em.find(Task.class, id);
        em.close();

        return task;
    }

    public void update(Task newTask) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Task task = em.find(Task.class, newTask.getId());
        task.setTitle(newTask.getTitle());
        task.setCompleted(newTask.isCompleted());

        em.getTransaction().commit();

        em.close();
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Task task = em.find(Task.class, id);
        em.remove(task);

        em.getTransaction().commit();

        em.close();
    }

}
