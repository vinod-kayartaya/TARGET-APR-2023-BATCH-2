package com.targetindia.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public void print(){
        System.out.println("Name      : " + firstname + " " + lastname);
        System.out.println("Email     : " + email);
        System.out.println("Phone     : " + phone);
    }
}
