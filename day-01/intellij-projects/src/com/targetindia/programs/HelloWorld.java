package com.targetindia.programs;

// classes from java.lang package are automatically imported. e.g, String, System
import java.util.Date;

// the name of this class becomes com.targetindia.programs.HelloWorld during compilation
public class HelloWorld {
    // during the compilation, Date is replaced with java.util.Date because of the import statement
    Date dt;
    java.sql.Date dt1;
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
