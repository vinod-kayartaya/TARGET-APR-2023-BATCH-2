package com.targetindia.programs;

import java.sql.DriverManager;

public class ListAvailableDrivers {
    public static void main(String[] args) {
        System.out.println("Available drivers are: ");
        System.out.println("----------------------");
        DriverManager
                .drivers() // stream of Driver
                .map(Object::getClass) // stream of Class
                .map(Class::getName) // stream of String
                .forEach(System.out::println);
        System.out.println("----------------------");
    }
}
