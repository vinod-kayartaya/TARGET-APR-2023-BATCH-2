package com.targetindia.programs;

import com.targetindia.threads.CsvNumberConsolidator;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ThreadDemo5 {
    public static void main(String[] args) throws Exception {
        String[] filenames = {
                "sample.csv",
                "numbers1.csv",
                "numbers2.csv",
                "numbers3.csv"
        };

        String outputFilename = "numbers_sum.txt"; // 4560 lines should be there
        FileWriter writer = new FileWriter(outputFilename);

        List<Thread> threads = new ArrayList<>();

        for (String filename : filenames) {
            FileReader reader = new FileReader(filename);

            CsvNumberConsolidator adder = new CsvNumberConsolidator(filename, reader, writer);
            Thread t = new Thread(adder);
            t.start();
            threads.add(t);
        }

        // if we do not wait for the child threads to do their work until termination,
        // then, the writer gets closed immediately, and the threads will not be able to write anything at all.
        for(Thread t: threads){
            // wait until t is terminated (i.e, t.run() completes)
            t.join();
            log.trace("thread {} is now terminated", t.getName());
        }
        writer.write("All files have been processed\n");
        // at this point, all threads have been terminated
        writer.close();
        log.trace("End of main reached.");
    }
}
