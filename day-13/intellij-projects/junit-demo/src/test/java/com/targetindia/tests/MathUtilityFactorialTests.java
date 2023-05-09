package com.targetindia.tests;

import com.targetindia.MathUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathUtilityFactorialTests {

    MathUtility mu;

    @BeforeEach
    void setup() {
        mu = new MathUtility();
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "5, 120", "6, 720", "10, 3628800"})
    void shouldGetFactorial(int input, long expected) {
        long actual = mu.factorial(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"numbers.csv"}, numLinesToSkip = 1)
    void shouldPassForGivenInput(int input, long expected) {
        long actual = mu.factorial(input);
        assertEquals(expected, actual);
    }
}
