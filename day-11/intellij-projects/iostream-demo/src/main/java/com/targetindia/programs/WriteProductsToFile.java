package com.targetindia.programs;

import com.targetindia.model.Product;
import com.targetindia.utils.KeyboardUtil;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteProductsToFile {
    public static void main(String[] args) {
        try (
                FileOutputStream file = new FileOutputStream("products.dat");
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            while (true) {
                System.out.println("Enter product details: ");
                int id = KeyboardUtil.getInt("ID         : ");
                String name = KeyboardUtil.getString("Name       : ");
                String category = KeyboardUtil.getString("Category   : ");
                double price = KeyboardUtil.getDouble("Price      : ");
                Product p = new Product(id, name, category, price);

                out.writeObject(p);

                String choice = KeyboardUtil.getString("Do you wish to add one more? ('no' to exit)");
                if (choice.equalsIgnoreCase("no")) {
                    break;
                }
            }
            System.out.println("Products data save to a file called 'products.dat'");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
