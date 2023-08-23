package org.example.exos.jpa.exo1.entity;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;
    private String title;
    private boolean completed;

    // Attention : Il est été préférable d'ajouter la relation dans TaskInfo car Task existait auparavant
    // En modifiant Task, la table aurait une nouvelle colonne, qui sera nulle pour les données déjà présentes en BDD
    // orphanRemoval permet de supprimer toutes les valeurs orphelines = infos sans task
    @OneToOne(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private TaskInfo info;

    public Task() {}

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    /**
     *
     * @param title
     * @param info
     */
    public Task(String title, TaskInfo info) {
        this(title);
        this.info = info;
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

    @Override
    public String toString() {
        // Utilisation d'un ternaire pour afficher si complété
        return id + " : " + title + " - " + (completed ? "terminée" : "en cours");
    }

}
