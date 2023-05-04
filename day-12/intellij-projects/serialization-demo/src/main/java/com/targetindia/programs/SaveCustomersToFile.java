package com.targetindia.programs;

import com.targetindia.model.Customer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCustomersToFile {
    static byte[] loadPicture(String filename) throws Exception {
        byte[] bytes = new byte[0];
        try (FileInputStream file = new FileInputStream(filename);) {
            bytes = new byte[file.available()];
            file.read(bytes);
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        Customer c1 = new Customer(101, "Ramesh", "ramesh@xmpl.com");
        c1.getAddress().setHouseStreet("1st cross, 10th main");
        c1.getAddress().setArea("Bank colony");
        c1.getAddress().setCity("Mysore");
        c1.setPhoto(loadPicture("ramesh.jpg"));

        Customer c2 = new Customer(123, "Kiran", "kiran@xmpl.com");
        c2.getAddress().setHouseStreet("1st cross, 10th main");
        c2.getAddress().setArea("Bank colony");
        c2.getAddress().setCity("Mysore");
        c2.setPhoto(loadPicture("kiran.jpg"));

        Customer c3 = new Customer(453, "Rohit", "rohit@xmpl.com");
        c3.getAddress().setCity("Bangalore");
        c3.getAddress().setArea("JP Nagar");
        c3.getAddress().setHouseStreet("8th main, 2nd phase");
        c3.setPhoto(loadPicture("rohit.jpg"));

        FileOutputStream file = new FileOutputStream("customers.dat");
        ObjectOutputStream out = new ObjectOutputStream(file);

        for (Customer c : new Customer[]{c1, c2, c3}) {
            out.writeObject(c);
        }
        out.close();
        file.close();

        System.out.println("Customers data saved to file 'customers.dat'");
    }
}
