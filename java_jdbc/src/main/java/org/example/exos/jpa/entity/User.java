package org.example.exos.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    // L'option cascade s'applique à l'entité où elle est déclarée
    // exemple ici : quand on supprime un User, on supprime aussi ses Tasks
    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Task> tasks;

    public User() {}

    public User(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return id + " : " + userName;
    }
}
