package springjpa.service;

import springjpa.entity.Employee;
import springjpa.util.codetype.SearchType;
import springjpa.util.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    Employee get(Integer id);

    List<Employee> findByStatus(Integer status);

    List<Employee> findByExample(SearchType searchType, EmployeeDTO example);

    List<Employee> getByCompany(Integer companyId);

    void delete(Integer id);

    Employee save(EmployeeDTO employee);
}
