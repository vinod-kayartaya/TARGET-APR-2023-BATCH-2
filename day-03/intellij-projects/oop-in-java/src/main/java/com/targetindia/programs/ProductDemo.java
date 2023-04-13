package com.targetindia.programs;

import com.targetindia.model.Product;

public class ProductDemo {
    public static void main(String[] args) {

        Product p1, p2, p3;

        p1 = new Product();
        p2 = new Product(112, "Samsung Monitor", 4500.0);
        p3 = new Product("Apple magic mouse", 8450);

        // initialize the member variables of p1 after the construction is done
        // cannot access the private members; use the setters
        p1.setId(987);
        p1.setName("Apple airpods");
        p1.setUnitPrice(12500);

        p3.setId(728);

        System.out.println(p2.getName() + " costs Rs." + p2.getUnitPrice());
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

    }
}
