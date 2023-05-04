package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private String name;
    private String email;
    private Date dob;

    static final long serialVersionUID = 1L;

    public void print(){
        System.out.printf("Name         : %s%n", name);
        System.out.printf("Email        : %s%n", email);
        System.out.printf("D.O.B        : %s%n", dob);
    }
}
