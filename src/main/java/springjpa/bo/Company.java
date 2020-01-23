package springjpa.bo;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "STATUS", nullable = false)
    private Integer status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
