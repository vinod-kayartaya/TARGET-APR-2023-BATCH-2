package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Slf4j
public class BatchUpdateDemo {
    public static void main(String[] args) {
        String filename = "/Users/vinod/Documents/TARGET-APR-2023-BATCH-2/day-18/employees.csv";
        String cmd = "insert into employees(name, salary, department) values (?, ?, ?)";

        try (
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(cmd);
        ) {
            in.readLine(); // skip the header
            String line;
            while ((line = in.readLine()) != null) {
                try {
                    // split the line using comma separator
                    String[] values = line.split(",");
                    String name = values[0];
                    double salary = Double.parseDouble(values[1]);
                    String dept = values[2];

                    stmt.setString(1, name);
                    stmt.setDouble(2, salary);
                    stmt.setString(3, dept);

                    stmt.addBatch(); // no server visit
                } catch (Exception e) {
                    // ignore this line, and move on with other lines in the file.
                    log.trace("Skipping this line due to an error: {}", line);
                    log.trace("Error message is {}", e.getMessage());
                }
            }

            stmt.executeBatch(); // a single server visit carrying all values
            log.trace("Batch update done!");
        } catch (Exception e) {
            log.warn("Error!", e);
        }
    }
}
