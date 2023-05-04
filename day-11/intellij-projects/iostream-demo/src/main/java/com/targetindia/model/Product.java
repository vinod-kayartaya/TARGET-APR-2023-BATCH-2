package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    // an object of this class is an instance of the following types:
    // 1. com.targetindia.model.Product
    // 2. java.lang.Object
    // 3. java.io.Serializable

    private int id;             // 4
    private String name;        // 8
    private String category;    // 8
    private double price;       // 8

}
