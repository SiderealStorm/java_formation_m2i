package org.example.exos.jpa.exo1.service;

import org.example.exos.jpa.exo1.dao.TaskDAO;
import org.example.exos.jpa.exo1.entity.Task;
import org.example.exos.jpa.exo1.entity.TaskInfo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
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

    public boolean saveTask(String title, String description, Date date, int priority) {
        TaskInfo info = new TaskInfo(description, date, priority);
        Task task = new Task(title, info);
        // C'est TaskInfo le maître de la relation, il faut donc que l'objet TaskInfo contienne l'objet Task
        info.setTask(task);
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
