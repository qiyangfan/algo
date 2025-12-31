package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * 测试类: Leet0234PalindromeLinkedList
 * 使用JUnit 5测试回文链表算法的正确性
 */
class Leet0234PalindromeLinkedListTest {

    /**
     * 测试基本功能: 偶数长度的标准回文链表
     * 示例: 1 -> 2 -> 2 -> 1
     */
    @Test
    @DisplayName("测试基本功能: 偶数长度的标准回文链表")
    void testEvenLengthPalindrome() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2, 2, 1 });
        boolean result = algo.solution(head);
        assertEquals(true, result, "偶数长度链表[1,2,2,1]应该是回文链表");
    }

    /**
     * 测试基本功能: 奇数长度的标准回文链表
     * 示例: 1 -> 2 -> 3 -> 2 -> 1
     */
    @Test
    @DisplayName("测试基本功能: 奇数长度的标准回文链表")
    void testOddLengthPalindrome() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3, 2, 1 });
        boolean result = algo.solution(head);
        assertEquals(true, result, "奇数长度链表[1,2,3,2,1]应该是回文链表");
    }

    /**
     * 测试边界条件: 空链表
     */
    @Test
    @DisplayName("测试边界条件: 空链表")
    void testEmptyList() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] {});
        boolean result = algo.solution(head);
        assertEquals(true, result, "空链表应该是回文链表");
    }

    /**
     * 测试边界条件: 只有一个节点的链表
     */
    @Test
    @DisplayName("测试边界条件: 只有一个节点的链表")
    void testSingleNodeList() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] { 5 });
        boolean result = algo.solution(head);
        assertEquals(true, result, "单节点链表应该是回文链表");
    }

    /**
     * 测试特殊情况: 非回文链表
     */
    @Test
    @DisplayName("测试特殊情况: 非回文链表")
    void testNonPalindromeList() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3, 4, 5 });
        boolean result = algo.solution(head);
        assertEquals(false, result, "非回文链表[1,2,3,4,5]应该返回false");
    }

    /**
     * 测试特殊情况: 所有元素相同的链表
     */
    @Test
    @DisplayName("测试特殊情况: 所有元素相同的链表")
    void testAllSameElements() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] { 3, 3, 3, 3, 3 });
        boolean result = algo.solution(head);
        assertEquals(true, result, "所有元素相同的链表应该是回文链表");
    }

    /**
     * 测试特殊情况: 两个节点的回文链表
     */
    @Test
    @DisplayName("测试特殊情况: 两个节点的回文链表")
    void testTwoNodesPalindrome() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] { 2, 2 });
        boolean result = algo.solution(head);
        assertEquals(true, result, "两个节点的回文链表[2,2]应该返回true");
    }

    /**
     * 测试特殊情况: 两个节点的非回文链表
     */
    @Test
    @DisplayName("测试特殊情况: 两个节点的非回文链表")
    void testTwoNodesNonPalindrome() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] { 2, 3 });
        boolean result = algo.solution(head);
        assertEquals(false, result, "两个节点的非回文链表[2,3]应该返回false");
    }

    /**
     * 测试复杂场景: 长回文链表
     */
    @Test
    @DisplayName("测试复杂场景: 长回文链表")
    void testLongPalindromeList() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
        boolean result = algo.solution(head);
        assertEquals(true, result, "长回文链表应该返回true");
    }

    /**
     * 测试复杂场景: 长非回文链表
     */
    @Test
    @DisplayName("测试复杂场景: 长非回文链表")
    void testLongNonPalindromeList() {
        Leet0234PalindromeLinkedList algo = new Leet0234PalindromeLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 });
        boolean result = algo.solution(head);
        assertEquals(false, result, "长非回文链表应该返回false");
    }
}
