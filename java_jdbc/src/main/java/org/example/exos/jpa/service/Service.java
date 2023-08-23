package org.example.exos.jpa.service;

import org.example.exos.jpa.dao.TaskDAO;
import org.example.exos.jpa.dao.UserDAO;
import org.example.exos.jpa.entity.Task;
import org.example.exos.jpa.entity.TaskInfo;
import org.example.exos.jpa.entity.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Service {

    private final TaskDAO taskDAO;
    private final UserDAO userDAO;

    public Service() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_postgres");
        taskDAO = new TaskDAO(emf);
        userDAO = new UserDAO(emf);
    }

    public void closeDAO() {
        taskDAO.closeDAO();
        userDAO.closeDAO();
    }

    public boolean saveTask(String title, String description, Date date, int priority) {
        // Il faut mettre les objets en relation dans les DEUX sens
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

    public Task getTask(int id) {
        return taskDAO.get(id);
    }

    public boolean saveUser(String userName) {
        User user = new User(userName);
        return userDAO.add(user);
    }

    public List<User> getAllUsers() {
        return userDAO.get();
    }

    public boolean deleteUser(int id) {
        return userDAO.delete(id);
    }

    public User getUser(int id) {
        return userDAO.get(id);
    }
}
