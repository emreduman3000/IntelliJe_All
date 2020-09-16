package com.techproed;

import JUnit.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TestCalculator
{
    private Calculator calculator;
    private Integer firstNumber;
    private int secondNumber;

    private Integer sumResult;
    private Integer multiplyResult;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
        firstNumber = 5;
        secondNumber = 8;

        sumResult = firstNumber + secondNumber;
        multiplyResult = firstNumber * secondNumber;

    }

    @Test
    public void testSum() throws Exception {
        Integer result = calculator.sum(firstNumber,secondNumber);

        assertNotNull(result);
        assertEquals(result, sumResult);

    }

    @Test
    public void testMultiply() throws Exception {
        Integer result =
                calculator.multiply(firstNumber,secondNumber);
        assertNotNull(result);
        assertEquals(result, multiplyResult);
    }

    @After
    public void tearDown() throws Exception {
        multiplyResult = null;
        sumResult = null;
    }
}