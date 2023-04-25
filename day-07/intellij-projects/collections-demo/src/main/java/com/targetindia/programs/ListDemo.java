package com.targetindia.programs;

import com.targetindia.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@Slf4j
public class ListDemo {

    // always create variables of interface to promote polymorphism.
    // especially function arguments and return types
    static void printListContent(List<?> list ){
        for(Object obj: list){
            log.trace(obj.toString());
        }
    }

    public static void main(String[] args) {
        List<String>  names = new ArrayList<> ();
        names.add("Vinod");
        names.add("Shyam");
        names.add("Kiran");
        names.add("Vinod");
        names.add("Kishore");
        names.add(5, "Rahul");
        names.set(names.size()-1, names.get(names.size()-1).toUpperCase());
        // names.remove("Vinod");
        names.remove(4);
        printListContent(names);
        log.trace("names.contains(\"Vishal\") is {}", names.contains("Vishal"));
        log.trace("names.contains(\"Vinod\") is {}", names.contains("Vinod"));


        List<Integer> nums = new LinkedList<>();
        nums.add(123);
        nums.add(12);
        nums.add(14);
        for(int i=100; i<=1000; i+=75){
            nums.add(0, i);
        }
        printListContent(nums);

        Vector<Person> people = new Vector<>();
        people.add(new Person("Vinod", "Bangalore"));
        people.add(new Person("John doe", "Dallas"));
        people.add(new Person("Kishore", "Vasco"));
        printListContent(people);
        Person p = new Person("Kishore", "Vasco");
        log.trace("people.contains(p) is {}", people.contains(p));
        log.trace("people.contains(null) is {}", people.contains(null));
        log.trace("people.contains(people.get(0)) is {}", people.contains(people.get(0)));

    }
}
