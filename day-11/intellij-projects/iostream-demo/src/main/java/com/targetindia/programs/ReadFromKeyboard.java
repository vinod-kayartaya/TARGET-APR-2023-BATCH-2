package com.targetindia.programs;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadFromKeyboard {

    public static void main(String[] args)  throws IOException{
        // BufferedReader does not know WHERE to read from, but knows HOW to read (for example, readLine())
        // The constructors of BufferedReader need an object of a Reader, and hence
        // we must find a way of converting an InputStream to a Reader.

        // Java provides a class called InputStreamReader, that can be used to do the same.
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);

        System.out.printf("Enter your name: ");
        String name = in.readLine();
        System.out.printf("Enter your city name: ");
        String city = in.readLine();
        System.out.printf("Hello, %s. How is weather in %s?%n", name, city);
    }

    public static void main5(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        System.out.printf("Enter your name: ");
        String name = in.readLine(); // deprecated; use the BufferedReader.readLine()
        System.out.printf("Enter your city name: ");
        String city = in.readLine(); // deprecated; use the BufferedReader.readLine()
        System.out.printf("Hello, %s. How is weather in %s?%n", name, city);
    }

    static String readLineFromKeyboard(String message) throws IOException{
        System.out.printf(message);
        byte[] bytes = new byte[100];
        System.in.read(bytes); // writes the content from the keyboard buffer directly into the given byte array
        return new String(bytes).trim();
    }

    public static void main4(String[] args)  throws IOException{
        String name = readLineFromKeyboard("What's your name? ");
        String city = readLineFromKeyboard("Where are you from? ");
        System.out.printf("Hello, %s. How is weather in %s?%n", name, city);
    }
    public static void main3(String[] args) throws IOException {
        byte[] bytes = new byte[10];
        System.out.printf("bytes = %s%n", Arrays.toString(bytes));
        System.out.printf("Enter some text: ");
        System.in.read(bytes);
        System.out.printf("bytes = %s%n", Arrays.toString(bytes));
        String str = new String(bytes).trim();
        System.out.printf("str.length() is %d%n", str.length());
        System.out.printf("str = '%s'%n", str);
        System.in.read(bytes);
        System.out.printf("bytes = %s%n", Arrays.toString(bytes));
        str = new String(bytes).trim();
        System.out.printf("str.length() is %d%n", str.length());
        System.out.printf("str = '%s'%n", str);
    }

    static String readStringFromKeyboard(String message) throws IOException {
        System.out.printf(message);
        String text = "";
        int ch;

        while ((ch = System.in.read()) != '\n') {
            text += (char) ch;
        }
        return text;
    }

    public static void main2(String[] args) throws IOException {
        String name = readStringFromKeyboard("Enter your name: ");
        String city = readStringFromKeyboard("Enter your city: ");

        System.out.printf("Hello, %s. How is weather in %s?%n", name, city);
    }

    public static void main1(String[] args) throws IOException {
        System.out.printf("Enter your name: ");
        String name = "";
        int ch = System.in.read();
        name += (char) ch;
        ch = System.in.read();
        name += (char) ch;
        ch = System.in.read();
        name += (char) ch;
        ch = System.in.read();
        name += (char) ch;
        ch = System.in.read();
        name += (char) ch;
        ch = System.in.read();
        name += (char) ch;
        ch = System.in.read();
        name += (char) ch;
        ch = System.in.read();
        name += (char) ch;
        ch = System.in.read();
        name += (char) ch;
        ch = System.in.read();
        name += (char) ch;

        System.out.printf("Hello, %s. How are you doing today?%n", name);
    }
}
