package org.example.exos.jpa.entity;

import javax.persistence.*;
import java.util.List;

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "category_task",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> tasks;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    // TODO vérifier si utile ou non
    public void addTask(Task task) {
        this.tasks.add(task);
        task.getCategories().add(this);
    }

    public void removeTask(Task task) {
        this.tasks.add(task);
        task.getCategories().add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
