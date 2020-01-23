package springjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springjpa.bo.Company;
import springjpa.repository.CompanyRepository;
import springjpa.service.CompanyService;

import java.util.List;


@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findByStatus(Integer status)
    {
        return companyRepository.findByStatus(status);
    }

}
