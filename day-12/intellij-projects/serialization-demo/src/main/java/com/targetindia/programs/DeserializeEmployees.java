package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeEmployees {
    public static void main(String[] args) {
        try (
                FileInputStream file = new FileInputStream("emps.dat");
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            for (; ; ) {
                try {
                    Employee e = (Employee) in.readObject();
                    e.print();
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
