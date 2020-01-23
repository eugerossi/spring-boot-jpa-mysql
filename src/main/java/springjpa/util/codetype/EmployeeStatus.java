package springjpa.util.codetype;

public enum EmployeeStatus {
    INACTIVE(0),
    ACTIVE(1),
    DELETED(9);

    private Integer val;

    EmployeeStatus(Integer val)
    {
        this.val = val;
    }

    public Integer getVal()
    {
        return this.val;
    }
}
