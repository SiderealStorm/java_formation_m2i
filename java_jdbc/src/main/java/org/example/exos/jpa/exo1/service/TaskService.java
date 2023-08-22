package org.example.exos.jpa.exo1.service;

import org.example.exos.jpa.exo1.dao.TaskDAO;
import org.example.exos.jpa.exo1.entity.Task;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TaskService {

    private final TaskDAO taskDAO;

    public TaskService() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_postgres");
        taskDAO = new TaskDAO(emf);
    }

    public void closeDAO() {
        taskDAO.closeDAO();
    }

    public boolean saveTask(String title) {
        Task task = new Task(title);
        return taskDAO.add(task);
    }

    public List<Task> getAllTasks() {
        return taskDAO.get();
    }

    public boolean updateTask(Task task) {
        return taskDAO.update(task);
    }

    public boolean deleteTask(int id) {
        return taskDAO.delete(id);
    }

    public Task getById(int id) {
        return taskDAO.get(id);
    }
}
