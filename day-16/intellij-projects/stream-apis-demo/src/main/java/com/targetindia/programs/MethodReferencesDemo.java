package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Slf4j
public class MethodReferencesDemo {

    static void processList(List<? extends Object> list, Consumer<Object> consumer) {
        log.trace("consumer is an object of type: {}", consumer.getClass().getName());
        for (Object obj : list) {
            consumer.accept(obj);
        }
    }

    static void print(Object obj) {
        if (obj instanceof String) {
            System.out.println(((String) obj).toUpperCase());
        } else {
            System.out.println(obj);
        }
    }

    static String createCode(String str) {
        int n = ((int) (Math.random() * 90)) + 10;
        if (str.length() < 2) {
            return "AB" + n;
        }
        return str.substring(0, 2).toUpperCase() + n;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 20, 30);
        processList(nums, n -> System.out.printf("n is %d%n", n));
        List<String> names = Arrays.asList("Vinod", "Shyam", "John", "Jane");
        processList(names, name -> log.trace("name is '{}'", name));

        // here the Consumer function is not adding any "value addition"
        // the consumer is receiving an element from the stream only to pass it to a different function
        // In such cases, we can use a method reference, (in other words, we are giving the reference to
        // a function object as a parameter)
        processList(nums, n -> System.out.println(n));
        processList(nums, n -> MethodReferencesDemo.print(n));
        processList(names, n -> MethodReferencesDemo.print(n));

        System.out.println("-------------------------");
        // using method reference, the above become:

        processList(nums, System.out::println);
        processList(nums, MethodReferencesDemo::print);
        processList(names, MethodReferencesDemo::print);
        System.out.println("-------------------------");

        Stream.of("Vinod", "avinash", "shyam", "anil", "Naveen", "harish", "vinay", "Arun")
                // .sorted((n1, n2) -> n1.compareToIgnoreCase(n2))
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::println);
        System.out.println("-------------------------");

        names.stream()
                // .map(name -> name.toUpperCase())
                .map(String::toUpperCase) // when using the non-static function use the ClassName::methodName
                .forEach(System.out::println);
        System.out.println("-------------------------");

        Stream.of("Vinod", "avinash", "shyam", "anil", "Naveen", "harish", "vinay", "Arun")
                // .map(name -> MethodReferencesDemo.createCode(name))
                .map(MethodReferencesDemo::createCode)
                // .forEach(name -> System.out.println(name));
                .forEach(System.out::println);
        System.out.println("-------------------------");

        Stream.of(100.0, 200.3, 49.32, 92.39, 4.5)
                .map(Math::sqrt)
                .forEach(System.out::println);
        System.out.println("-------------------------");
    }
}
