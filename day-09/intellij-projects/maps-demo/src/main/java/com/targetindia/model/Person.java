package com.targetindia.model;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String city;
    private Date birthDate;
}
