package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vinay", "Vinod", "Shyam", "\t", "\n", "   ", "Ganesh");
        log.trace("names count is {}", names.size());

//        Predicate<String> pr1 = new Predicate<String>() {
//            @Override
//            public boolean test(String name) {
//                log.trace("name is '{}'", name);
//                return !name.isBlank();
//            }
//        };

        names.stream()
                .filter((name) -> !name.isBlank())
                .forEach(name -> System.out.println(name));
    }
}
