package com.targetindia.threads;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

@AllArgsConstructor
public class CsvNumberAdder implements Runnable {

    FileReader reader;
    FileWriter writer;

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(reader);
                PrintWriter out = new PrintWriter(writer);
        ) {
            String line;
            while ((line = in.readLine()) != null) {

                String[] arr = line.split(",");
                double sum = 0;
                for (String a : arr) {
                    double d = 0;
                    try {
                        d = Double.parseDouble(a);
                    } catch (Exception e) {
                        // ignore the exception
                    }
                    sum += d;
                }
                out.println(sum);

            }
        } // in.close() and out.close() called here
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
