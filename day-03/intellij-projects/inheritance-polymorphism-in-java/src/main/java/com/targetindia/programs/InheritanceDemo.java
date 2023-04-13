package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.model.Person;
import com.targetindia.model.Student;

public class InheritanceDemo {

    public static void main(String[] args) {

        Employee e1;

        e1 = new Employee();
        e1.setId(1122);
        e1.setFirstname("John");
        e1.setLastname("Scott");
        e1.setSalary(5000);
        e1.setDept("ADMIN");
        e1.setEmail("john.scott@xmpl.com");
        e1.setPhone("555-726-3372");

        Student s1 = new Student(9123, "Ramesh", "Kumar", "ramesh.kumar@xmpl.com", "97648112345", 3.8);

        System.out.println(e1);
        System.out.println(s1);

        // Student IS-A Person
        // Employee IS-A Person

        Person p1;
        p1 = e1; // LHS is a reference of a Person type; RHS is reference of an Employee, who IS-A Person
        // System.out.println("Person is: " + p1.toString()); // p1 is a reference of Person; it currently refers to an object of Employee
        // in the above statement, p1.toString() is called, but will it be called from Person or Employee?
        p1.print(); // compiler checks that "print()" is available in the datatype of p1, which is Person
                    // at the runtime, p1 is nothing but e1, and hence the print() is taken from Employee
        System.out.println();
        p1 = s1; // LHS is a reference of a Person type; RHS is reference of a Student, who IS-A Person
        // System.out.println("Person is: " + p1.toString()); // p1 is a reference of Person; it currently refers to an object of Student
        // in the above statement, p1.toString() is called, but will it be called from Person or Student?
        p1.print();

    }
}
