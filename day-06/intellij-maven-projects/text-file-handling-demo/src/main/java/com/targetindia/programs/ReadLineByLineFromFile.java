package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;

@Slf4j
public class ReadLineByLineFromFile {
    public static void main(String[] args) {
        String filename = KeyboardUtil.getString("Enter filename: ");

        // a resource is a class that implements (directly or via inheritance) the AutoCloseable interface
        // which defines an abstract method called "public void close() throws Exception".
        // Only resources can be created inside () of try block
        try (
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {
            String text;
            while ((text = in.readLine())!=null) {
                System.out.println(text);
            }

        } // resources opened in the try() are automatically closed here
        // i.e, in.close() and reader.close() are called here
        catch (Exception e) {
            log.warn("There was an error: {}", e.getMessage());
        }
        // there is no need of the 'finally' block, unless we have some other
        // resources (which are not auto-closeable) to be closed

    }
}
