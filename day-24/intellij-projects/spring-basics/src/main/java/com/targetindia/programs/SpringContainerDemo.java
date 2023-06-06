package com.targetindia.programs;

import com.targetindia.config.AppConfig1;
import com.targetindia.config.AppConfig2;
import com.targetindia.config.AppConfig3;
import com.targetindia.dao.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SpringContainerDemo {
    public static void main(String[] args) {
        // a variable representing spring container
        AnnotationConfigApplicationContext ctx;

        ctx = new AnnotationConfigApplicationContext(AppConfig3.class);

        ProductDao dao; // variable of an interface (my dependency)
        dao = ctx.getBean("dao1", ProductDao.class);

        log.trace("dao is an instanceof {}", dao.getClass().getName());
        long pc = dao.count();

        log.trace("there are {} products", pc);
        ctx.close();

    }
}
