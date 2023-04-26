package com.targetindia.programs;

import com.targetindia.model.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestingEqualsAndHashCode {
    public static void main(String[] args) {
        String s1 = new String("Vinod");
        String s2 = new String("Vinod");

        Person p1 = new Person("Vinod", "Bangalore");
        Person p2 = new Person("Vinod", "Bangalore");

        log.trace("p1 is {}", p1);
        log.trace("p2 is {}", p2);
        log.trace("s1 is {}", s1);
        log.trace("s2 is {}", s2);
        log.trace("p1.hashCode() is {}", p1.hashCode());
        log.trace("p2.hashCode() is {}", p2.hashCode());
        log.trace("s1.hashCode() is {}", s1.hashCode());
        log.trace("s2.hashCode() is {}", s2.hashCode());
        log.trace("p1.equals(p2) is {}", p1.equals(p2));
        log.trace("p2.equals(p1) is {}", p2.equals(p1));
        log.trace("s1.equals(s2) is {}", s1.equals(s2));
        log.trace("s2.equals(s1) is {}", s2.equals(s1));
    }
}
