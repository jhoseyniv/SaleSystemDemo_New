package com.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10,50);
        assertEquals(60,result);

        double result2 = calculator.add(10.6,50);
        assertEquals(60.6,result2,1);

    }

}
