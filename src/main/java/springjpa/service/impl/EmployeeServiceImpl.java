package springjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springjpa.entity.Employee;
import springjpa.repository.EmployeeRepository;
import springjpa.service.EmployeeService;
import springjpa.util.codetype.EmployeeStatus;
import springjpa.util.codetype.SearchType;
import springjpa.util.dto.EmployeeDTO;
import springjpa.util.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private static final Sort SORT_CRITERIA = Sort.by(Sort.Direction.ASC, "lastName", "firstName");

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee get(Integer id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(id)
        );
    }

    public List<Employee> findByStatus(Integer status) {
        return status == null ? employeeRepository.findAll(SORT_CRITERIA) : employeeRepository.findByStatus(status, SORT_CRITERIA);
    }

    public List<Employee> findByExample(SearchType searchType, EmployeeDTO example)
    {
        Employee employee = generateEmployeeFromDTO(example, false);
        switch (searchType)
        {
            case SPECIFICATION: return employeeRepository.findEmployeeBySpec(employee, SORT_CRITERIA);
            case EXAMPLE: return employeeRepository.findEmployeeByExample(employee, SORT_CRITERIA);
            case NAMED_QUERY: return employeeRepository.findEmployeeByNamedQuery(employee, SORT_CRITERIA);
            default: return new ArrayList<Employee>();
        }
    }

    public List<Employee> getByCompany(Integer companyId)
    {
        return employeeRepository.getByCompany(companyId, SORT_CRITERIA);
    }

    public void delete(Integer id)
    {
        employeeRepository.deleteById(id);
    }

    public Employee save(EmployeeDTO employeeDTO)
    {
        return employeeRepository.save(generateEmployeeFromDTO(employeeDTO, true));
    }

    private Employee generateEmployeeFromDTO(EmployeeDTO employeeDTO, boolean initializeStatus) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        if (initializeStatus) {
            employee.setStatus(EmployeeStatus.ACTIVE.getVal());
        }
        return employee;
    }
}
