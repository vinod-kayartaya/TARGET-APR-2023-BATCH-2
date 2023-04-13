package com.targetindia.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Student extends Person{
    private int rollno;
    private double gpa;

    public Student(int rollno, String firstname, String lastname, String email, String phone, double gpa) {
        // call to the super class constructor must be the first statement in a constructor
        super(firstname, lastname, email, phone);
        this.rollno = rollno;
        this.gpa = gpa;
    }

    public void print(){
        System.out.println("Student details");
        System.out.println("----------------------------");
        System.out.println("Roll no   : " + rollno);
        super.print();
        System.out.println("GPA       : " + gpa);
    }
}
