package springjpa.util.codetype;

public enum CompanyStatus {
    INACTIVE(0, "Inactive"),
    ACTIVE(1, "Active");

    private Integer val;
    private String description;

    CompanyStatus(Integer val, String description)
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
        for (CompanyStatus status : CompanyStatus.values()) {
            if (status.getVal().equals(val)) {
                return status.description;
            }
        }
        return "Unknown";
    }
}
