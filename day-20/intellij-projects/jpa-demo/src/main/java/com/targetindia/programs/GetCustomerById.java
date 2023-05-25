package com.targetindia.programs;

import com.targetindia.entity.Customer;
import com.targetindia.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetCustomerById {

    public static void main(String[] args) {

        log.trace("starting the main program...");

        try (
                EntityManager em = JpaUtil.createEnitytManager();
        ) {
            log.trace("em is an instanceof class {}", em.getClass().getName());
            Customer c1 = em.find(Customer.class, 1001);
            log.trace("c1 = {}", c1);
        } // em.close() called here, which closes the DB connection represented by em
    }

}
