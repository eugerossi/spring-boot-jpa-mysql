package springjpa.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import springjpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepository extends SimpleJpaRepository<Employee, Integer> {

    public EmployeeRepository(EntityManager em)
    {
        super(Employee.class, em);
    }

    private static Specification<Employee> statusSpec(Integer status)
    {
        return (root, query, cb) ->
                cb.equal(root.get(root.getModel().getSingularAttribute("status")), status);
    }

    public List<Employee> findByStatus(Integer status, Sort sortCriteria)
    {
        return findAll(statusSpec(status), sortCriteria);
    }

    private static Specification<Employee> employeeSpec(Employee example)
    {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<>();

                if (example.getStatus() != null)
                {
                    predicates.add(cb.equal(root.get("status"), example.getStatus()));
                }

                if (!StringUtils.isBlank(example.getFirstName()))
                {
                    predicates.add(cb.like(cb.lower(root.get("firstName")), "%" + example.getFirstName().toLowerCase() + "%"));
                }

                if (!StringUtils.isBlank(example.getLastName()))
                {
                    predicates.add(cb.like(cb.lower(root.get("lastName")), "%" + example.getLastName().toLowerCase() + "%"));
                }

                Predicate equalPredicate = cb.and(predicates.toArray(new Predicate[0]));
                return equalPredicate;
            }
        };
    }

    public List<Employee> findEmployeeBySpec(Employee example, Sort sortCriteria)
    {
        return findAll(employeeSpec(example), sortCriteria);
    }

    public List<Employee> findEmployeeByExample(Employee employee, Sort sortCriteria)
    {
        Example employeeExample = Example.of(employee, ExampleMatcher.matchingAll().withIgnoreCase()
                .withIgnoreNullValues()
                /* Criteria for a specific property
                .withMatcher("lastName",
                        //can be replaced with lambda
                        new ExampleMatcher.MatcherConfigurer<ExampleMatcher.GenericPropertyMatcher>() {
                            @Override
                            public void configureMatcher(ExampleMatcher.GenericPropertyMatcher matcher) {
                                matcher.contains();
                            }
                        })*/
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return findAll(employeeExample, sortCriteria);
    }

    public List<Employee> findEmployeeByNamedQuery(Employee example, Sort sortCriteria)
    {
        return findAll(employeeSpec(example), sortCriteria);
    }

    private static Specification<Employee> companySpec(Integer companyId)
    {
        return (root, query, cb) ->
        {
            return companyId == null ? null : cb.equal(root.join("company").get("id"), companyId);
        };
    }

    public List<Employee> getByCompany(Integer companyId, Sort sortCriteria)
    {
        return findAll(companySpec(companyId), sortCriteria);
    }
}

