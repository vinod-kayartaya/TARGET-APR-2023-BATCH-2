package com.targetindia.programs;

import java.util.Arrays;

public class ArrayDemo {

    public static void main(String[] args) {

        // int[] nums;
        // nums = new int[4];
        // nums = new int[] {12, 39, 95, 39, 88};
        int[] nums = {12, 34, 56, 78};
        // System.out.println("nums is " + nums); // nums is [I@36baf30c
        System.out.println("nums is " + Arrays.toString(nums)); // nums is [12, 34, 56, 78]

        nums[0] = 120;
        nums[3] = 780;

        System.out.println("nums contain the following numbers: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("value at index %d is %d\n", i, nums[i]);
        }

        // enhanced for loop; introduced in java version 1.5
        for(int n: nums){
            System.out.println(n);
        }

    }
}
