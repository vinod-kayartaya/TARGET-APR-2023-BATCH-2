package com.targetindia.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

@Slf4j
public class GreetingsServer {
    static String[] greetingMessages = {"Hi!", "Hey, Heya or Hey there!", "Morning!", "How are things?",
            "What’s new?", "It’s good to see you", "G’day!", "Howdy!", "What’s up?", "How’s it going?",
            "What’s happening?", "What’s the story?", "Yo!", "Hello!", "Hi there", "Good morning", "Good afternoon",
            "Good evening", "It’s nice to meet you", "It’s a pleasure to meet you"
    };

    @SneakyThrows
    public static void main(String[] args) {
        log.trace("Starting the server...");
        try (
                ServerSocket serverSocket = new ServerSocket(8080)
        ) {
            log.trace("Server started and listening on port 8080");
            while (true) {
                log.trace("Waiting for a client connection...");
                Socket clientSocket = serverSocket.accept();
                log.trace("Got a client connection from {}", clientSocket.getInetAddress());
                log.trace("Picking a greeting message randomly to be sent to the client...");
                String message = greetingMessages[new Random().nextInt(20)];
                log.trace("Sending message '{}' to the client", message);

                try(OutputStream outputStream = clientSocket.getOutputStream();
                    PrintWriter out = new PrintWriter(outputStream)){
                    out.println(message);
                } // out.close() and outputStream.close() called here; this is when the content is written to the client

                clientSocket.close();
            }
        } // serverSocket.close() is called here

    }
}
