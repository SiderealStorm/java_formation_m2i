package org.example.exos.jpa.service;

import org.example.exos.jpa.dao.CategoryDAO;
import org.example.exos.jpa.dao.TaskDAO;
import org.example.exos.jpa.dao.UserDAO;
import org.example.exos.jpa.entity.Category;
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
    private final CategoryDAO categoryDAO;

    public Service() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_postgres");
        taskDAO = new TaskDAO(emf);
        userDAO = new UserDAO(emf);
        categoryDAO = new CategoryDAO(emf);
    }

    public void closeDAO() {
        taskDAO.closeDAO();
        userDAO.closeDAO();
    }

    public boolean saveTask(String title, String description, Date date, int priority, User user) {
        // Il faut mettre les objets en relation dans les DEUX sens
        TaskInfo info = new TaskInfo(description, date, priority);
        Task task = new Task(title, info, user);
        // C'est TaskInfo le maître de la relation, il faut donc que l'objet TaskInfo contienne l'objet Task
        info.setTask(task);
        return taskDAO.add(task);
    }

    public List<Task> getAllTasks() {
        return taskDAO.get();
    }

    public boolean markTaskAsCompleted(Task task) {
        task.setCompleted(true);
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

    public boolean saveCategory(String name) {
        Category category = new Category(name);
        return categoryDAO.add(category);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.get();
    }

    public boolean deleteCategory(int id) {
        return categoryDAO.delete(id);
    }

    public Category getCategory(int id) {
        return categoryDAO.get(id);
    }

    public boolean addTaskToCategory(Task task, Category category) {
        category.getTasks().add(task);
        return categoryDAO.update(category);
    }

    public boolean removeTaskFromCategory(Task task, Category category) {
            category.getTasks().removeIf(t -> t.getId() == task.getId());
        return categoryDAO.update(category);
    }
}
