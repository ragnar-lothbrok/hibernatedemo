package Chapter6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
    
    public Manager() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Manager(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manager [id=" + id + ", name=" + name + ", company=" + company + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
