package com.targetindia.programs;

import java.util.Scanner;

public class ForLoopDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        for (int i = 1, times = 10; i <= times; i++) {
            System.out.printf("%d X %d = %d\n", n, i, n * i);
        }

    }
}
