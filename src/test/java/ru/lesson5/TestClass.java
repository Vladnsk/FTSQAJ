package ru.lesson5;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.lesson5.Math.*;

public class TestClass {
    @Test
    public void testRootPositiveNumber() {
        assertEquals("Wrong answer!", root(9), (double) 3, 0);
    }

    @Test
    public void testRootZero() {
        assertEquals("Wrong answer!", root(0), (double) 0, 0);
    }

    @Test
    public void testRootNegativeNumber() {
        try {
            root(-1);
            Assert.assertTrue(false);
        } catch (ArithmeticException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testSqrtPositiveNumber() {
        assertEquals("Wrong answer!", square(5), (double) 25, 0);
    }

    @Test
    public void testSqrtNegativeNumber() {
        assertEquals("Wrong answer!", square(-5), (double) 25, 0);
    }

    @Test
    public void testSqrtZero() {
        assertEquals("Wrong answer!", square(0), (double) 0, 0);
    }

    @Test
    public void testCos() {
        assertEquals("Wrong answer!", cos(1), 0.54, 0.01);
    }

    @Test
    public void testFactorialPositiveNumber() {
        assertEquals("Wrong answer!", factorial(5), (double) 120, 0);
    }

    @Test
    public void testFactorialNegativeNumber() {
        try {
            factorial(-1);
            Assert.assertTrue(false);
        } catch (ArithmeticException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testFactorialZero() {
        assertEquals("Wrong answer!", factorial(0), (double) 0, 0);
    }

    @Test
    public void testFactorialRecPositiveNumber() {
        assertEquals("Wrong answer!", factorialRec(5), (double) 120, 0);
    }

    @Test
    public void testFactorialRecNegativeNumber() {
        try {
            factorialRec(-1);
            Assert.assertTrue(false);
        } catch (ArithmeticException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testFactorialRecZero() {
        assertEquals("Wrong answer!", factorialRec(0), (double) 0, 0);
    }
}
