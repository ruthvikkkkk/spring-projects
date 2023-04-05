package com.example.restemployee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Address {

    @Id
    private Integer id;
    private String lineNumber1;
    private String lineNumber2;
    private String zipCode;
    private String state;
    private String city;
    private String country;
    private String addressType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineNumber1() {
        return lineNumber1;
    }

    public void setLineNumber1(String lineNumber1) {
        this.lineNumber1 = lineNumber1;
    }

    public String getLineNumber2() {
        return lineNumber2;
    }

    public void setLineNumber2(String lineNumber2) {
        this.lineNumber2 = lineNumber2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}
