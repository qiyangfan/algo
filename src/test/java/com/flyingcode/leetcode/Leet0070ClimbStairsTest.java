package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class: Leet0070ClimbStairs
 * Uses JUnit 5 to test the correctness of the climb stairs algorithm
 */
class Leet0070ClimbStairsTest {

    /**
     * Test basic functionality: n = 3
     * Expected: 3 (1+1+1, 1+2, 2+1)
     */
    @Test
    @DisplayName("Test basic functionality: n = 3")
    void testBasicFunctionality3() {
        // Arrange: Prepare test data
        Leet0070ClimbStairs climbStairs = new Leet0070ClimbStairs();
        int n = 3;
        int expected = 3;

        // Act: Execute method under test
        int result = climbStairs.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 3 should return 3 methods");
    }

    /**
     * Test basic functionality: n = 4
     * Expected: 5 (1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2)
     */
    @Test
    @DisplayName("Test basic functionality: n = 4")
    void testBasicFunctionality4() {
        // Arrange: Prepare test data
        Leet0070ClimbStairs climbStairs = new Leet0070ClimbStairs();
        int n = 4;
        int expected = 5;

        // Act: Execute method under test
        int result = climbStairs.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 4 should return 5 methods");
    }

    /**
     * Test basic functionality: n = 5
     * Expected: 8 (fibonacci sequence: 1, 2, 3, 5, 8)
     */
    @Test
    @DisplayName("Test basic functionality: n = 5")
    void testBasicFunctionality5() {
        // Arrange: Prepare test data
        Leet0070ClimbStairs climbStairs = new Leet0070ClimbStairs();
        int n = 5;
        int expected = 8;

        // Act: Execute method under test
        int result = climbStairs.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 5 should return 8 methods");
    }

    /**
     * Test boundary condition: n = 1
     * Expected: 1 (only one way to climb 1 step)
     */
    @Test
    @DisplayName("Test boundary condition: n = 1")
    void testBoundaryCondition1() {
        // Arrange: Prepare test data
        Leet0070ClimbStairs climbStairs = new Leet0070ClimbStairs();
        int n = 1;
        int expected = 1;

        // Act: Execute method under test
        int result = climbStairs.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 1 should return 1 method");
    }

    /**
     * Test boundary condition: n = 2
     * Expected: 2 (two ways: 1+1, 2)
     */
    @Test
    @DisplayName("Test boundary condition: n = 2")
    void testBoundaryCondition2() {
        // Arrange: Prepare test data
        Leet0070ClimbStairs climbStairs = new Leet0070ClimbStairs();
        int n = 2;
        int expected = 2;

        // Act: Execute method under test
        int result = climbStairs.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 2 should return 2 methods");
    }

    /**
     * Test boundary condition: n = 45 (maximum allowed value)
     * Expected: 1836311903 (fibonacci sequence value)
     */
    @Test
    @DisplayName("Test boundary condition: n = 45")
    void testBoundaryCondition45() {
        // Arrange: Prepare test data
        Leet0070ClimbStairs climbStairs = new Leet0070ClimbStairs();
        int n = 45;
        int expected = 1836311903;

        // Act: Execute method under test
        int result = climbStairs.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 45 should return 1836311903 methods");
    }

    /**
     * Test complex scenario: n = 10
     * Expected: 89 (fibonacci sequence value)
     */
    @Test
    @DisplayName("Test complex scenario: n = 10")
    void testComplexScenario10() {
        // Arrange: Prepare test data
        Leet0070ClimbStairs climbStairs = new Leet0070ClimbStairs();
        int n = 10;
        int expected = 89;

        // Act: Execute method under test
        int result = climbStairs.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 10 should return 89 methods");
    }

    /**
     * Test complex scenario: n = 20
     * Expected: 10946 (fibonacci sequence value)
     */
    @Test
    @DisplayName("Test complex scenario: n = 20")
    void testComplexScenario20() {
        // Arrange: Prepare test data
        Leet0070ClimbStairs climbStairs = new Leet0070ClimbStairs();
        int n = 20;
        int expected = 10946;

        // Act: Execute method under test
        int result = climbStairs.solution(n);

        // Assert: Verify results
        assertEquals(expected, result, "n = 20 should return 10946 methods");
    }
}