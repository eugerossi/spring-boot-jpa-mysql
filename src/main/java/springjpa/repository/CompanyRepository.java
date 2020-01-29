package springjpa.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springjpa.entity.Company;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("SELECT c FROM Company c WHERE :status IS NULL OR c.status = :status")
    List<Company> findByStatus(Sort sort, Integer status);

    // It will try to match the value from bo property
    List<Company> findByName(Sort sort, String name);

    @Query("SELECT c FROM Company c WHERE c.name like %:name%")
    List<Company> findByNameQuery(Sort sort, String name);

    // Using a namedQuery defined on Company class
    List<Company> findByNameNamedQuery(String name);
}

