package springjpa;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springjpa.entity.Country;
import springjpa.entity.Employee;
import springjpa.repository.EmployeeRepository;
import springjpa.service.impl.EmployeeServiceImpl;
import springjpa.util.codetype.EmployeeStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeSvcInjectionJupiterTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void getEmployeeStatus() {
        // given
        Employee employee = new Employee();
        employee.setId(1);
        employee.setStatus(1);
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        // when
        Employee employeeResult = employeeService.get(1);

        // then
        assertEquals(EmployeeStatus.getDescriptionForVal(employeeResult.getStatus()), "Active");
    }

    @Test
    void getForeignEmployees() {
        // given
        Country argentina = new Country(1, "Argentina");
        Country chile = new Country(2, "Chile");

        List<Employee> mockEmployees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setCountry(argentina);

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setCountry(chile);

        mockEmployees.addAll(Arrays.asList(employee, employee2));

        doReturn(mockEmployees).when(employeeRepository).findAll();

        // when
        List<Employee> employeeResults = employeeService.getForeignEmployees();

        // then
        assert employeeResults.size() == 1;
    }

    @Test
    @Disabled
    void disabledTestExample() {
        // No longer valid
    }

    @DisplayName("Sum first two values to get the third one") // Name for test
    @ParameterizedTest(name = "{0} + {1} = {2}") // Name on sub test (based on Csv)
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        assertEquals(expectedResult, Math.addExact(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

}
