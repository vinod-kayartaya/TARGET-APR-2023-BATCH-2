package com.targetindia.programs;

import com.targetindia.model.Product;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadProductsFromFile {
    public static void main(String[] args) {
        try (
                FileInputStream file = new FileInputStream("products.dat");
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            for(;;){
                try {
                    Object obj = in.readObject();
                    if(obj instanceof Product){
                        Product p = (Product) obj;
                        System.out.printf("Name = %s, price = %.2f%n",
                                p.getName(),
                                p.getPrice());
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
