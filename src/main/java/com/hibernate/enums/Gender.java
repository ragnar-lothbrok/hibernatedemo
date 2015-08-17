package com.hibernate.enums;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gender_info")
public enum Gender {
    MALE, FEMALE;
    
    @Id
    public String name = toString();
}
