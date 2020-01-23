package springjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springjpa.bo.Employee;
import springjpa.repository.EmployeeRepository;
import springjpa.service.EmployeeService;
import springjpa.util.exception.EmployeeNotFoundException;

import java.util.List;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee get(int id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(id)
        );
    }

    public List<Employee> findByLastName(String lastName)
    {
        return employeeRepository.findByLastName(lastName);
    }

    public List<Employee> findByLastNameQuery(String lastName)
    {
        return employeeRepository.findByLastNameQuery(lastName);
    }

    public List<Employee> findByLastNameNamedQuery(String lastName)
    {
        return employeeRepository.findByLastNameNamedQuery(lastName);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, new String[]{"lastName","firstName"}));
    }
}
