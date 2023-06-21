package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MathClient {

    static int menu() {
        System.out.println("What do you want to do?");
        System.out.println("-----------------------");
        System.out.println("0. Exit");
        System.out.println("1. Factorial of a number");
        System.out.println("2. 'a' raised to the power of 'b'");
        System.out.println("3. Square root of a number");
        try {
            return KeyboardUtil.getInt("Enter your choice: ");
        } catch (Exception e) {
            return -1;
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        the_loop:
        while (true) {
            try (
                    Socket socket = new Socket("192.168.1.23", 8080)
            ) {
                int num1, num2;
                String methodName;
                Object[] methodArgs;


                int choice = menu();
                switch (choice) {
                    case 0:
                        break the_loop;
                    case 1:
                        methodName = "factorial";
                        num1 = KeyboardUtil.getInt("Enter the input for factorial: ");
                        methodArgs = new Object[]{num1};
                        break;
                    case 2:
                        methodName = "power";
                        num1 = KeyboardUtil.getInt("Enter the base: ");
                        num2 = KeyboardUtil.getInt("Enter the exponent: ");
                        methodArgs = new Object[]{num1, num2};
                        break;
                    case 3:
                        methodName = "squareRoot";
                        num1 = KeyboardUtil.getInt("Enter the input for square root: ");
                        methodArgs = new Object[]{num1};
                        break;
                    default:
                        System.out.println("Invalid choice. Please retry.");
                        continue the_loop;
                }

                try (
                        InputStream inputStream = socket.getInputStream();
                        OutputStream outputStream = socket.getOutputStream();
                        ObjectInputStream in = new ObjectInputStream(inputStream);
                        ObjectOutputStream out = new ObjectOutputStream(outputStream)
                ) {
                    Map<String, Object> request = new HashMap<>();
                    request.put("methodName", methodName);
                    request.put("args", methodArgs);
                    out.writeObject(request); // sending the information required by the server socket
                    // in between these lines is where the server is doing it's work, and sending the response
                    Map<String, Object> response = (Map<String, Object>) in.readObject();
                    if (response.containsKey("result")) {
                        System.out.printf("Result = %s%n", response.get("result"));
                    } else if (response.containsKey("error")) {
                        System.out.printf("There was an error: %s%n", response.get("error"));
                    }
                } // out.close(), outputStream.close() called here

            } // socket.close() is called automatically

        } // end of while (user chose 0)
    }
}
