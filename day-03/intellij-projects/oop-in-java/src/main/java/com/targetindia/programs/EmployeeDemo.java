package com.targetindia.programs;

import com.targetindia.model.Employee;

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1, e2;

        e1 = new Employee();
        e2 = new Employee(7896, "John Doe", 4500, "Admin");

        System.out.println(e1);
        System.out.println(e2);

    }

}
