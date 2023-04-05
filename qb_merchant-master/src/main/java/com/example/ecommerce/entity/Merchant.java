package com.example.ecommerce.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table(name = "merchant")
@Entity
@Data
@ToString
public class Merchant {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer id;
    @Column(unique = true)
    private String merchantId;
    private String name;
    private String username;
    private String password;
//    private String confirmPassword;
    private String email;
    private String address;
    private String phoneNumber;
    private int rating;
    private boolean deleteStatus;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
}
