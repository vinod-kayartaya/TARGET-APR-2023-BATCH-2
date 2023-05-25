package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;

public class GetCategoryAndProducts {
    public static void main(String[] args) {
        try (
                EntityManager em = JpaUtil.createEnitytManager();
        ) {
            int categoryId = KeyboardUtil.getInt("Enter category id to search: ");
            Category c1 = em.find(Category.class, categoryId);
            if(c1==null){
                System.out.println("No such category!");
                return;
            }

            System.out.printf("Category name: %s%n", c1.getCategoryName());
            System.out.printf("Description  : %s%n", c1.getDescription());
            System.out.println("Products in this category are: ");
            System.out.printf("%3s %-30s %12s%n", "ID", "Name", "Price");
            System.out.println("-----------------------------------------------");
            c1.getProducts() // this is when SQL select for getting products for this category is executed
                    .forEach(GetCategoryAndProducts::printProductDetails);
        }
    }
    static void printProductDetails(Product p){
        System.out.printf("%3s %-30s %12s%n",
                p.getProductId(),
                p.getProductName(),
                p.getUnitPrice());
    }

}
