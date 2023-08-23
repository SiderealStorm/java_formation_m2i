package org.example.demos.jpa.entity.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Exemple d'entité avec relation many-to-many
 * Cette entité est liée à Post
 */
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Attribut facultatif pour relation bidirectionnelle
    // On précise le nom de l'attribut de la table maître à lier avec mappedBy
    @ManyToMany(mappedBy = "tags")
    private List<Post> posts = new ArrayList<>();

    public Tag() {}

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
