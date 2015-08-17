package com.home.hibernate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "addressdetails")
public class AddressDetail {

    @EmbeddedId
    private Address address;
    
    @Version
    @Column(name="version")
    private Long version;

    @Column(name = "street")
    private String street;

    @Column(name = "pincode")
    private Integer pincode;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "AddressDetail [address=" + address + ", street=" + street + ", pincode=" + pincode + "]";
    }

}
