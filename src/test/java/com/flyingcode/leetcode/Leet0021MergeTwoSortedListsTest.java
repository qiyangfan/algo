package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * Test Class: Leet0021MergeTwoSortedLists
 * Uses JUnit 5 to test the correctness of merging two sorted linked lists algorithm
 */
class Leet0021MergeTwoSortedListsTest {

    /**
     * Test basic functionality: two standard sorted linked lists
     */
    @Test
    @DisplayName("Test basic functionality: two standard sorted linked lists")
    void testBasicMerge() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = ListNode.createList(new int[]{1, 2, 4});
        ListNode list2 = ListNode.createList(new int[]{1, 3, 4});
        int[] expected = {1, 1, 2, 3, 4, 4};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging [1->2->4] and [1->3->4] should result in [1->1->2->3->4->4]");
    }

    /**
     * Test boundary condition: first list is empty
     */
    @Test
    @DisplayName("Test boundary condition: first list is empty")
    void testEmptyList1() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = null;
        ListNode list2 = ListNode.createList(new int[]{1, 3, 4});
        int[] expected = {1, 3, 4};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging null and [1->3->4] should result in [1->3->4]");
    }

    /**
     * Test boundary condition: second list is empty
     */
    @Test
    @DisplayName("Test boundary condition: second list is empty")
    void testEmptyList2() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = ListNode.createList(new int[]{1, 2, 4});
        ListNode list2 = null;
        int[] expected = {1, 2, 4};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging [1->2->4] and null should result in [1->2->4]");
    }

    /**
     * Test boundary condition: both lists are empty
     */
    @Test
    @DisplayName("Test boundary condition: both lists are empty")
    void testBothEmpty() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = null;
        ListNode list2 = null;
        int[] expected = {};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging two null lists should result in null");
    }

    /**
     * Test boundary condition: first list has only one node
     */
    @Test
    @DisplayName("Test boundary condition: first list has only one node")
    void testSingleNodeList1() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = ListNode.createList(new int[]{5});
        ListNode list2 = ListNode.createList(new int[]{1, 3, 4});
        int[] expected = {1, 3, 4, 5};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging [5] and [1->3->4] should result in [1->3->4->5]");
    }

    /**
     * Test boundary condition: second list has only one node
     */
    @Test
    @DisplayName("Test boundary condition: second list has only one node")
    void testSingleNodeList2() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = ListNode.createList(new int[]{1, 3, 4});
        ListNode list2 = ListNode.createList(new int[]{5});
        int[] expected = {1, 3, 4, 5};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging [1->3->4] and [5] should result in [1->3->4->5]");
    }

    /**
     * Test special case: all values in first list are smaller than second list
     */
    @Test
    @DisplayName("Test special case: all values in first list are smaller than second list")
    void testAllSmallerList1() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = ListNode.createList(new int[]{1, 2, 3});
        ListNode list2 = ListNode.createList(new int[]{4, 5, 6});
        int[] expected = {1, 2, 3, 4, 5, 6};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging [1->2->3] and [4->5->6] should result in [1->2->3->4->5->6]");
    }

    /**
     * Test special case: all values in second list are smaller than first list
     */
    @Test
    @DisplayName("Test special case: all values in second list are smaller than first list")
    void testAllSmallerList2() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = ListNode.createList(new int[]{4, 5, 6});
        ListNode list2 = ListNode.createList(new int[]{1, 2, 3});
        int[] expected = {1, 2, 3, 4, 5, 6};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging [4->5->6] and [1->2->3] should result in [1->2->3->4->5->6]");
    }

    /**
     * Test special case: two lists have identical values
     */
    @Test
    @DisplayName("Test special case: two lists have identical values")
    void testIdenticalValues() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = ListNode.createList(new int[]{2, 2, 2});
        ListNode list2 = ListNode.createList(new int[]{2, 2, 2});
        int[] expected = {2, 2, 2, 2, 2, 2};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging two lists with all 2s should result in a list with six 2s");
    }

    /**
     * Test special case: alternating small values in two lists
     */
    @Test
    @DisplayName("Test special case: alternating small values in two lists")
    void testAlternatingValues() {
        // Arrange
        Leet0021MergeTwoSortedLists algo = new Leet0021MergeTwoSortedLists();
        ListNode list1 = ListNode.createList(new int[]{1, 3, 5, 7});
        ListNode list2 = ListNode.createList(new int[]{2, 4, 6, 8});
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        
        // Act
        ListNode result = algo.solution(list1, list2);
        
        // Assert
        assertTrue(ListNode.matchList(result, expected), "Merging [1->3->5->7] and [2->4->6->8] should result in [1->2->3->4->5->6->7->8]");
    }
}
