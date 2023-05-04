package com.targetindia.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Employee extends Person { // implements Serializable {
    static final long serialVersionUID = 1L;

    private int id;
    private double salary;

    public Employee(int id, String name, String email, Date dob, double salary) {
        super(name, email, dob);
        this.id = id;
        this.salary = salary;
    }

    public void print(){
        System.out.printf("ID           : %s%n", id);
        super.print();
        System.out.printf("Salary       : %s%n", salary);
        line();

    }

    public static void line(){
        for(int i=0; i<80; i++){
            System.out.printf("-");
        }
        System.out.println();
    }
}
