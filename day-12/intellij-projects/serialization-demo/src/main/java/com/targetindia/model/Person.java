package com.targetindia.model;

import com.targetindia.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Person implements Serializable {
    static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private Date dob;
    transient private Address address = new Address();

    public Person(String name, String email, Date dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public void print() {
        System.out.printf("Name         : %s%n", name);
        System.out.printf("Email        : %s%n", email);
        System.out.printf("D.O.B        : %s%n", DateUtil.toString(dob));
        if(address!=null) {
            System.out.println("Address      : ");
            System.out.printf("               %s%n", address.getHouseStreet());
            System.out.printf("               %s%n", address.getArea());
            System.out.printf("               %s%n", address.getCity());
        }

    }
}
