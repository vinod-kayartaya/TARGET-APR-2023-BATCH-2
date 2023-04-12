package com.targetindia.programs;

public class StringDemo {
    public static void main(String[] args) {
        String myName = new String("Vinod");
        String myCity = "Bangalore";

        System.out.println(myName + " lives in " + myCity);
        // strings in the memory are:
        // "Vinod", "Bangalore", " lives in ", " lives in Bangalore", "Vinod lives in Bangalore"

        String name1 = "Shyam", name2 = "Shyam";
        System.out.println(name1 == name2); // reference check

        String name3 = new String("Shyam");
        String name4 = new String("Shyam");
        System.out.println(name1 == name3); // reference check
        System.out.println(name3 == name4); // reference check

        System.out.println(name1.equals(name3)); // value check
        System.out.println(name3.equals(name4)); // value check
        System.out.println(name3.equals("Shyam")); // value check

        System.out.println(name1.toUpperCase()); // Strings are immutable
        System.out.println(name1);

        // you are not changing the value in name1, instead making name1 refer to a different string.
        name1 = name1.toUpperCase(); // name1 refers to a new object
    }
}
