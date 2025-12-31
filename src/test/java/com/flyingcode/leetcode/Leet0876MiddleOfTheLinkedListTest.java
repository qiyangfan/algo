package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * 测试类: Leet0876MiddleOfTheLinkedList
 * 使用JUnit 5测试链表中点算法的正确性
 */
class Leet0876MiddleOfTheLinkedListTest {

    /**
     * 测试基本功能: 奇数长度链表
     * 示例: 1 -> 2 -> 3 -> 4 -> 5, 预期中点: 3
     */
    @Test
    @DisplayName("测试基本功能: 奇数长度链表")
    void testOddLengthList() {
        Leet0876MiddleOfTheLinkedList algo = new Leet0876MiddleOfTheLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3, 4, 5 });
        ListNode result = algo.solution(head);
        assertEquals(3, result.val, "奇数长度链表[1,2,3,4,5]应该返回值为3的中间节点");
    }

    /**
     * 测试基本功能: 偶数长度链表
     * 示例: 1 -> 2 -> 3 -> 4, 预期中点: 3
     */
    @Test
    @DisplayName("测试基本功能: 偶数长度链表")
    void testEvenLengthList() {
        Leet0876MiddleOfTheLinkedList algo = new Leet0876MiddleOfTheLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3, 4 });
        ListNode result = algo.solution(head);
        assertEquals(3, result.val, "偶数长度链表[1,2,3,4]应该返回值为3的第二个中间节点");
    }

    /**
     * 测试边界条件: 单节点链表
     * 示例: 1, 预期中点: 1
     */
    @Test
    @DisplayName("测试边界条件: 单节点链表")
    void testSingleNodeList() {
        Leet0876MiddleOfTheLinkedList algo = new Leet0876MiddleOfTheLinkedList();
        ListNode head = ListNode.createList(new int[] { 1 });
        ListNode result = algo.solution(head);
        assertEquals(1, result.val, "单节点链表[1]应该返回自身作为中间节点");
    }

    /**
     * 测试边界条件: 两个节点链表
     * 示例: 1 -> 2, 预期中点: 2
     */
    @Test
    @DisplayName("测试边界条件: 两个节点链表")
    void testTwoNodesList() {
        Leet0876MiddleOfTheLinkedList algo = new Leet0876MiddleOfTheLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2 });
        ListNode result = algo.solution(head);
        assertEquals(2, result.val, "两个节点链表[1,2]应该返回第二个节点作为中间节点");
    }

    /**
     * 测试边界条件: 三个节点链表
     * 示例: 1 -> 2 -> 3, 预期中点: 2
     */
    @Test
    @DisplayName("测试边界条件: 三个节点链表")
    void testThreeNodesList() {
        Leet0876MiddleOfTheLinkedList algo = new Leet0876MiddleOfTheLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3 });
        ListNode result = algo.solution(head);
        assertEquals(2, result.val, "三个节点链表[1,2,3]应该返回值为2的中间节点");
    }

    /**
     * 测试复杂场景: 长奇数长度链表
     * 示例: 1 -> 2 -> ... -> 99 -> 100 -> 101, 预期中点: 51
     */
    @Test
    @DisplayName("测试复杂场景: 长奇数长度链表")
    void testLongOddLengthList() {
        Leet0876MiddleOfTheLinkedList algo = new Leet0876MiddleOfTheLinkedList();
        // 创建从1到101的链表
        int[] nums = new int[101];
        for (int i = 0; i < 101; i++) {
            nums[i] = i + 1;
        }
        ListNode head = ListNode.createList(nums);
        ListNode result = algo.solution(head);
        assertEquals(51, result.val, "长奇数长度链表[1..101]应该返回值为51的中间节点");
    }

    /**
     * 测试复杂场景: 长偶数长度链表
     * 示例: 1 -> 2 -> ... -> 99 -> 100, 预期中点: 51
     */
    @Test
    @DisplayName("测试复杂场景: 长偶数长度链表")
    void testLongEvenLengthList() {
        Leet0876MiddleOfTheLinkedList algo = new Leet0876MiddleOfTheLinkedList();
        // 创建从1到100的链表
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i + 1;
        }
        ListNode head = ListNode.createList(nums);
        ListNode result = algo.solution(head);
        assertEquals(51, result.val, "长偶数长度链表[1..100]应该返回值为51的第二个中间节点");
    }

    /**
     * 测试特殊情况: 所有元素相同
     * 示例: 5 -> 5 -> 5 -> 5 -> 5, 预期中点: 5
     */
    @Test
    @DisplayName("测试特殊情况: 所有元素相同")
    void testAllSameElements() {
        Leet0876MiddleOfTheLinkedList algo = new Leet0876MiddleOfTheLinkedList();
        ListNode head = ListNode.createList(new int[] { 5, 5, 5, 5, 5 });
        ListNode result = algo.solution(head);
        assertEquals(5, result.val, "所有元素相同的链表[5,5,5,5,5]应该返回值为5的中间节点");
    }
}
