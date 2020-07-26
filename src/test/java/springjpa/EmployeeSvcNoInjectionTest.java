package springjpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import springjpa.entity.Company;
import springjpa.repository.CompanyRepository;
import springjpa.service.impl.CompanyServiceImpl;
import springjpa.util.codetype.CompanyStatus;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeSvcNoInjectionTest {

    @Captor
    ArgumentCaptor argCaptor;
    @Mock
    private CompanyRepository companyRepository;
    private CompanyServiceImpl companyService;
    @Mock
    private List<Company> mockCompanies;

    @Before
    public void setUp() {
        // companyRepository = Mockito.mock(CompanyRepository.class); // In case we don't use @Mock
        companyService = new CompanyServiceImpl(companyRepository);
    }

    @Test
    public void getCompanyStatus() {
        // given
        Company company = new Company();
        company.setId(1);
        company.setStatus(0);
        when(companyRepository.findById(1)).thenReturn(Optional.of(company));

        // when
        Company companyResult = companyService.get(1);

        // then
        assertNotEquals(CompanyStatus.getDescriptionForVal(companyResult.getStatus()), "Active");
    }

    @Test
    public void verifyAddition() {
        // given
        Company company = new Company();
        company.setId(1);
        company.setName("Olx Cordoba");

        Company company2 = new Company();
        company2.setId(2);
        company2.setName("Rio Seguros");

        mockCompanies.addAll(Arrays.asList(company, company2));

        verify(mockCompanies).addAll((Collection<Company>) argCaptor.capture());

        // then
        assertEquals(Arrays.asList(company, company2), argCaptor.getValue());
    }
}
