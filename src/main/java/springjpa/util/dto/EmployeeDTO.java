package springjpa.util.dto;

public class EmployeeDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer status;
    private Integer companyId;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setCompanyId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmployeeDTO: id: ").append(this.id)
                .append(", firstName: ").append(this.firstName)
                .append(", lastName: ").append(this.lastName)
                .append(", company: ").append(this.companyId);
        return sb.toString();
    }
}
