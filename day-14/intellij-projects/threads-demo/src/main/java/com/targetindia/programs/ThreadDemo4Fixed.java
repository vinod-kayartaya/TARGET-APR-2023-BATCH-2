package com.targetindia.programs;

import com.targetindia.threads.CsvNumberAdder;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.FileWriter;

@Slf4j
public class ThreadDemo4Fixed {
    public static void main(String[] args) throws Exception {
        String[][] filenames = {
                {"numbers1.csv", "numbers1_sum.csv"},
                {"numbers2.csv", "numbers2_sum.csv"},
                {"numbers3.csv", "numbers3_sum.csv"}
        };

        for (String[] f : filenames) {
            FileReader reader = new FileReader(f[0]);
            FileWriter writer = new FileWriter(f[1]);
            CsvNumberAdder adder = new CsvNumberAdder(reader, writer);
            new Thread(adder).start();
        }
        log.trace("End of main reached.");
    }
}
