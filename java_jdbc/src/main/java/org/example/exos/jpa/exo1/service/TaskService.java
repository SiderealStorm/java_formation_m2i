package org.example.exos.jpa.exo1.service;

import org.example.exos.jpa.exo1.dao.TaskDAO;
import org.example.exos.jpa.exo1.entity.Task;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private TaskDAO taskDAO;

    public TaskService() {
        taskDAO = new TaskDAO(Persistence.createEntityManagerFactory("jpa_postgres"));
    }

    public void closeDAO() {
        taskDAO.close();
    }

    public void saveTask(String title) {
        Task task = new Task(title);
        try {
            taskDAO.add(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();
        try {
            taskList = taskDAO.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;
    }

    public void updateTask(Task task) {
        try {
            taskDAO.update(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int id) {
        try {
            taskDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Task getById(int id) {
        Task task = null;
        try {
            task = taskDAO.get(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return task;
    }
}
