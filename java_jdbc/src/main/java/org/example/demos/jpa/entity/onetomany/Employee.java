package org.example.demos.jpa.entity.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Exemple d'entité avec relation many-to-one
 * Cette entité est liée à Department
 * Cette classe est l'entité maître
 */
@Entity
public class Employee {
    @Id
    private int id;

    // Annotation pour définir la relation many-to-one
    // C'est obligatoirement l'entité plurielle qui est maître de la relation
    @ManyToOne
    // Annotation pour joindre l'autre entité via sa clé étrangère
    @JoinColumn(name = "dept_id")
    private Department dept;

    public Employee() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}
