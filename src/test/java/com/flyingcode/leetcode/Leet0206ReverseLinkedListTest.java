package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * 测试类: Leet0206ReverseLinkedList
 * 使用JUnit 5测试反转链表算法的正确性
 */
class Leet0206ReverseLinkedListTest {

    /**
     * 测试基本功能: 包含多个元素的标准链表
     */
    @Test
    @DisplayName("测试基本功能: 包含多个元素的标准链表")
    void testStandardLinkedList() {
        // 准备测试数据
        Leet0206ReverseLinkedList algo = new Leet0206ReverseLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3, 4, 5 });
        int[] expected = { 5, 4, 3, 2, 1 };

        // 执行测试方法
        ListNode result = algo.solution(head);

        // 验证结果
        assertTrue(ListNode.matchList(result, expected), "链表[1,2,3,4,5]反转后应该是[5,4,3,2,1]");
    }

    /**
     * 测试边界条件: 空链表
     */
    @Test
    @DisplayName("测试边界条件: 空链表")
    void testEmptyList() {
        // 准备测试数据
        Leet0206ReverseLinkedList algo = new Leet0206ReverseLinkedList();
        ListNode head = ListNode.createList(new int[] {});
        int[] expected = {};

        // 执行测试方法
        ListNode result = algo.solution(head);

        // 验证结果
        assertTrue(ListNode.matchList(result, expected), "空链表反转后应该仍然为空");
    }

    /**
     * 测试边界条件: 只有一个节点的链表
     */
    @Test
    @DisplayName("测试边界条件: 只有一个节点的链表")
    void testSingleNodeList() {
        // 准备测试数据
        Leet0206ReverseLinkedList algo = new Leet0206ReverseLinkedList();
        ListNode head = ListNode.createList(new int[] { 1 });
        int[] expected = { 1 };

        // 执行测试方法
        ListNode result = algo.solution(head);

        // 验证结果
        assertTrue(ListNode.matchList(result, expected), "单节点链表反转后应该保持不变");
    }

    /**
     * 测试特殊情况: 包含两个节点的链表
     */
    @Test
    @DisplayName("测试特殊情况: 包含两个节点的链表")
    void testTwoNodesList() {
        // 准备测试数据
        Leet0206ReverseLinkedList algo = new Leet0206ReverseLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 2 });
        int[] expected = { 2, 1 };

        // 执行测试方法
        ListNode result = algo.solution(head);

        // 验证结果
        assertTrue(ListNode.matchList(result, expected), "两个节点的链表[1,2]反转后应该是[2,1]");
    }

    /**
     * 测试复杂场景: 长链表
     */
    @Test
    @DisplayName("测试复杂场景: 长链表")
    void testLongLinkedList() {
        // 准备测试数据
        Leet0206ReverseLinkedList algo = new Leet0206ReverseLinkedList();
        ListNode head = ListNode.createList(new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 });
        int[] expected = { 19, 17, 15, 13, 11, 9, 7, 5, 3, 1 };

        // 执行测试方法
        ListNode result = algo.solution(head);

        // 验证结果
        assertTrue(ListNode.matchList(result, expected), "长链表应该被正确反转");
    }
}
