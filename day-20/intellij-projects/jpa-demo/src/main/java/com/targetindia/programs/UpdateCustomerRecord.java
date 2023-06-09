package com.targetindia.programs;

import com.targetindia.entity.Customer;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UpdateCustomerRecord {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter customer id to search: ");
        Customer c1;

        try (
                EntityManager em = JpaUtil.createEnitytManager();
        ) {
            c1 = em.find(Customer.class, id);
            // at this time, c1 is in the entity manager cache (c1 as a persistent object)
        } // em.close() called here

        // at this time, em no more represents a connection and there is no cache
        // c1 is now a detached object (detached from the entity manager cache)

        System.out.println(c1);
        String input;
        System.out.println("Enter new details for the customer (or press RETURN to keep the same)");
        input = KeyboardUtil.getString("Firstname: (" + c1.getFirstname() + ") ");
        if (!input.isBlank()) {
            c1.setFirstname(input);
        }
        input = KeyboardUtil.getString("Lastname: (" + c1.getLastname() + ") ");
        if (!input.isBlank()) {
            c1.setLastname(input);
        }
        input = KeyboardUtil.getString("Email: (" + c1.getEmail() + ") ");
        if (!input.isBlank()) {
            c1.setEmail(input);
        }
        input = KeyboardUtil.getString("Phone: (" + c1.getPhone() + ") ");
        if (!input.isBlank()) {
            c1.setPhone(input);
        }
        input = KeyboardUtil.getString("Gender: (" + c1.getGender() + ") ");
        if (!input.isBlank()) {
            c1.setGender(input);
        }

        // c1 now needs to be updated back to the database record
        // for this we need a new entity manager
        try (
                EntityManager em = JpaUtil.createEnitytManager();
        ) {
            EntityTransaction tx = em.getTransaction();

            try {
                tx.begin();
                em.merge(c1); // c1 becomes a persistent object with a status of 'dirty'
                // the merge method does the following:
                // 1. takes the c1.id and executes a SELECT query to bring the data corresponding to c1.id
                // 2. compares the data coming from the DB with the data maintained by c1
                // 3a. if the data is same, then c1's state is NONE
                // 3b. if the data is different, then c1's state is DIRTY

                tx.commit();
                // all persistent objects with state of DIRTY is converted into SQL UPDATE commands and are executed
                // all persistent objects with state of NEW is converted into SQL INSERT commands and are executed
                // all persistent objects with state of REMOVED is converted into SQL DELETE commands and are executed

                System.out.println("Data updated successfully!");
            } catch (Exception e) {
                tx.rollback();
                System.out.println("Couldn't update data");
                e.printStackTrace();
            }
        } // em.close() called, and em no longers exits

        // now c1 is again a detached object
    }
}
