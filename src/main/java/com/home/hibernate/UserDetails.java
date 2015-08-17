package com.home.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "userdetails")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "gender")
    private String gender;

    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "country", column = @Column(name = "homeCountry")) , @AttributeOverride(name = "mobile", column = @Column(name = "homeMobileNumber")) })
    private Address homeAddress;

    @Embedded
    private Address officeAddress;

    public Address getHomeAddress() {
        return homeAddress;
    }

    @Override
    public String toString() {
        return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
                + ", profileImage=" + profileImage + ", gender=" + gender + ", homeAddress=" + homeAddress
                + ", officeAddress=" + officeAddress + ", createDate=" + createDate + ", modifyDate=" + modifyDate
                + "]";
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date", nullable = false, updatable = false)
    private Date modifyDate;

    public Date getCreateDate() {
        return (createDate = new Date());
    }

    public void setCreateDate(Date createDate) {
        this.createDate = new Date();
    }

    public Date getModifyDate() {
        return modifyDate = new Date();
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = new Date();
    }

}
