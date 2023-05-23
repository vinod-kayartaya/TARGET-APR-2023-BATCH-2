package com.targetindia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Integer id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    private String gender;
    private String email;
    private String phone;
}
