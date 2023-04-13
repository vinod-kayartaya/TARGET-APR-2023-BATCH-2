package com.targetindia.programs;

import com.targetindia.model.Person;

public class ClassObjectDemo {

    public static void main(String[] args) {

        Person p1; // reference variable; not referring to any object currently

        // creating an object
        p1 = new Person();
        System.out.println(p1);

        p1 = new Person("Vinod", 49);
        System.out.println(p1);

    }
}
