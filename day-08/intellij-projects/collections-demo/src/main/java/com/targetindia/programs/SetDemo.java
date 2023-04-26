package com.targetindia.programs;

import com.targetindia.model.Product;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class SetDemo {
    public static void main(String[] args) {
        Set<String> names = new LinkedHashSet<>();
        names.add("Vinod");
        names.add("Shyam");
        names.add("Kishore");
        names.add("Kiran");
        names.add("Shyam");
        names.add("Kishore");
        names.add("Anand");
        names.add("Shyam");
        names.add("Kishore");
        names.add("Arun");
        log.trace("names contains: {}", names);

        Set<Product> productSet = new TreeSet<>();
        productSet.add(new Product(1, "Dell optical mouse", 789));
        productSet.add(new Product(2, "Lenovo thinkpad", 127089));
        productSet.add(new Product(3, "Apple magic mouse", 8500));
        productSet.add(new Product(1, "Dell optical mouse", 789));
        productSet.add(new Product(1, "Dell optical mouse", 789));
        productSet.add(new Product(2, "Lenovo thinkpad", 127089));
        productSet.add(new Product(2, "Dell laptop", 178000));
        productSet.add(new Product(3, "Apple magic mouse", 8500));
        productSet.add(new Product(3, "Apple pencil", 8500));
        productSet.add(new Product(3, "Apple magic mouse", 8500));
        productSet.add(new Product(3, "Apple magic mouse", 6500));
        productSet.add(new Product(3, "Apple magic mouse", 6500));
        productSet.add(new Product(3, "Apple magic mouse", 6500));
        productSet.add(new Product(3, "Apple magic mouse", 6500));
        productSet.add(new Product(3, "Apple magic mouse", 6500));

        for(Product p: productSet){
            log.trace("product is {} with hashCode {}", p, p.hashCode());
        }
    }
}
