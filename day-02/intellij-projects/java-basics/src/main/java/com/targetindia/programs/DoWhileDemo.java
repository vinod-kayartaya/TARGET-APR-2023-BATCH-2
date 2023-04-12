package com.targetindia.programs;

import java.util.Scanner;

public class DoWhileDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a number: ");
        int upto = sc.nextInt();
        int a = -1, b = 1, c;

        do {
            c = a + b;
            if (c <= upto) {
                System.out.printf("%d, ", c);
            }
            a = b;
            b = c;
        } while (c <= upto);

        System.out.println();
    }
}
