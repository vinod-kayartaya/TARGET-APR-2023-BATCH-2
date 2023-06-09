package com.targetindia.programs;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.net.Socket;

public class GreetingsClient {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Trying to connect to the server at localhost:8080...");
        try (
                Socket socket = new Socket("192.168.1.23", 8080);
        ) {
            System.out.println("Connection to the server is obtained!");
            try (
                    InputStream in = socket.getInputStream()
            ) {
                byte[] bytes = in.readAllBytes();
                String message = new String(bytes);
                System.out.printf("Message from the server: %s%n", message);
            } // in.close() called here

        } // socket.close() is called here

        System.out.println("End of the client app");
    }
}
