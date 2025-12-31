package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class: Leet0001TwoSum
 * Uses JUnit 5 to test the correctness of the two sum algorithm
 */
class Leet0001TwoSumTest {

    /**
     * Test basic functionality: standard input with unique solution
     */
    @Test
    @DisplayName("Test basic functionality: standard input")
    void testStandardInput() {
        // Arrange
        Leet0001TwoSum algo = new Leet0001TwoSum();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        // Act
        int[] result = algo.twoSum(nums, target);

        // Assert
        assertArrayEquals(new int[] { 0, 1 }, result, "The sum of elements at indices 0 and 1 (2+7) should equal 9");
    }

    /**
     * Test boundary condition: two elements in array
     */
    @Test
    @DisplayName("Test boundary condition: two elements")
    void testTwoElements() {
        // Arrange
        Leet0001TwoSum algo = new Leet0001TwoSum();
        int[] nums = { 3, 3 };
        int target = 6;

        // Act
        int[] result = algo.twoSum(nums, target);

        // Assert
        assertArrayEquals(new int[] { 0, 1 }, result, "The sum of two identical elements (3+3) should equal 6");
    }

    /**
     * Test boundary condition: elements not at beginning
     */
    @Test
    @DisplayName("Test boundary condition: elements not at beginning")
    void testElementsNotAtBeginning() {
        // Arrange
        Leet0001TwoSum algo = new Leet0001TwoSum();
        int[] nums = { 3, 2, 4 };
        int target = 6;

        // Act
        int[] result = algo.twoSum(nums, target);

        // Assert
        assertArrayEquals(new int[] { 1, 2 }, result, "The sum of elements at indices 1 and 2 (2+4) should equal 6");
    }

    /**
     * Test special case: negative numbers
     */
    @Test
    @DisplayName("Test special case: negative numbers")
    void testNegativeNumbers() {
        // Arrange
        Leet0001TwoSum algo = new Leet0001TwoSum();
        int[] nums = { -1, -2, -3, -4, -5 };
        int target = -8;

        // Act
        int[] result = algo.twoSum(nums, target);

        // Assert
        assertArrayEquals(new int[] { 2, 4 }, result,
                "The sum of elements at indices 2 and 4 (-3+(-5)) should equal -8");
    }

    /**
     * Test special case: contains zero
     */
    @Test
    @DisplayName("Test special case: contains zero")
    void testWithZero() {
        // Arrange
        Leet0001TwoSum algo = new Leet0001TwoSum();
        int[] nums = { 0, 4, 3, 0 };
        int target = 0;

        // Act
        int[] result = algo.twoSum(nums, target);

        // Assert
        assertArrayEquals(new int[] { 0, 3 }, result, "The sum of elements at indices 0 and 3 (0+0) should equal 0");
    }

    /**
     * Test complex scenario: large numbers within int range
     */
    @Test
    @DisplayName("Test complex scenario: large numbers")
    void testLargeNumbers() {
        // Arrange
        Leet0001TwoSum algo = new Leet0001TwoSum();
        int[] nums = { 1000000000, 1147483647, -2000000000, 500000000 };
        int target = -1000000000;

        // Act
        int[] result = algo.twoSum(nums, target);

        // Assert
        assertArrayEquals(new int[] { 0, 2 }, result,
                "The sum of elements at indices 0 and 2 (1000000000+(-2000000000)) should equal -1000000000");
    }

    /**
     * Test complex scenario: multiple potential pairs
     */
    @Test
    @DisplayName("Test complex scenario: multiple potential pairs")
    void testMultiplePotentialPairs() {
        // Arrange
        Leet0001TwoSum algo = new Leet0001TwoSum();
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        int target = 7;

        // Act
        int[] result = algo.twoSum(nums, target);

        // Assert
        assertArrayEquals(new int[] { 2, 3 }, result,
                "The first found valid pair (3+4) should be returned with indices 2 and 3");
    }
}
