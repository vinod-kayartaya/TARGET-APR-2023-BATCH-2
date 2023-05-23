package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.utils.HibernateUtil;
import com.targetindia.utils.KeyboardUtil;
import org.hibernate.Session;

public class GetEmployeeById {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter employee id to search: ");
        try (Session session = HibernateUtil.getSession()) {
            Employee emp = session.get(Employee.class, id);
            System.out.println(emp);
        }
    }
}
