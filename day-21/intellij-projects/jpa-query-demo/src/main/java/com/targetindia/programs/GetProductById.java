package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetProductById {
    public static void main(String[] args) {
        try (
                EntityManager em = JpaUtil.createEnitytManager();
        ) {
            int id = KeyboardUtil.getInt("Enter product id to search: ");
            Product p = em.find(Product.class, id);


            if (p == null) {
                System.out.println("No such product!");
                return;
            }
            System.out.printf("Name     : %s%n", p.getProductName());
            System.out.printf("Price    : $%.2f%n", p.getUnitPrice());
            System.out.printf("Category : %s (%s)%n",
                    p.getCategory().getCategoryName(),
                    p.getCategory().getDescription());

        }// em.close() called
    }
}
