package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.dao.ProductDao;
import com.targetindia.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            ProductDao dao = ctx.getBean(ProductDao.class);
            log.trace("dao is an instanceof '{}' class", dao.getClass().getName());
            Product p = dao.getProductById(67);
            log.trace("p = {}", p);
            List<Product> list = dao.getProductsNotInStock();
            log.trace("{} products not in stock", list.size());
            list = dao.getDiscontinuedProducts();
            log.trace("{} products have been discontinued", list.size());
            list = dao.getProductsByPriceRange(50, 100);
            log.trace("there are {} products between $50 and $100", list.size());
            list = dao.getProductsByPriceRange(100, 50);
            log.trace("there are {} products between $100 and $50", list.size());
        }
    }
}
