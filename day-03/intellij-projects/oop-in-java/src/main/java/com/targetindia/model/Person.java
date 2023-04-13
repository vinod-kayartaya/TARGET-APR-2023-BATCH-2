package com.targetindia.model;

public class Person {
    private String name; // 8 bytes (since it is a reference)
    private int age; // 4 bytes
    private Address address; // aggregation

    public Person(){
        name = "Unknown";
        age = 20;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // this function returns a textual representation of the object.
    // this function overrides the inherited function from the java.lang.Object class
    public String toString(){
        return "Person(name=\"" + name + "\", age=" + age+")";
    }
}
