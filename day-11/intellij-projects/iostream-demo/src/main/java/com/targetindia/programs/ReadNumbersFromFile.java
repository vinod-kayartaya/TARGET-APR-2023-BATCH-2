package com.targetindia.programs;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;

public class ReadNumbersFromFile {
    public static void main(String[] args) {
        try (
                FileInputStream file = new FileInputStream("numbers.dat");
                DataInputStream in = new DataInputStream(file); // wraps "file" to provide more functionalities
        ) {
            while (true) {
                try {
                    double num = in.readDouble();
                    System.out.println(num);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("That's all folks!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
