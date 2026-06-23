package com.example;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculatorFixtureTest {

    Calculator calc;

    // 🟢 SETUP (Arrange common things)
    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup executed");
    }

    // 🟢 TEARDOWN (cleanup after test)
    @After
    public void tearDown() {
        System.out.println("Teardown executed");
    }

    // 🟢 TEST 1 (AAA pattern)
    @Test
    public void testAdd() {

        // ARRANGE (already in setup)

        // ACT
        int result = calc.add(10, 5);

        // ASSERT
        assertEquals(15, result);
    }

    // 🟢 TEST 2 (AAA pattern)
    @Test
    public void testSubtract() {

        int result = calc.subtract(10, 5);

        assertEquals(5, result);
    }

    // 🟢 TEST 3
    @Test
    public void testMultiply() {

        int result = calc.multiply(10, 5);

        assertEquals(50, result);
    }

    // 🟢 TEST 4
    @Test
    public void testDivide() {

        int result = calc.divide(10, 5);

        assertEquals(2, result);
    }
}