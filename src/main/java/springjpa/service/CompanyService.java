package springjpa.service;

import springjpa.entity.Company;
import springjpa.util.codetype.SearchType;

import java.util.List;

public interface CompanyService {

    Company get(Integer id);

    List<Company> findByStatus(Integer status);

    List<Company> findByName(SearchType searchType, String name);
}
