package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class PredicateDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(121, 1301, 141, 1501);

        // examples of Stream methods that take Predicate as an argument
        boolean tf;
        Predicate<Integer> p = n -> n % 2 == 0;
        tf = nums.stream().anyMatch(p);
        log.trace("any number in the list is even? {}", tf);
        tf = nums.stream().allMatch(p);
        log.trace("all of the numbers in nums is even? {}", tf);
        tf = nums.stream().noneMatch(n -> n % 2 == 0);
        log.trace("none of the numbers are even? {}", tf);
    }
}
