
package com.junit;

import org.junit.jupiter.api.Test;

import com.junit.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();

        int result = calculator.add(10, 20);
        
        System.out.println("Result: " + result);

        assertEquals(30, result);
    }
}
