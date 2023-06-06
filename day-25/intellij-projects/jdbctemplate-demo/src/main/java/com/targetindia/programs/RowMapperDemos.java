package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.model.Shipper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class RowMapperDemos {
    private static JdbcTemplate template;

    static RowMapper<Shipper> srm = (rs, rowNum) -> {
        Shipper s = new Shipper();
        s.setShipperId(rs.getInt("shipper_id"));
        s.setCompanyName(rs.getString("company_name"));
        s.setPhone(rs.getString("phone"));
        return s;
    };

    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class)
        ) {
            template = ctx.getBean(JdbcTemplate.class);
            demo2();
        } // ctx.close() called here
    }

    static void demo1() {
        String sql = "select * from shippers where shipper_id=?";
        int id = 1;
        Shipper s1 = template.queryForObject(sql, srm, id);
        System.out.println(s1);
    }

    static void demo2(){
        List<Shipper> list = template.query("select * from shippers", srm);
        for(Shipper s: list){
            System.out.println(s);
        }
    }
}
