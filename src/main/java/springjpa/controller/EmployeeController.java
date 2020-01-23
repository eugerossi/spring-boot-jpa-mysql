package springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springjpa.bo.Employee;
import springjpa.service.EmployeeService;

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

    @GetMapping("/list/match")
    @ResponseBody
    public List<Employee> getEmployeeByLastNameSimple(@RequestParam String lastName){
        System.out.println("WS Called with name "+lastName);
        return employeeService.findByLastName(lastName);
    }

    @GetMapping("/list/query")
    @ResponseBody
    public List<Employee> getEmployeeByLastNameQuery(@RequestParam String lastName){
        System.out.println("WS Called with name "+lastName);
        return employeeService.findByLastNameQuery(lastName);
    }

    @GetMapping("/list/namedquery")
    @ResponseBody
    public List<Employee> getEmployeeByLastNameNamedQuery(@RequestParam String lastName){
        System.out.println("WS Called with name "+lastName);
        return employeeService.findByLastNameNamedQuery(lastName);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }
}
