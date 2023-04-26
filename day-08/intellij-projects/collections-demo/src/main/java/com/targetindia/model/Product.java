package com.targetindia.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode // required by HashSet, HashMap, Hashtable, LinkedHashSet, LinkedHashMap
public class Product implements Comparable<Product> { // required by TreeSet and TreeMap
    private int id;
    private String name;
    private double price;

    // defines the natural ordering for objects of this class
    @Override
    public int compareTo(Product other) {
        // 'this' corresponds to the invoking object
        // 'other' is the parameter Product object
        int result = this.id - other.id;
        if (result != 0) return result;

        result = this.name.compareTo(other.name);
        if (result != 0) return result;

        return Double.compare(this.price, other.price);
    }
}
