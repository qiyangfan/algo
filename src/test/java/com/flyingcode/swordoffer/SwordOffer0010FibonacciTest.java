package com.flyingcode.swordoffer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class: SwordOffer0010Fibonacci
 * Uses JUnit 5 to test the correctness of the Fibonacci sequence algorithm
 */
class SwordOffer0010FibonacciTest {

    /**
     * Test basic functionality: n = 2
     * Expected: 1 (F(2) = F(1) + F(0) = 1 + 0 = 1)
     */
    @Test
    @DisplayName("Test basic functionality: n = 2")
    void testBasicFunctionality2() {
        // Arrange: Prepare test data
        SwordOffer0010Fibonacci fibonacci = new SwordOffer0010Fibonacci();
        int n = 2;
        int expected = 1;

        // Act: Execute method under test
        int result = fibonacci.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 2 should return 1");
    }

    /**
     * Test basic functionality: n = 3
     * Expected: 2 (F(3) = F(2) + F(1) = 1 + 1 = 2)
     */
    @Test
    @DisplayName("Test basic functionality: n = 3")
    void testBasicFunctionality3() {
        // Arrange: Prepare test data
        SwordOffer0010Fibonacci fibonacci = new SwordOffer0010Fibonacci();
        int n = 3;
        int expected = 2;

        // Act: Execute method under test
        int result = fibonacci.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 3 should return 2");
    }

    /**
     * Test basic functionality: n = 4
     * Expected: 3 (F(4) = F(3) + F(2) = 2 + 1 = 3)
     */
    @Test
    @DisplayName("Test basic functionality: n = 4")
    void testBasicFunctionality4() {
        // Arrange: Prepare test data
        SwordOffer0010Fibonacci fibonacci = new SwordOffer0010Fibonacci();
        int n = 4;
        int expected = 3;

        // Act: Execute method under test
        int result = fibonacci.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 4 should return 3");
    }

    /**
     * Test basic functionality: n = 5
     * Expected: 5 (F(5) = F(4) + F(3) = 3 + 2 = 5)
     */
    @Test
    @DisplayName("Test basic functionality: n = 5")
    void testBasicFunctionality5() {
        // Arrange: Prepare test data
        SwordOffer0010Fibonacci fibonacci = new SwordOffer0010Fibonacci();
        int n = 5;
        int expected = 5;

        // Act: Execute method under test
        int result = fibonacci.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 5 should return 5");
    }

    /**
     * Test boundary condition: n = 0
     * Expected: 0 (F(0) = 0 by definition)
     */
    @Test
    @DisplayName("Test boundary condition: n = 0")
    void testBoundaryCondition0() {
        // Arrange: Prepare test data
        SwordOffer0010Fibonacci fibonacci = new SwordOffer0010Fibonacci();
        int n = 0;
        int expected = 0;

        // Act: Execute method under test
        int result = fibonacci.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 0 should return 0");
    }

    /**
     * Test boundary condition: n = 1
     * Expected: 1 (F(1) = 1 by definition)
     */
    @Test
    @DisplayName("Test boundary condition: n = 1")
    void testBoundaryCondition1() {
        // Arrange: Prepare test data
        SwordOffer0010Fibonacci fibonacci = new SwordOffer0010Fibonacci();
        int n = 1;
        int expected = 1;

        // Act: Execute method under test
        int result = fibonacci.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 1 should return 1");
    }

    /**
     * Test boundary condition: n = 45 (maximum allowed value)
     * Expected: 1134903170 (F(45) = 1134903170)
     */
    @Test
    @DisplayName("Test boundary condition: n = 45")
    void testBoundaryCondition45() {
        // Arrange: Prepare test data
        SwordOffer0010Fibonacci fibonacci = new SwordOffer0010Fibonacci();
        int n = 45;
        int expected = 1134903170;

        // Act: Execute method under test
        int result = fibonacci.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 45 should return 1134903170");
    }

    /**
     * Test complex scenario: n = 10
     * Expected: 55 (F(10) = 55)
     */
    @Test
    @DisplayName("Test complex scenario: n = 10")
    void testComplexScenario10() {
        // Arrange: Prepare test data
        SwordOffer0010Fibonacci fibonacci = new SwordOffer0010Fibonacci();
        int n = 10;
        int expected = 55;

        // Act: Execute method under test
        int result = fibonacci.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 10 should return 55");
    }

    /**
     * Test complex scenario: n = 20
     * Expected: 6765 (F(20) = 6765)
     */
    @Test
    @DisplayName("Test complex scenario: n = 20")
    void testComplexScenario20() {
        // Arrange: Prepare test data
        SwordOffer0010Fibonacci fibonacci = new SwordOffer0010Fibonacci();
        int n = 20;
        int expected = 6765;

        // Act: Execute method under test
        int result = fibonacci.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 20 should return 6765");
    }
}