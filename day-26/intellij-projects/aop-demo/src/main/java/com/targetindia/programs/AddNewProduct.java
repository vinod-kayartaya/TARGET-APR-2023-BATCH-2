package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.DaoException;
import com.targetindia.dao.ProductDao;
import com.targetindia.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class AddNewProduct {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            ProductDao dao = ctx.getBean(ProductDao.class);

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

            try {
                dao.addProduct(p);
                log.trace("New product added successfully!");
            } catch (DaoException e) {
                log.trace("error encountered!");
            }
        }
    }
}
