package com.targetindia.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.Socket;

@Slf4j
public class GreetingsClient {

    @SneakyThrows
    public static void main(String[] args) {
        log.trace("Trying to connect to the server at localhost:8080...");
        try (
                Socket socket = new Socket("192.168.1.23", 8080);
        ) {
            log.trace("Connection to the server is obtained!");
            try (
                    InputStream in = socket.getInputStream()
            ) {
                byte[] bytes = in.readAllBytes();
                String message = new String(bytes);
                log.trace("Message from the server: {}", message);
            } // in.close() called here

        } // socket.close() is called here

        log.trace("End of the client app");
    }
}
