package com.targetindia.entity;

import com.targetindia.exceptions.BlankNameException;
import com.targetindia.exceptions.InvalidIdException;
import com.targetindia.exceptions.LowSalaryException;
import com.targetindia.exceptions.NullNameException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Employee {
    private int id;
    private String name;
    private double salary;

    public void setId(int id) throws InvalidIdException {
        if (id <= 0) {
            throw new InvalidIdException(id + " is an invalid value for employee id");
        }
        this.id = id;
    }

    public void setName(String name) throws NullNameException, BlankNameException {
        if (name == null) {
            throw new NullNameException("Name cannot be null");
        }
        if (name.isBlank()) {
            throw new BlankNameException("Name cannot be blank");
        }
        this.name = name;
    }

    public void setSalary(double salary) throws LowSalaryException {
        if (salary < 35000) {
            throw new LowSalaryException("Salary must be >= Rs.35000.0");
        }
        this.salary = salary;
    }
}
