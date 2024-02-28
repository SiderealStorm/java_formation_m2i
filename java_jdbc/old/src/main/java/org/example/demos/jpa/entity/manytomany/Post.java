package org.example.demos.jpa.entity.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Exemple d'entité avec relation many-to-many
 * Cette entité est liée à Tag
 * Cette classe est l'entité maître
 */
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    // Annotation pour définir la relation many-to-many
    // On préfèrera mettre le cascade dans l'élément qu'on manipule le plus
    @ManyToMany(cascade = CascadeType.PERSIST)
    // On ne joint pas une colonne, mais une TABLE d'association
    @JoinTable(
            name = "post_tag",
            // On précise les colonnes que contiennent la table d'association
            // La première correspond à l'entité qui déclare la relation
            joinColumns = @JoinColumn(name = "post_id"),
            // La seconde correspond à l'entité qu'on veut lui lier
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    // L'attribut est forcément une collection
    private List<Tag> tags = new ArrayList<>();

    public Post() {}

    public Post(String title) {
        this.title = title;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getPosts().add(this);
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
