package com.targetindia.programs;

import java.util.Scanner;

public class WhileLoopDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        int times = 10;
        int i = 1;

        while (i <= times) {
            System.out.printf("%d X %d = %d\n", n, i, n * i);
            i++; // i=i+1; i+=1;
        }

    }
}
