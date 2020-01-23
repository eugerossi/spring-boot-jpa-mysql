package springjpa.service;

import springjpa.bo.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findByStatus(Integer status);
}
