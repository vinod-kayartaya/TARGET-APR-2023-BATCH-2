package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class WithoutStream {
    public static void main(String[] args) {
        // We have a list of integers
        // We need to create a new list consisting of squares of all even numbers in the above list

        List<Integer> numbers = Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89, 90);
        List<Integer> squaresOfEvens = new ArrayList<>();

        for (Integer i : numbers) {
            if (i % 2 == 0) {
                squaresOfEvens.add(i * i);
            }
        }

        log.trace("numbers = {}", numbers);
        log.trace("squaresOfEvens = {}", squaresOfEvens);

        // select n*n
        //      from numbers n
        //      where n%2==0
        squaresOfEvens = numbers.stream() // stream of Integers 12, 23, 34, 45, 56, 67, 78, 89, 90
                .filter(n -> n % 2 == 0) // stream of even integers 12, 34, 56, 78, 90
                .map(n -> n * n)
                .collect(Collectors.toList());

        log.trace("squaresOfEvens = {}", squaresOfEvens);
    }
}
