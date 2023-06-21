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
        System.out.println("Starting the server...");
        try (
                ServerSocket serverSocket = new ServerSocket(8080)
        ) {
            System.out.println("Server started and listening on port 8080");
            while (true) {
                System.out.println("Waiting for a client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.printf("Got a client connection from %s%n", clientSocket.getInetAddress());
                System.out.println("Picking a greeting message randomly to be sent to the client...");
                String message = greetingMessages[new Random().nextInt(20)];
                System.out.printf("Sending message '%s' to the client%n", message);

                try(OutputStream outputStream = clientSocket.getOutputStream();
                    PrintWriter out = new PrintWriter(outputStream)){
                    out.println(message);
                } // out.close() and outputStream.close() called here; this is when the content is written to the client

                clientSocket.close();
            }
        } // serverSocket.close() is called here

    }
}
