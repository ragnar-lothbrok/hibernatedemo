package com.home.hibernate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "addressdetails")
@NamedQueries({@NamedQuery(name="GETALLADDRESS",query="from AddressDetail")})
@NamedNativeQueries({@NamedNativeQuery(name="GETALLADDRESSNATIVE",query="select * from addressdetails"),@NamedNativeQuery(name="GETSTREETADDRESSNATIVE",query="select street,version from addressdetails")})
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="addressDetail")
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
