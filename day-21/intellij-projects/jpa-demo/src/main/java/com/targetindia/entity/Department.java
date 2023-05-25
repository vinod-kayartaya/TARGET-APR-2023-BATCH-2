package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;

    // to represent the same, we can use an array of Collection (List or Set)
    @OneToMany // one department has many employees
    @JoinColumn(name="dept_id",
            foreignKey = @ForeignKey(
                    foreignKeyDefinition = "foreign key (dept_id) references departments(id) on delete cascade")) // foreign key in EMPLOYEES table
    private List<Employee> employees;

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
