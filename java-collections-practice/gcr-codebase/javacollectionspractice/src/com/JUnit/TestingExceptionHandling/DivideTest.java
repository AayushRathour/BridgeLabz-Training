package com.JUnit.TestingExceptionHandling;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivideTest {

    @Test
    void testDivideByZero() {
        Calculator calc = new Calculator();

        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }

    @Test
    void testDivideNormal() {
        Calculator calc = new Calculator();
        int result = calc.divide(10, 2);
        assertEquals(5, result);
    }
}

