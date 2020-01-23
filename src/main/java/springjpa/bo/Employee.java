package springjpa.bo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="EMPLOYEE")
@NamedQuery(name = "Employee.findByLastNameNamedQuery",
        query = "SELECT e FROM Employee e WHERE e.lastName like  concat('%', ?1, '%')")
public class Employee implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    public Employee(){
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
