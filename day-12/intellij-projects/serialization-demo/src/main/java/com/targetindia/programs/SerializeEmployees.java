package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.utils.DateUtil;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeEmployees {
    public static void main(String[] args) {
        Employee[] emps = {
                new Employee(112, "Harish", "harish@xmpl.com", DateUtil.toDate("12/10/1985"), 25000),
                new Employee(212, "Ramesh", "ramesh@xmpl.com", DateUtil.toDate("12/03/1999"), 25600),
                new Employee(115, "Kishore", "kishore@xmpl.com", DateUtil.toDate("09/01/1989"), 23500)
        };

        try (
                FileOutputStream file = new FileOutputStream("emps.dat");
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            for(Employee e: emps){
                out.writeObject(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Employee data stored in emps.dat file");

    }
}
