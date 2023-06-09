package com.targetindia.threads;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class CsvNumberAdder implements Runnable {

    FileReader reader;
    FileWriter writer;

    public CsvNumberAdder(FileReader reader, FileWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() { // A thread object can run this method
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
            log.trace("Adder task completed!");
        } // in.close() and out.close() called here
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
