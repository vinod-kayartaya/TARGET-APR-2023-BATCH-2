package com.targetindia.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(78, 89, 12, 56, 67, 23, 34, 45, 90);
        numbers.stream()
                .sorted()
                .forEach(n -> System.out.println(n));
        System.out.println("-------------------");

        numbers.stream()
                .sorted((n1, n2) -> n2 - n1)
                .forEach(n -> System.out.println(n));
        System.out.println("-------------------");

        Stream.of("shyam", "arun kumar iyer", "kishore kumar", "nagesh reddy", "harish kumar cj", "vinod kumar kayartaya")
                .sorted()
                .forEach(name -> System.out.println(name));
        System.out.println("-------------------");
        List<String> names = Arrays.asList("shyam", "kishore kumar", "nagesh reddy", "harish kumar cj", "arun kumar iyer", "vinod kumar kayartaya");

        names.stream().sorted((name1, name2) -> name2.compareTo(name1))
                .forEach(name -> System.out.println(name));
        System.out.println("-------------------");

        names.stream()
                .sorted((name1, name2) -> Integer.compare(name1.length(), name2.length()))
                .forEach(name -> System.out.println(name));
        System.out.println("-------------------");


        names.stream()
                .sorted((name1, name2) -> {
                    int d = name1.length() - name2.length();
                    return d != 0 ? d : name1.compareTo(name2);
                })
                .forEach(name -> System.out.println(name));
        System.out.println("-------------------");

        names.stream()
                .min((name1, name2) -> name1.length() - name2.length())
                .ifPresent(shortestName -> System.out.println("Shortest name is " + shortestName));
        
        names.stream()
                .max((name1, name2) -> name1.length() - name2.length())
                .ifPresent(longestName -> System.out.println("Longest name is " + longestName));

    }
}
