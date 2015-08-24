package Chapter4;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@AttributeOverrides({
    @AttributeOverride(name="country", column=@Column(name="country"))/*,
    @AttributeOverride(name="name", column=@Column(name="name"))*/
})
public class Employee3 extends Person3 {

    private static final long serialVersionUID = 1L;
    private Double salary;
    private String department;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee3(String name, String country, Double salary, String department) {
        super(name, country);
        this.salary = salary;
        this.department = department;
    }
    
    public Employee3() {
        
    }

    @Override
    public String toString() {
        return "Employee [salary=" + salary + ", department=" + department + ", getId()=" + getId() + ", getName()="
                + getName() + ", getCountry()=" + getCountry() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
