package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Slf4j
public class GetCustomersByName {
    public static void main(String[] args) {
        String cmd = "select * from customers where lower(first_name) like lower(?)";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(cmd);
        ) {
            String firstname = KeyboardUtil.getString("Enter first name: ");
            firstname += "%";

            stmt.setString(1, firstname);
            try (ResultSet rs = stmt.executeQuery();) {


                System.out.printf("%3s %-20s %-6s %-30s %-15s%n",
                        "ID", "Name", "Gender", "Email", "Phone");
                System.out.println("--------------------------------------------------------------------------------");

                while (rs.next()) {
                    // process the result set
                    int id = rs.getInt("id");
                    firstname = rs.getString("first_name");
                    String lastname = rs.getString("last_name");
                    String gender = rs.getString("gender");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");

                    System.out.printf("%3d %-20s %-6s %-30s %-15s%n",
                            id, firstname + " " + lastname, gender, email, phone);
                }
            } // rs.close() is executed here
        } // conn.close(), stmt.close() called here
        catch (Exception e) {
            log.warn("Error!", e);
        }
    }
}
