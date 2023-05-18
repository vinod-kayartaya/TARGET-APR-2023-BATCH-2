package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;

@Slf4j
public class AddOneEmployeeRecord {
    public static void main(String[] args) {
        try (
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
        ) {
            System.out.println("Enter employee details");
            String name = KeyboardUtil.getString("Name       : ");
            double salary = KeyboardUtil.getDouble("Salary     : ");
            String dept = KeyboardUtil.getString("Department : ");

            String sqlCmd = "insert into employees";
            if (dept.isBlank()) {
                sqlCmd += String.format("(name, salary) values('%s', %f)", name, salary);
            } else {
                sqlCmd += String.format("(name, salary, department) values('%s', %f, '%s')"
                        , name, salary, dept);
            }
            log.trace("sql command is: {}", sqlCmd);
            int uc = stmt.executeUpdate(sqlCmd);
            log.trace("{} row/s inserted", uc);
        }// both conn and stmt get closed!
        catch (Exception e) {
            log.warn("Error!", e);
        }
    }
}
