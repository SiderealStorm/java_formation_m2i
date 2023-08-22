package org.example.exos.jpa.exo1.dao;

import org.example.exos.jpa.exo1.entity.TaskInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TaskInfoDAO {

    private final EntityManagerFactory emf;

    public TaskInfoDAO(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    public void closeDAO() {
        emf.close();
    }

    public TaskInfo get(int id) {
        return null;
    }

    public boolean update(TaskInfo element) {
        return false;
    }

}
