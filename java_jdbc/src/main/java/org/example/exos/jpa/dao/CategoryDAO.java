package org.example.exos.jpa.dao;

import org.example.exos.jpa.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoryDAO implements BaseDAO<Category> {

    private final EntityManagerFactory emf;

    public CategoryDAO(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    @Override
    public void closeDAO() {
        emf.close();
    }

    @Override
    public boolean add(Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(category);

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
    public List<Category> get() {
        EntityManager em = emf.createEntityManager();
        List<Category> categories = em.createQuery("SELECT c FROM Category c ORDER BY id", Category.class).getResultList();
        em.close();
        return categories;
    }

    @Override
    public Category get(int id) {
        EntityManager em = emf.createEntityManager();
        Category category = em.find(Category.class, id);
        em.close();
        return category;
    }

    @Override
    public boolean update(Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Category categoryDB = em.find(Category.class, category.getId());
            categoryDB.setTasks(category.getTasks());

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
    public boolean delete(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Category category = em.find(Category.class, id);
            em.remove(category);

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
