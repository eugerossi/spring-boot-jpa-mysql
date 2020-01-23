package springjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springjpa.entity.Company;
import springjpa.entity.Employee;
import springjpa.repository.CompanyRepository;
import springjpa.service.CompanyService;
import springjpa.util.codetype.SearchType;
import springjpa.util.exception.CompanyNotFoundException;
import springjpa.util.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;


@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    private static final Sort SORT_CRITERIA = Sort.by(Sort.Direction.ASC, new String[]{"lastName","firstName"});

    @Autowired
    private CompanyRepository companyRepository;

    public Company get(Integer id) {
        return companyRepository.findById(id).orElseThrow(
                () -> new CompanyNotFoundException(id)
        );
    }

    public List<Company> findByStatus(Integer status)
    {
        return companyRepository.findByStatus(status);
    }

    public List<Company> findByName(SearchType searchType, String name)
    {
        switch (searchType)
        {
            case METHOD_NAME: return companyRepository.findByName(name);
            case QUERY_ANNOTATION: return companyRepository.findByNameQuery(name);
            case NAMED_QUERY: return companyRepository.findByNameNamedQuery(name);
            default: return new ArrayList<Company>();
        }
    }

}
