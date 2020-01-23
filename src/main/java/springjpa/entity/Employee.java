package springjpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="EMPLOYEE")
@NamedQuery(name = "Employee.findEmployeeByNamedQuery",
        query = "SELECT e FROM Employee e WHERE e.lastName like  concat('%', ?1, '%')")
public class Employee implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "STATUS", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
