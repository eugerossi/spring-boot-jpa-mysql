package springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springjpa.entity.Company;
import springjpa.service.CompanyService;
import springjpa.util.codetype.SearchType;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public Company getECompanyParam(@RequestParam int id) {
        System.out.println("WS Called with id " + id);
        return companyService.get(id);
    }

    @GetMapping("/list")
    public List<Company> getCompanies(@RequestParam(required = false) Integer status)
    {
        return companyService.findByStatus(status);
    }

    @GetMapping("/list/method")
    public List<Company> getCompanyByNameMethod(@RequestParam String name){
        System.out.println("WS getCompanyByNameMethod called with value "+name);
        return companyService.findByName(SearchType.METHOD_NAME,name);
    }

    @GetMapping("/list/query")
    public List<Company> getCompanyByNameQuery(@RequestParam String name){
        System.out.println("WS getCompanyByNameQuery called with value "+name);
        return companyService.findByName(SearchType.QUERY_ANNOTATION, name);
    }

    @GetMapping("/list/namedquery")
    public List<Company> getCompanyByNameNamedQuery(@RequestParam String name){
        System.out.println("WS getCompanyByNameNamedQuery called with value "+name);
        return companyService.findByName(SearchType.NAMED_QUERY, name);
    }
}
