package com.targetindia.model;

import lombok.*;

@Data // @Getter, @Setter, @EqualsAndHashCode, @NoArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private double salary;
    private String dept;

    // we can still create our own constructors as well
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
