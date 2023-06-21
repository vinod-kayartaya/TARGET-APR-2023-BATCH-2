package com.targetindia.programs;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MathServer {

    static class ClientSocketHandler implements Runnable {
        Socket clientSocket;

        public ClientSocketHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @SneakyThrows
        @Override
        public void run() {
            // we now have access to the clientSocket
            try (
                    InputStream inputStream = clientSocket.getInputStream();
                    OutputStream outputStream = clientSocket.getOutputStream();
                    ObjectOutputStream out = new ObjectOutputStream(outputStream);
                    ObjectInputStream in = new ObjectInputStream(inputStream);
            ) {
                Map<String, Object> request = (Map<String, Object>) in.readObject();
                Map<String, Object> response = new HashMap<>();
                String methodName = (String) request.get("methodName");
                Object[] methodArgs = (Object[]) request.get("args");
                int num1, num2;

                switch (methodName){
                    case "factorial":
                        num1 = (int) methodArgs[0];
                        long result1 = factorial(num1);
                        response.put("result", result1);
                        break;
                    case "power":
                        num1 = (int) methodArgs[0];
                        num2 = (int) methodArgs[1];
                        double result2 = power(num1, num2);
                        response.put("result", result2);
                        break;
                    case "squareRoot":
                        num1 = (int) methodArgs[0];
                        double result3 = sqaureRoot(num1);
                        response.put("result", result3);
                        break;
                    default:
                        response.put("error", "Unknown method requested");
                }
                out.writeObject(response);
            } // in, out, inputStream, outputStream are closed here
            clientSocket.close();
        } // end of run(), meaning the thread is dead!!
    }

    @SneakyThrows
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started and listening at port 8080");

            while (true) {
                System.out.println("Waiting for new client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.printf("Got a client connection from %s%n", clientSocket.getInetAddress());
                // handle each client request using a new thead
                new Thread(new ClientSocketHandler(clientSocket)).start();
                System.out.println("Started work for the client in a new thread...");
            }
        }
    }


    static long factorial(int num) {
        long f = 1;
        for (int n = 2; n <= num; n++) {
            f *= n;
        }
        return f;
    }

    static double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    static double sqaureRoot(int num) {
        return Math.sqrt(num);
    }
}
