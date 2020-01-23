package springjpa.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import springjpa.bo.Company;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyRepository extends SimpleJpaRepository<Company, Integer> {

    public CompanyRepository(EntityManager em)
    {
        super(Company.class, em);
    }

    @Deprecated
    private static Specification<Company> statusSpec(Integer status)
    {
        return (root, query, cb) ->
                cb.equal(root.get(root.getModel().getSingularAttribute("status")), status);
    }

    private static Specification<Company> nullableStatusSpec(Integer status)
    {
        return (root, query, cb) ->
        {
            return status == null ? null : cb.equal(root.get(root.getModel().getSingularAttribute("status")), status);
        };
    }

    public List<Company> findByStatus(Integer status)
    {
        return findAll(nullableStatusSpec(status), Sort.by(Sort.Direction.ASC, "name"));
    }


    private static Specification<Company> companyExampleSpec(Company example)
    {
        return new Specification<Company>() {
            @Override
            public Predicate toPredicate(Root<Company> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<>();

                if (example.getStatus() != null)
                {
                    predicates.add(cb.equal(root.get("status"), example.getStatus()));
                }

                if (StringUtils.isBlank(example.getName()))
                {
                    predicates.add(cb.like(cb.lower(root.get("name")), "%" + example.getName().toLowerCase() + "%"));
                }

                Predicate equalPredicate = cb.and(predicates.toArray(new Predicate[0]));
                return equalPredicate;
            }
        };
    }

    public List<Company> findByExample(Company example)
    {
        return findAll(companyExampleSpec(example), Sort.by(Sort.Direction.ASC, "name"));
    }
}

