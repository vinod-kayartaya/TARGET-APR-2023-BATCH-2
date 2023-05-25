package com.targetindia.programs;

import com.targetindia.entity.Customer;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CreateNewCustomerRecord {
    public static void main(String[] args) {
        System.out.println("Enter new customer details: ");
        String firstname = KeyboardUtil.getString("Firstname: ");
        String lastname = KeyboardUtil.getString("Lastname: ");
        String email = KeyboardUtil.getString("Email id: ");
        String phone = KeyboardUtil.getString("Phone number: ");
        String gender = KeyboardUtil.getString("Gender (Male/Female): ");

        Customer c = new Customer(); // at this time, for JPA/hibernate this object is called TRANSIENT
        c.setFirstname(firstname);
        c.setLastname(lastname);
        c.setEmail(email);
        c.setPhone(phone);
        c.setGender(gender);

        try (
                EntityManager em = JpaUtil.createEnitytManager();
        ) {
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                // after calling em.persist, "c" becomes a PERSISTENT object (from TRANSIENT)
                em.persist(c); // NO SQL INSERT command is executed here

                tx.commit(); // all SQL INSERT/UPDATE/DELETE are executed here depending on entities currently
                // available in the entity-manager cache and their status
                System.out.println("New customer data saved to the db.");
            }
            catch(Exception e){
                tx.rollback();
                System.out.println("There was an error while committing the transaction");
                e.printStackTrace();
            }
        } // em is closed here. now "c" becomes a DETACHED object
    }
}
