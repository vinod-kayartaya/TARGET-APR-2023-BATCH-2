package com.targetindia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class KeyboardUtil {
    private KeyboardUtil(){}

    public static String getString(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    public static double getDouble(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextDouble();
    }

    public static int getInt(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextInt();
    }
    public static Date getDate(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message + " (in DD/MM/YYYY format) ");
        String input = sc.nextLine();

        try {
            // String to Date conversion (and vice versa) can be done using SimpleDateFormat
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(input);
        } catch (ParseException e) {
            System.out.println("Entered value was not a valid date; assuming null");
            return null;
        }
    }

}
