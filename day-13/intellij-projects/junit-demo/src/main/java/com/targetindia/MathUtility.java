package com.targetindia;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MathUtility {
    public double addAll(String... numbers) {
        double sum = 0;
        for (String number : numbers) {
            try {
                double num = Double.parseDouble(number);
                sum += num;
            } catch (NumberFormatException e) {
                log.warn("error", e);
            }
        }
        return sum;
    }

    public long factorial(int number) {
        long f = 1;
        while (number > 1) {
            f *= number--;
        }
        return f;
    }

}
