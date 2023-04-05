package com.example.restemployee.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Entity
public class Employee {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private Double fixedSalary;
    private Double variablePay;
    private Double internshipAmount;

    @ManyToOne
    @JoinColumn(name = "office_address_id", referencedColumnName = "id")
    private Address officeAddressId;

    @ManyToOne
    @JoinColumn(name = "home_address_id", referencedColumnName = "id")
    private Address homeAddressId;

    @ManyToMany
    @JoinTable(name="employee_dependent", joinColumns = {
            @JoinColumn(name = "employee_id")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "dependent_id")
            })
    private List<Dependant> dependants;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public Double getVariablePay() {
        return variablePay;
    }

    public void setVariablePay(Double variablePay) {
        this.variablePay = variablePay;
    }

    public Double getInternshipAmount() {
        return internshipAmount;
    }

    public void setInternshipAmount(Double internshipAmount) {
        this.internshipAmount = internshipAmount;
    }

    public Address getOfficeAddressId() {
        return officeAddressId;
    }

    public void setOfficeAddressId(Address officeAddressId) {
        this.officeAddressId = officeAddressId;
    }

    public Address getHomeAddressId() {
        return homeAddressId;
    }

    public void setHomeAddressId(Address homeAddressId) {
        this.homeAddressId = homeAddressId;
    }
}
