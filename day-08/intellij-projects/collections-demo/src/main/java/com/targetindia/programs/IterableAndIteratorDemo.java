package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class IterableAndIteratorDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 30, 48, 29, 48, 59, 66, 22, 34, 69);

        // int n = nums.get(0); /// <-- An object is assigned to a primitive; UNBOXING
        // nums.add(n*n); /// n*n is an int which is primitive, assigned to an object reference; BOXING

        // Integer x = new Integer(100); // object
        // int y = x; // UNBOXING
        // x = y; // BOXING

        // JDK 1.5 and above, we can use the enhanced for loop (foreach loop)
        for(int n: nums){
            log.trace("using for-each loop, n is {}", n);
        }

        // before java 1.5, we can use a loop like this (for a List implementations)
        for(int i=0, j=nums.size(); i<j; i++){
            int n = nums.get(i);
            log.trace("using a regular for loop, n is {}", n);
        }

        Set<Integer> intSet = new HashSet<>(nums);
        // Since Set does not have index based operations, prior to java 1.5, we have to
        // treat the set object as an Iterable object and get the Iterator and loop over it.
        Iterator<Integer> it = intSet.iterator();
        while(it.hasNext()){
            Integer n = it.next();
            log.trace("using iterator, n is {}", n);
        }
    }
}
