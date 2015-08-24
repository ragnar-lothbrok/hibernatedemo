package Chapter3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person2(String name, String country) {
        super();
        this.name = name;
        this.country = country;
    }
    
    public Person2() {
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", country=" + country + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
