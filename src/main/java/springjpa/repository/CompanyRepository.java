package springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springjpa.entity.Company;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("SELECT c FROM Company c WHERE :status IS NULL OR c.status = :status ORDER BY status")
    public List<Company> findByStatus(Integer status);

    // It will try to match the value from bo property
    public List<Company> findByName(String name);

    @Query("SELECT c FROM Company c WHERE c.name like %:name%")
    public List<Company> findByNameQuery(String name);

    // Using a namedQuery defined on Employee class
    public List<Company> findByNameNamedQuery(String name);
}

