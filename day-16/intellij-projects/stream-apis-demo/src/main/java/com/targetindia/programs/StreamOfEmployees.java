package com.targetindia.programs;

import com.targetindia.model.Employee;

public class StreamOfEmployees {
    static void line(){
        for(int i=0; i<80; i++){
            System.out.printf("-");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Employee.getDummyList()
                .stream()
                .forEach(System.out::println);

        line();

        Employee.getDummyList()
                .stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        line();

        Employee.getDummyList()
                .stream()
                .filter(e->e.getDepartment().equalsIgnoreCase("human resources"))
                .forEach(e-> System.out.printf("%s earns $%.2f%n", e.getName(), e.getSalary()));
        line();
        System.out.println("Employee with max salary: ");
        Employee.getDummyList()
                .stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .ifPresent(System.out::println);

        line();
        System.out.println("Employee in descending order of salary: ");
        Employee.getDummyList()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e-> System.out.printf("%s earns $%.2f%n", e.getName(), e.getSalary()));
    }
}
