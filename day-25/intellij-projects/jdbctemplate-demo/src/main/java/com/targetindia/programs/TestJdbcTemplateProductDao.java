package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import com.targetindia.model.Product;
import com.targetindia.util.KeyboardUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestJdbcTemplateProductDao {
    static ProductDao dao;

    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            dao = ctx.getBean(ProductDao.class);
            demo7();
        } // ctx.close() called here
    }

    static void demo1(){
        Product p = dao.getProductById(67);
        System.out.println(p);
    }

    static void demo2(){
        dao.getDiscontinuedProducts()
                .forEach(System.out::println);
    }

    static void demo3(){
        dao.getProductsNotInStock()
                .forEach(System.out::println);
    }

    static void demo4(){
        dao.getProductsByPriceRange(50, 500)
                .forEach(System.out::println);
    }
    static void demo5(){
        List<Product> list = dao.getAllProducts();
        System.out.printf("There are %d products%n", list.size());
    }

    static void demo6(){
        Product p = dao.getProductById(1);
        System.out.printf("Current price for '%s' is $ %.2f%n", p.getProductName(), p.getUnitPrice());
        double price = KeyboardUtil.getDouble("Enter new price: ");
        p.setUnitPrice(price);
        dao.updateProduct(p);
        System.out.println("Product price updated");
    }

    static void demo7(){
        Product p = new Product();
        p.setProductId(101);
        p.setProductName("Diet Coke");
        p.setUnitPrice(2.33);
        p.setSupplierId(1);
        p.setCategoryId(1);
        p.setQuantityPerUnit("200 ml can X 6");
        p.setUnitsInStock(124);
        p.setUnitsOnOrder(29);
        p.setReorderLevel(10);
        p.setDiscontinued(0);

        dao.addProduct(p);
        System.out.println("New product added to the database");
    }

}
