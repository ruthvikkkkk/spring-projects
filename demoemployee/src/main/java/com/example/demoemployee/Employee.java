package com.example.demoemployee;

import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;

public class Employee {
    private String name;
    private int age;
    private String id;

    @OneToMany(cascade = CascadeType.ALL)
    ArrayList<Company> companyList;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(ArrayList<Company> companyList) {
        this.companyList = companyList;
    }



    @Override
    public String toString() {
        return "\nname : " +this.name + "\nage : " + this.age + "\nid : " + this.id + "\n";
    }
}
