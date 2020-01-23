package springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springjpa.bo.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // It will try to match the value from bo property
    public List<Employee> findByLastName(String lastName);

    @Query("SELECT e FROM Employee e WHERE e.lastName like %:lastName%")
    public List<Employee> findByLastNameQuery(String lastName);

    // Using a namedQuery defined on Employee class
    public List<Employee> findByLastNameNamedQuery(String lastName);
}

