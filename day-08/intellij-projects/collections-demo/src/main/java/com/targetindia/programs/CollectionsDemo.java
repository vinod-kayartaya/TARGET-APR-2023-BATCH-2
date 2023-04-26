package com.targetindia.programs;

import com.targetindia.model.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class CollectionsDemo {
    public static void main(String[] args) {
        Integer[] nums = {39, 58, 29, 58, 283, 85, 69, 62, 382, 586, 344, 63};

        // to sort this array, simply call the method from Arrays class
        Arrays.sort(nums);
        log.trace("nums is " + Arrays.toString(nums));


        Arrays.<Integer>sort(nums, (a, b)->b-a);
        log.trace("nums is " + Arrays.toString(nums));

        List<Employee> emps = Arrays.asList(
                new Employee(112, "John", 2200),
                new Employee(231, "Jane", 3923),
                new Employee(343, "Jacob", 2999)
        );

        Collections.<Employee>sort(emps, (e1, e2)->Double.compare(e2.getSalary(), e1.getSalary()));
        for(Employee e: emps){
            log.trace("emp {}", e);
        }
    }
}
