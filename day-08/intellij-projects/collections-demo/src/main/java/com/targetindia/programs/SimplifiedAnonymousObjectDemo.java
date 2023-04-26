package com.targetindia.programs;

import com.targetindia.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class SimplifiedAnonymousObjectDemo {
    public static void main(String[] args) {

        Set<Employee> emps = new TreeSet<>(new Comparator<>(){
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getSalary() < e2.getSalary() ? -1 : 1;
            }
        }); // supply an object of Comparator
        emps.add(new Employee(1234, "John Doe", 3400));
        emps.add(new Employee(2334, "Lisa Smith", 4200));
        emps.add(new Employee(1312, "Sandra dae", 1900));
        emps.add(new Employee(5467, "John Jacob", 1900));
        emps.add(new Employee(7654, "Robert Martin", 3300));
        emps.add(new Employee(7788, "Sam Joe", 1900));

        for (Employee e : emps) {
            log.trace("employee {}", e);
        }
    }
}
