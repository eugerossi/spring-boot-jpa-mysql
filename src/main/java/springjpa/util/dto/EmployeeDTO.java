package springjpa.util.dto;

import springjpa.entity.Employee;
import springjpa.util.codetype.EmployeeStatus;

public class EmployeeDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer status;
    private String statusDesc;
    private String address;
    private String city;
    private Integer companyId;
    private String companyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCompanyId() {
        return id;
    }

    public void setCompanyId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmployeeDTO: id: ").append(this.id)
                .append(", firstName: ").append(this.firstName)
                .append(", lastName: ").append(this.lastName)
                .append(", company: ").append(this.companyId);
        return sb.toString();
    }

    public EmployeeDTO(Employee employee)
    {
        if (employee != null)
        {
            this.id = employee.getId();
            this.firstName = employee.getFirstName();
            this.lastName = employee.getLastName();
            this.status = employee.getStatus();
            this.statusDesc = EmployeeStatus.getDescriptionForVal(employee.getStatus());
            this.address = employee.getAddress();
            this.city = employee.getCity();
            this.companyId = employee.getCompany().getId();
            this.companyName = employee.getCompany().getName();
        }
    }
}
