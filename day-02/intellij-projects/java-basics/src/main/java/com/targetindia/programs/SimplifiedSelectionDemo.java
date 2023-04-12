package com.targetindia.programs;

import java.util.Scanner;

public class SimplifiedSelectionDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int month; // to be accepted from the user
        System.out.print("Enter value for a month (1-12): ");
        month = sc.nextInt();

        if(month<1 || month >12) {
            System.out.printf("%d is an invalid value for a month\n", month);
            return;
        }

        System.out.println("Given number for the month is valid");
        switch(month){
            case 4:
            case 6:
            case 9:
            case 11:
                // common statement for above cases
                System.out.println("There are 30 days in the given month");
                break;
            case 2:
                System.out.println("There are 28 or 29 days");
                break;
            default:
                System.out.println("There are 31 days in the given month");
        }
    }

}
