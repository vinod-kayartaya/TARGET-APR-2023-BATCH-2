package com.targetindia.threads;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class CsvNumberConsolidator implements Runnable {

    String sourceFilename;
    FileReader reader;
    FileWriter writer;

    public CsvNumberConsolidator(String sourceFilename, FileReader reader, FileWriter writer) {
        this.sourceFilename = sourceFilename;
        this.reader = reader;
        this.writer = writer; // do not close this resource here; might be required by another thread
    }

    @Override
    public void run() { // A thread object can run this method

        try {
            BufferedReader in = new BufferedReader(reader);
            PrintWriter out = new PrintWriter(writer);
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
                line = line.replaceAll(",", " + ");
                out.printf("[%s] %s = %s%n", sourceFilename, line, sum);
            }
            log.trace("Adder task for {} completed!", sourceFilename);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
