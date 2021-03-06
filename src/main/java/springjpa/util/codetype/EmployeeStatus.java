package springjpa.util.codetype;

public enum EmployeeStatus {
    INACTIVE(0, "Inactive"),
    ACTIVE(1, "Active"),
    DELETED(2, "Staged");

    private Integer val;
    private String description;

    EmployeeStatus(Integer val, String description)
    {
        this.val = val;
        this.description = description;
    }

    public Integer getVal()
    {
        return this.val;
    }

    public String getDescription() {
        return this.description;
    }

    public static String getDescriptionForVal(Integer val)
    {
        for (EmployeeStatus status : EmployeeStatus.values()) {
            if (status.getVal().equals(val)) {
                return status.description;
            }
        }
        return "Unknown";
    }
}
