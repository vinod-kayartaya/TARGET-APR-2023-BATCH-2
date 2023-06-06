package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class JdbcTemplateDemos {
    private static JdbcTemplate template;

    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            template = ctx.getBean(JdbcTemplate.class);
            demo5();

        } // ctx.close() called here
    }

    static void demo1() {
        // get the count of products
        int pc = template.queryForObject("select count(*) from products", Integer.class);
        log.trace("there are {} products", pc);
    }

    static void demo2() {
        // get the name of the costliest product
        String sql = "select product_name from products where unit_price=(select max(unit_price) from products)";
        String name = template.queryForObject(sql, String.class);
        log.trace("costliest product name is {}", name);
    }

    static void demo3() {
        String sql = "select product_name, unit_price from products where product_id=?";
        ResultSetExtractor<Object[]> rse = (rs) -> rs.next() ?
                new Object[]{rs.getString(1), rs.getDouble(2)} :
                null;

        int id = 1;
        Object[] result = template.query(sql, rse, id);

        log.trace("result is {}", Arrays.toString(result));
    }

    static void demo4() {
        // get the names of the products that have been discontinued
        String sql = "select product_name from products where discontinued=1";
        template.queryForList(sql, String.class)
                .forEach(System.out::println);
    }

    static void demo5() {
        // get the name, category and price of all products which are not in stock
        String sql = "SELECT PRODUCT_NAME, CATEGORY_NAME, UNIT_PRICE\n" +
                "FROM PRODUCTS NATURAL JOIN CATEGORIES\n" +
                "WHERE UNITS_IN_STOCK=0";
        ResultSetExtractor<List<Object[]>> rse = rs -> {
            List<Object[]> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDouble(3)});
            }
            return list;
        };
        template.query(sql, rse)
                .forEach(ar -> System.out.printf("%s (%s) --> $%.2f%n", ar[0], ar[1], ar[2]));

    }
}
