package springjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE")
@NamedQuery(name = "Employee.findEmployeeByNamedQuery",
        query = "SELECT e FROM Employee e WHERE e.lastName like  concat('%', ?1, '%')")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private Integer status;

    private String address;

    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getFirstName().equals(employee.getFirstName()) &&
                getLastName().equals(employee.getLastName()) &&
                getCompany().equals(employee.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getCompany());
    }
}
