package com.home.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(name = "country")
    private String country;

    @Column(name = "mobileNumber")
    private Long mobile;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Address [country=" + country + ", mobile=" + mobile + "]";
    }

}
