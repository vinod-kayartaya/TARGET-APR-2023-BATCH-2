package com.targetindia.programs;

import com.targetindia.entity.Customer;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class HardDeleteCustomer {
    // Hard delete --> SQL DELETE
    // Soft delete --> SQL UPDATE a flag (is_active or discontinued, etc)

    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter customer id to delete: ");
        try (
                EntityManager em = JpaUtil.createEnitytManager();
        ) {
            Customer c1 = em.find(Customer.class, id);
            if(c1 == null){
                System.out.printf("No customer found with id %d%n", id);
                return;
            }

            System.out.println("Customer details: ");
            System.out.printf("Name      : %s %s%n", c1.getFirstname(), c1.getLastname());
            System.out.printf("Gender    : %s%n", c1.getGender());
            System.out.printf("Phone     : %s%n", c1.getPhone());
            System.out.printf("Email     : %s%n", c1.getEmail());

            String ans = KeyboardUtil.getString("Are you sure to delete this? (yes/no) ");
            if(ans.equalsIgnoreCase("yes")){
                // at this time, "c1" is a PERSISTENT object
                EntityTransaction tx = em.getTransaction();
                try{
                    tx.begin();;
                    em.remove(c1); // at this time, the status of c1 becomes REMOVED
                    tx.commit();
                    System.out.println("Deleted!");
                }
                catch(Exception e){
                    tx.rollback();
                    System.out.println("Could not delete.");
                }
            }
        }
    }
}
