package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

@Slf4j
public class WriteUsersToCsvFile {
    public static void main(String[] args) {
        String filename = "users.csv";

        File file = new File(filename);
        boolean exists = file.exists();

        try (
                FileWriter writer = new FileWriter(file, true);
                PrintWriter out = new PrintWriter(writer);
        ) {

            if(!exists){
                // add the header only if the file does not exist, and being created now.
                out.println("Name,Age,Height");
            }

            String choice;
            do {
                String name = KeyboardUtil.getString("Enter name: ");
                int age = KeyboardUtil.getInt("Enter age: ");
                double height = KeyboardUtil.getDouble("Enter height: ");

                out.printf("%s,%d,%.2f\n", name, age, height);

                choice = KeyboardUtil.getString("Do you want to add one more? (yes/no): [yes]");
                if (choice.isBlank()) {
                    choice = "yes";
                }
            } while (choice.equalsIgnoreCase("yes"));
        }
        // out.close() and writer.close() called here automatically!
        catch (Exception e) {
            log.warn("There was an error: {}", e.getMessage());
        }


    }
}
