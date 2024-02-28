package org.example.demos.jpa.entity.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Exemple d'entité avec relation one-to-many
 * Cette entité est liée à Employee
 */
@Entity
public class Department {
    @Id
    private int id;

    private String deptName;

    // Attribut facultatif pour relation bidirectionnelle
    // On précise le nom de l'attribut de la table maître à lier avec mappedBy
    @OneToMany(mappedBy = "dept")
    // L'attribut est obligatoirement une collection
    private Collection<Employee> employees;

    public Department() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
