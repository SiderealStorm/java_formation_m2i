package org.example.exos.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;
    private String title;
    private boolean completed;

    // Attention : Il est préférable d'ajouter la relation dans TaskInfo car Task existait auparavant
    // En modifiant Task, la table aurait une nouvelle colonne, qui sera nulle pour les données déjà présentes en BDD
    // orphanRemoval permet de supprimer toutes les valeurs orphelines (= infos sans task)
    @OneToOne(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private TaskInfo info;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "tasks")
    private List<Category> categories;

    public Task() {}

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public Task(String title, TaskInfo info) {
        this(title);
        this.info = info;
    }

    public Task(String title, TaskInfo info, User user) {
        this(title, info);
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TaskInfo getInfo() {
        return this.info;
    }

    public void setInfo(TaskInfo info) {
        this.info = info;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        // Utilisation d'un ternaire pour afficher si complété
        return id + " : " + title + " - " + (completed ? "terminée" : "en cours");
    }
}
