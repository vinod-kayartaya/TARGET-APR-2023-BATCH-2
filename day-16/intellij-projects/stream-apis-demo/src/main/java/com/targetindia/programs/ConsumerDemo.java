package com.targetindia.programs;

import java.util.Arrays;
import java.util.List;

public class ConsumerDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89, 90);
        numbers.stream()
                .peek(n -> System.out.printf("before filtering, n is %d%n", n))
                .filter(n->n%2==0)
                .forEach(n -> System.out.printf("after filter n is %d%n", n));
    }
}
