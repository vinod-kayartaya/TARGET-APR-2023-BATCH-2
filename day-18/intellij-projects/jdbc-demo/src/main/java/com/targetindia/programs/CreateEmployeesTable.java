package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;

@Slf4j
public class CreateEmployeesTable {
    public static void main(String[] args) {

        String sqlCmd = "CREATE TABLE employees (\n" +
                "    id int primary key auto_increment,\n" +
                "    name varchar(50) not null,\n" +
                "    salary double,\n" +
                "    department varchar(50) default 'PRODUCTION'\n" +
                ")";

        try (
                Connection conn = DbUtil.createConnection(); // equivalent of a bridge
                Statement stmt = conn.createStatement(); // equivalent of a vehicle to carry the sql command
        ) {
            stmt.execute(sqlCmd);
            log.trace("The execution of sql command was a success");
        }// conn and stmt are closed here
        catch (Exception e) {
            log.trace("There was an error while executing the sql command - {}", e.getMessage());
        }

    }
}
