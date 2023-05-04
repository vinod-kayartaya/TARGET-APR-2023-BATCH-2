package com.targetindia.programs;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadFromTextFile {

    static String filename = "/Users/vinodkumar/Desktop/TARGET-APR-2023-BATCH-2/day-02/Readme.md";

    public static void main(String[] args) throws Exception {
        // In order to read a file line-by-line, we can use the DataInputStream's readLine() method.
        // However, it is deprecated due to some issues while converting bytes to characters.
        // So the preferred method is BufferedReader's readLine() method. In that case, we may have to
        // wrap the FileInputStream object in a InputStreamReader object, and then wrap that in a
        // BufferedInputStream. Instead of all these, we can just use the FileReader + BufferedReader combination.

        try (
                FileInputStream file = new FileInputStream(filename);
                DataInputStream in = new DataInputStream(file);
        ) {
            String line;
            int count = 0;
            while ((line = in.readLine()) != null) { // Deprecated; DO NOT USE THIS IN PRACTICE
                System.out.println(line);
                count++;
            }
            System.out.printf("Total lines read = %d%n", count);
        } // in.close() and file.close() called here
    }

    public static void main2(String[] args) throws Exception {
        try (
                FileInputStream file = new FileInputStream(filename);
        ) {
            int size = file.available(); // in most cases, this returns the actual file size itself.
            System.out.printf("size = %d%n", size);
            byte[] bytes = new byte[size];
            file.read(bytes);
            String content = new String(bytes);
            System.out.println(content);
        } // file.close() called here
    }

    public static void main1(String[] args) throws Exception {
        try (
                FileInputStream file = new FileInputStream(filename);
        ) {
            int ch;
            String content = "";
            int count = 0;
            while ((ch = file.read()) != -1) {
                content += (char) ch;
                count++;
            }

            System.out.println(content);
            System.out.printf("count = %d%n", count);
        } // file.close() called here
    }
}
