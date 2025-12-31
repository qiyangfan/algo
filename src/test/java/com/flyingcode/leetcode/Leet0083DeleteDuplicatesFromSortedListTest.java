package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * Test Class: Leet0083DeleteDuplicatesFromSortedList
 * Uses JUnit 5 to test the correctness of deleting duplicates from sorted linked list algorithm
 */
class Leet0083DeleteDuplicatesFromSortedListTest {

    /**
     * Test basic functionality: standard sorted linked list with duplicates
     */
    @Test
    @DisplayName("Test basic functionality: standard sorted linked list with duplicates")
    void testBasicDeleteDuplicates() {
        // Arrange
        Leet0083DeleteDuplicatesFromSortedList algo = new Leet0083DeleteDuplicatesFromSortedList();
        ListNode head = ListNode.createList(new int[]{1, 1, 2});
        int[] expected = {1, 2};
        
        // Act
        ListNode result = algo.solution(head);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Deleting duplicates from [1->1->2] should result in [1->2]");
    }

    /**
     * Test boundary condition: empty list
     */
    @Test
    @DisplayName("Test boundary condition: empty list")
    void testEmptyList() {
        // Arrange
        Leet0083DeleteDuplicatesFromSortedList algo = new Leet0083DeleteDuplicatesFromSortedList();
        ListNode head = null;
        int[] expected = {};
        
        // Act
        ListNode result = algo.solution(head);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Deleting duplicates from empty list should result in empty list");
    }

    /**
     * Test boundary condition: single node list
     */
    @Test
    @DisplayName("Test boundary condition: single node list")
    void testSingleNode() {
        // Arrange
        Leet0083DeleteDuplicatesFromSortedList algo = new Leet0083DeleteDuplicatesFromSortedList();
        ListNode head = ListNode.createList(new int[]{5});
        int[] expected = {5};
        
        // Act
        ListNode result = algo.solution(head);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Deleting duplicates from single node list should return the same list");
    }

    /**
     * Test special case: all elements are identical
     */
    @Test
    @DisplayName("Test special case: all elements are identical")
    void testAllSameElements() {
        // Arrange
        Leet0083DeleteDuplicatesFromSortedList algo = new Leet0083DeleteDuplicatesFromSortedList();
        ListNode head = ListNode.createList(new int[]{3, 3, 3, 3});
        int[] expected = {3};
        
        // Act
        ListNode result = algo.solution(head);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Deleting duplicates from [3->3->3->3] should result in [3]");
    }

    /**
     * Test special case: no duplicates in list
     */
    @Test
    @DisplayName("Test special case: no duplicates in list")
    void testNoDuplicates() {
        // Arrange
        Leet0083DeleteDuplicatesFromSortedList algo = new Leet0083DeleteDuplicatesFromSortedList();
        ListNode head = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        int[] expected = {1, 2, 3, 4, 5};
        
        // Act
        ListNode result = algo.solution(head);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Deleting duplicates from list with no duplicates should return the same list");
    }

    /**
     * Test special case: multiple consecutive duplicates
     */
    @Test
    @DisplayName("Test special case: multiple consecutive duplicates")
    void testMultipleConsecutiveDuplicates() {
        // Arrange
        Leet0083DeleteDuplicatesFromSortedList algo = new Leet0083DeleteDuplicatesFromSortedList();
        ListNode head = ListNode.createList(new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 4});
        int[] expected = {1, 2, 3, 4};
        
        // Act
        ListNode result = algo.solution(head);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Deleting multiple consecutive duplicates should return list with unique elements");
    }

    /**
     * Test special case: two consecutive duplicate pairs
     */
    @Test
    @DisplayName("Test special case: two consecutive duplicate pairs")
    void testTwoDuplicatePairs() {
        // Arrange
        Leet0083DeleteDuplicatesFromSortedList algo = new Leet0083DeleteDuplicatesFromSortedList();
        ListNode head = ListNode.createList(new int[]{1, 1, 2, 2});
        int[] expected = {1, 2};
        
        // Act
        ListNode result = algo.solution(head);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Deleting two consecutive duplicate pairs should return list with unique elements");
    }
}
