package springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springjpa.entity.Employee;
import springjpa.service.EmployeeService;
import springjpa.util.codetype.SearchType;
import springjpa.util.dto.EmployeeDTO;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    @ResponseBody
    public Employee getEmployeeParam(@RequestParam int id){
        System.out.println("WS Called with id "+id);
        return employeeService.get(id);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Employee getEmployeePath(@PathVariable int id){
        System.out.println("WS Called with id "+id);
        return employeeService.get(id);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Employee> getEmployees(@RequestParam(required = false) Integer status){
        return employeeService.findByStatus(status);
    }

    @GetMapping("/list/company")
    @ResponseBody
    public List<Employee> getEmployeesByCompany(@RequestParam Integer companyId){
        return employeeService.getByCompany(companyId);
    }

    @PostMapping("/list/spec")
    @ResponseBody
    public List<Employee> getEmployeesBySpec(@RequestBody EmployeeDTO example){
        System.out.println("WS getEmployeesByExample called with object "+example.toString());
        return employeeService.findByExample(SearchType.SPECIFICATION, example);
    }

    @PostMapping("/list/example")
    @ResponseBody
    public List<Employee> getEmployeesByExample(@RequestBody EmployeeDTO example){
        System.out.println("WS getEmployeesByExample called with object "+example.toString());
        return employeeService.findByExample(SearchType.EXAMPLE, example);
    }

    @PostMapping("/list/namedquery")
    @ResponseBody
    public List<Employee> getEmployeesByNamedQuery(@RequestBody EmployeeDTO example){
        System.out.println("WS getEmployeesByExampleNamedQuery called with object "+example.toString());
        return employeeService.findByExample(SearchType.NAMED_QUERY, example);
    }
}
