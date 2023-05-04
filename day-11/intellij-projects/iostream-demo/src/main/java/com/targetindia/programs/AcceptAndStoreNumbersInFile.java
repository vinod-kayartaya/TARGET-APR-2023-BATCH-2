package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AcceptAndStoreNumbersInFile {
    static String filename = "numbers.dat";

    public static void main(String[] args) {

        try (
                FileOutputStream file = new FileOutputStream(filename); // low level write operations
                DataOutputStream out = new DataOutputStream(file); // wraps the file and provides high-level write operations
        ) {

            while (true) {
                try {
                    double num = KeyboardUtil.getDouble("Enter a number (0 to stop): ");
                    if(num==0){
                        break;
                    }
                    out.writeDouble(num); // internally makes use of the file.write(byte[]), after converting the num into an array of 8 bytes
                } catch (Exception e) {
                    System.out.println("Try only with a number!!");
                }
            }
        } // out.close() and file.close() are called, which have a 'throws IOException' in the signature
        catch (IOException e) {
            System.out.println("There was an error");
            e.printStackTrace();
        }
        System.out.println("Data saved to a file " + filename);
    }
}
