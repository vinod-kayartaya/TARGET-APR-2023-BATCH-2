package com.targetindia.programs;

import com.targetindia.entity.Customer;
import com.targetindia.utils.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class GetOneCustomer {
    public static void main(String[] args) {

        try (
                Session session = HibernateUtil.getSession();
        ) {
            log.trace("session is an instanceof class {}", session.getClass().getName());
            Customer c1 = session.get(Customer.class, 7889);
            log.trace("c1 is {}", c1);
        }// session closed here

    }
}
