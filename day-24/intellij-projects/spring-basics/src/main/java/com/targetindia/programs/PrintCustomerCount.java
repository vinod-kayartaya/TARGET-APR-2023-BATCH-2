package com.targetindia.programs;

import com.targetindia.config.AppConfig4;
import com.targetindia.dao.CustomerDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class PrintCustomerCount {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext ctx
                        = new AnnotationConfigApplicationContext(AppConfig4.class)
        ) {
            CustomerDao dao = ctx.getBean(CustomerDao.class);
            log.trace("there are {} customers", dao.count());
        } // ctx.close() called here
    }
}
