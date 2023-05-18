package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Slf4j
public class GetCustomersByID {
    public static void main(String[] args) {
        String cmd = "select * from customers where id=?";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(cmd);
        ) {
            int id = KeyboardUtil.getInt("Enter id to search: ");
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery();) {

                if (rs.next()) {
                    String firstname = rs.getString("first_name");
                    String lastname = rs.getString("last_name");
                    String gender = rs.getString("gender");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");

                    System.out.printf("Customer details for id %d%n", id);
                    System.out.printf("Name       : %s %s%n", firstname, lastname);
                    System.out.printf("Gender     : %s%n", gender);
                    System.out.printf("Email      : %s%n", email);
                    System.out.printf("Phone      : %s%n", phone);
                } else {
                    System.out.printf("No record found for customer with id %d%n", id);
                }
            } // rs.close() is executed here
        } // conn.close(), stmt.close() called here
        catch (Exception e) {
            log.warn("Error!", e);
        }
    }
}
