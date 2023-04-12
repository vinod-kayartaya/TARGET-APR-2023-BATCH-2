package com.targetindia.programs;

import java.util.Scanner;

public class SelectionConstructDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int month; // to be accepted from the user
        System.out.print("Enter value for a month (1-12): ");
        month = sc.nextInt();

        if(month<1 || month >12) {
            System.out.printf("%d is an invalid value for a month\n", month);
        }
        else {
            System.out.println("Given number for the month is valid");
            if(month==2){
                System.out.println("There are 28 or 29 days");
            }
            else if(month==4 || month==6 || month==9 || month==11){
                System.out.println("There are 30 days in the given month");
            }
            else {
                System.out.println("There are 31 days in the given month");
            }
        }

    }
}
