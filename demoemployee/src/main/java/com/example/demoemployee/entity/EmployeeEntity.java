package com.example.demoemployee.entity;

import com.example.demoemployee.Employee;

import javax.persistence.*;

@Entity
public class EmployeeEntity{

    //public static final String TABLE_NAME = "employeedb";
//    public static final String ID = "ID";
//    public static final String NAME = "NAME";
//    public static final String AGE = "AGE";
//    public static final String SEQ_GEN_ALIAS = "AGE";
//    public static final String SEQ_GEN_STRATEGY = "vivid2";

    @Id
    @Column
//    @GeneratedValue(generator = EmployeeEntity.SEQ_GEN_ALIAS)
//    //@SequenceGenerator(name = EmployeeEntity.SEQ_GEN_STRATEGY)
    String id;

    @Column
    private String name;

    @Column
    private int age;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "\nname : " +this.name + "\nage : " + this.age + "\nid : " + this.id + "\n";
    }
}
