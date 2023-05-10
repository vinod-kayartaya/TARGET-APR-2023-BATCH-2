package com.targetindia.tests;

import com.targetindia.MathUtility;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
class MathUtilityTests {
    MathUtility mu;

    @BeforeAll
    static void first(){
        log.trace("MathUtilityTests.first() called");
    }

    @AfterAll
    static void last(){
        log.trace("MathUtilityTests.last() called");
    }

    @BeforeEach
    void setUp(){
        log.trace("MathUtilityTests.setup() called");
        mu = new MathUtility();
    }

    @AfterEach
    void tearDown(){
        log.trace("MathUtilityTests.tearDown() called");
    }

    @DisplayName("Should give result for valid inputs")
    @Test
    void shouldGiveResultForValidInputs(){
        log.trace("MathUtilityTests.shouldGiveResultForValidInputs() called");
        double actual = mu.addAll("10", "20", "30");
        double expected = 60;
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Should return 0 if no inputs were supplied")
    @Test
    @Disabled
    void shouldReturnZeroForNoInputs(){
        log.trace("MathUtilityTests.shouldReturnZeroForNoInputs() called");
        double actual = mu.addAll();
        double expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should ignore non numeric inputs")
    void shouldIgnoreNonNumericInputs(){
        log.trace("MathUtilityTests.shouldIgnoreNonNumericInputs() called");
        double actual = mu.addAll("10", "20", "vinod", "30");
        double expected = 60;
        Assertions.assertEquals(expected, actual);
    }

    @Nested
    class TestForExceptions {

        @Test
        @DisplayName("Should throw a NullPointerException if a null was part of the input")
        void shouldThrowNullPointerExceptionForNullInput(){
            try{
                mu.addAll("10", "vinod", null, "20");
                Assertions.fail("Was expecting a NullPointerException, but did not catch one");
            }
            catch(NullPointerException e){
                // test passed
                // nothing to do here
            }
        }

        @Test
        void expectingAnExceptionHere(){
            Assertions.assertThrows(NullPointerException.class, ()->{
                mu.addAll("10", "vinod", "20", null, "30");
            });
        }

    }

}
