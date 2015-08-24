package Chapter3;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@PrimaryKeyJoinColumn(name="id")
public class Employee2 extends Person2 {

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

    public Employee2(String name, String country, Double salary, String department) {
        super(name, country);
        this.salary = salary;
        this.department = department;
    }
    
    public Employee2() {
        
    }

    @Override
    public String toString() {
        return "Employee [salary=" + salary + ", department=" + department + ", getId()=" + getId() + ", getName()="
                + getName() + ", getCountry()=" + getCountry() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
