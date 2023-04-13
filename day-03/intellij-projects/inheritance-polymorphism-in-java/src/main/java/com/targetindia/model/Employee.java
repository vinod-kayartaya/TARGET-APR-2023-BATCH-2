package com.targetindia.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Employee extends Person{
    private int id;
    private double salary;
    private String dept;

    public void print(){
        System.out.println("Employee details");
        System.out.println("----------------------------");
        System.out.println("ID        : " + id);
        super.print();
        System.out.println("Salary    : Rs." + salary);
        System.out.println("Department: " + dept);
    }
}
