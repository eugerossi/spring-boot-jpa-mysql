package springjpa.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springjpa.entity.Employee;
import springjpa.entity.EmployeeNames;
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
    @ApiOperation(value = "Gets an Employee from DB", notes = "Returns an Employee given its Id")
    public EmployeeDTO getEmployeeParam(@RequestParam int id){
        System.out.println("WS Called with id " + id);
        return new EmployeeDTO(employeeService.get(id));
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeePath(@PathVariable int id) {
        System.out.println("WS Called with id " + id);
        return employeeService.get(id);
    }

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody EmployeeDTO example) {
        System.out.println("WS saveEmployee called with object " + example.toString());
        return employeeService.save(example);
    }

    @DeleteMapping("/")
    public void deleteEmployee(@RequestParam int id) {
        System.out.println("WS deleteEmployee called with id " + id);
        employeeService.delete(id);
    }

    @GetMapping("/list")
    public List<Employee> getEmployees(@RequestParam(required = false) Integer status) {
        return employeeService.findByStatus(status);
    }

    @GetMapping("/list/company")
    public List<Employee> getEmployeesByCompany(@RequestParam Integer companyId) {
        return employeeService.getByCompany(companyId);
    }

    @PostMapping("/list/spec")
    public List<Employee> getEmployeesBySpec(@RequestBody EmployeeDTO example){
        System.out.println("WS getEmployeesByExample called with object "+example.toString());
        return employeeService.findByExample(SearchType.SPECIFICATION, example);
    }

//    @GetMapping("/list/projection")
//    public List<EmployeeNames> getEmployeeNames(){
//        System.out.println("WS getEmployeeNames");
//        return employeeService.getEmployeeNames();
//    }

    @PostMapping("/list/example")
    public List<Employee> getEmployeesByExample(@RequestBody EmployeeDTO example){
        System.out.println("WS getEmployeesByExample called with object "+example.toString());
        return employeeService.findByExample(SearchType.EXAMPLE, example);
    }

    @PostMapping("/list/namedquery")
    public List<Employee> getEmployeesByNamedQuery(@RequestBody EmployeeDTO example){
        System.out.println("WS getEmployeesByExampleNamedQuery called with object "+example.toString());
        return employeeService.findByExample(SearchType.NAMED_QUERY, example);
    }
}
