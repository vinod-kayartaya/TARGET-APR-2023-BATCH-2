package com.targetindia.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee { // not implementing Comparable on purpose
    private int id;
    private String name;
    private double salary;
}
