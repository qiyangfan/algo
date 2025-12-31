package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class: Leet0088MergeSortedArrays
 * Uses JUnit 5 to test the correctness of the merge sorted arrays algorithm
 */
class Leet0088MergeSortedArraysTest {

    /**
     * Test basic functionality: merge two non-empty arrays
     */
    @Test
    @DisplayName("Test basic functionality: merge two non-empty arrays")
    void testMergeTwoNonEmptyArrays() {
        // Arrange
        Leet0088MergeSortedArrays algo = new Leet0088MergeSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};
        
        // Act
        algo.solution(nums1, m, nums2, n);
        
        // Assert
        assertArrayEquals(expected, nums1, "Two non-empty arrays should be merged correctly");
    }

    /**
     * Test boundary condition: nums1 has no elements (m=0)
     */
    @Test
    @DisplayName("Test boundary condition: nums1 is empty")
    void testMergeWithEmptyNums1() {
        // Arrange
        Leet0088MergeSortedArrays algo = new Leet0088MergeSortedArrays();
        int[] nums1 = {0, 0, 0};
        int m = 0;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        int[] expected = {1, 2, 3};
        
        // Act
        algo.solution(nums1, m, nums2, n);
        
        // Assert
        assertArrayEquals(expected, nums1, "nums1 with m=0 should be replaced by nums2");
    }

    /**
     * Test boundary condition: nums2 has no elements (n=0)
     */
    @Test
    @DisplayName("Test boundary condition: nums2 is empty")
    void testMergeWithEmptyNums2() {
        // Arrange
        Leet0088MergeSortedArrays algo = new Leet0088MergeSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {1, 2, 3, 0, 0, 0};
        
        // Act
        algo.solution(nums1, m, nums2, n);
        
        // Assert
        assertArrayEquals(expected, nums1, "nums1 should remain unchanged when nums2 is empty");
    }

    /**
     * Test special case: all elements in nums1 are greater than nums2
     */
    @Test
    @DisplayName("Test special case: nums1 elements all greater than nums2")
    void testMergeAllNums1GreaterThanNums2() {
        // Arrange
        Leet0088MergeSortedArrays algo = new Leet0088MergeSortedArrays();
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        int[] expected = {1, 2, 3, 4, 5, 6};
        
        // Act
        algo.solution(nums1, m, nums2, n);
        
        // Assert
        assertArrayEquals(expected, nums1, "All nums2 elements should be inserted before nums1 elements");
    }

    /**
     * Test special case: all elements in nums1 are less than nums2
     */
    @Test
    @DisplayName("Test special case: nums1 elements all less than nums2")
    void testMergeAllNums1LessThanNums2() {
        // Arrange
        Leet0088MergeSortedArrays algo = new Leet0088MergeSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {4, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 3, 4, 5, 6};
        
        // Act
        algo.solution(nums1, m, nums2, n);
        
        // Assert
        assertArrayEquals(expected, nums1, "All nums2 elements should be appended after nums1 elements");
    }

    /**
     * Test special case: arrays with duplicate elements
     */
    @Test
    @DisplayName("Test special case: arrays with duplicate elements")
    void testMergeWithDuplicateElements() {
        // Arrange
        Leet0088MergeSortedArrays algo = new Leet0088MergeSortedArrays();
        int[] nums1 = {2, 2, 3, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 2, 3};
        int n = 4;
        int[] expected = {1, 2, 2, 2, 2, 3, 3};
        
        // Act
        algo.solution(nums1, m, nums2, n);
        
        // Assert
        assertArrayEquals(expected, nums1, "Duplicate elements should be merged correctly");
    }

    /**
     * Test complex scenario: one array has only one element
     */
    @Test
    @DisplayName("Test complex scenario: single element arrays")
    void testMergeSingleElementArrays() {
        // Arrange
        Leet0088MergeSortedArrays algo = new Leet0088MergeSortedArrays();
        int[] nums1 = {5, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        int[] expected = {1, 5};
        
        // Act
        algo.solution(nums1, m, nums2, n);
        
        // Assert
        assertArrayEquals(expected, nums1, "Single element arrays should be merged correctly");
    }

    /**
     * Test complex scenario: large arrays
     */
    @Test
    @DisplayName("Test complex scenario: large arrays")
    void testMergeLargeArrays() {
        // Arrange
        Leet0088MergeSortedArrays algo = new Leet0088MergeSortedArrays();
        int[] nums1 = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
        int m = 5;
        int[] nums2 = {2, 4, 6, 8, 10};
        int n = 5;
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Act
        algo.solution(nums1, m, nums2, n);
        
        // Assert
        assertArrayEquals(expected, nums1, "Large arrays should be merged correctly");
    }
}