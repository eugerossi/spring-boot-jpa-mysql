package springjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@NamedQuery(name = "Employee.findEmployeeByNamedQuery",
        query = "SELECT e FROM Employee e WHERE e.lastName like  concat('%', ?1, '%')")
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

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
