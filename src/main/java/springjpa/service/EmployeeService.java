package springjpa.service;

import springjpa.bo.Employee;

import java.util.List;

public interface EmployeeService {

    Employee get(int id);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByLastNameQuery(String lastName);

    List<Employee> findByLastNameNamedQuery(String lastName);

    List<Employee> findAll();
}
