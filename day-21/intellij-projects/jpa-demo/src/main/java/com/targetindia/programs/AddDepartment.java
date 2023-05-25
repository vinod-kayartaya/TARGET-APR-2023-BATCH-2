package com.targetindia.programs;

import com.targetindia.entity.Department;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AddDepartment {
    public static void main(String[] args) {

        try (
                EntityManager em = JpaUtil.createEnitytManager();
        ) {

            String deptName = KeyboardUtil.getString("Enter department name: ");
            String deptLocation = KeyboardUtil.getString("Enter department location: ");
            Department dept = new Department(deptName, deptLocation); // transient

            EntityTransaction tx = em.getTransaction();

            try{
                tx.begin();
                em.persist(dept); // now dept becomes a persistent object
                tx.commit();
                System.out.println("Department saved!");
            }
            catch(Exception e){
                tx.rollback();
                e.printStackTrace();
                System.out.println("Department not saved");
            }
        } // em.close() here
    }
}
