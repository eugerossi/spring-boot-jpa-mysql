package springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springjpa.bo.Company;
import springjpa.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    @ResponseBody
    public List<Company> getCompanies(@RequestParam(required = false) Integer status)
    {
        return companyService.findByStatus(status);
    }
}
