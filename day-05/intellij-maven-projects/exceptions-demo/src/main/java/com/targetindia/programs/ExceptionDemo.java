package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionDemo {

    public static void main(String[] args) {
        log.trace("start of main");

        printQuotient(args);

        log.trace("end of main");
    }

    public static void printQuotient(String[] args) {
        try {
            String input1 = args[0];
            String input2 = args[1];

            int n = Integer.parseInt(input1);
            int d = Integer.parseInt(input2);

            int q = n/d;

            log.trace("division of {} by {} is {}", n, d, q);
        }
        catch(ArrayIndexOutOfBoundsException e){
            log.warn("Two integers required");
        }
        catch(ArithmeticException e) {
            log.warn("Cannot divide by zero.");
        }
        catch(NumberFormatException e){
            log.warn("Please try only with integer inputs");
            return;
        }
        catch (Exception e) {
            log.warn("There was an error while executing this program");
        }
        finally {
            log.trace("Doing some cleanup...");
        }

        log.trace("end of printQuotient() reached");
    }
}
