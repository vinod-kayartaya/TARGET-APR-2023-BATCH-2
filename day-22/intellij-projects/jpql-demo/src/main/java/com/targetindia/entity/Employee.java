package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    private String title;
    @Column(name = "title_of_courtesy")
    private String titleOfCourtesy;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "hire_date")
    private Date hireDate;

    @Embedded
    private Address address;

    @Column(name = "home_phone")
    private String homePhone;
    private String extension;
    private byte[] photo;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "reports_to")
    private Employee manager;


}
