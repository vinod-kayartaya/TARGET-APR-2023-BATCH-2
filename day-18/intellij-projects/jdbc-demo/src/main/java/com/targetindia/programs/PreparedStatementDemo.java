package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

@Slf4j
public class PreparedStatementDemo {
    public static void main(String[] args) {

        // JDBC command and not an actual SQL command
        String cmd = "insert into employees(name, salary, department) values (?, ?, ?)";

        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(cmd); // 1st round trip to DB server
        ) {

            while (true) {
                System.out.println("Enter employee details");
                String name = KeyboardUtil.getString("Name       : ");
                double salary = KeyboardUtil.getDouble("Salary     : ");
                String dept = KeyboardUtil.getString("Department : ");

                // get ready to carry these values to the server, which already has a compiled
                // version of the sql command (without values)
                stmt.setString(1, name);
                stmt.setDouble(2, salary);
                if (dept.isBlank()) {
                    stmt.setNull(3, Types.VARCHAR);
                } else {
                    stmt.setString(3, dept);
                }

                // visit the server, carrying the values alone
                stmt.execute(); // or executeUpdate() --> 2nd round trip (and 3rd, 4th etc)
                log.trace("Added this record: name='{}', salary={}, department='{}'", name, salary, dept);

                String ans = KeyboardUtil.getString("Do you want to add one more? yes/no: (yes) ");
                if (ans.equalsIgnoreCase("no")) {
                    break;
                }
            }

        }// both conn and stmt get closed!
        catch (Exception e) {
            log.warn("Error!", e);
        }
    }
}
