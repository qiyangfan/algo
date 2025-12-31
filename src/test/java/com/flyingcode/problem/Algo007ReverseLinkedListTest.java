package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * 测试类: Algo007ReverseLinkedList
 * 使用 JUnit 5 测试迭代法反转链表算法的正确性
 */
class Algo007ReverseLinkedListTest {

    /**
     * 测试基本功能: 反转标准链表
     */
    @Test
    @DisplayName("测试基本功能: 反转标准链表")
    void testReverseStandardList() {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = ListNode.createList(nums);
        Algo007ReverseLinkedList algo = new Algo007ReverseLinkedList();
        ListNode newHead = algo.solution(head);

        // 验证反转后的链表:5 -> 4 -> 3 -> 2 -> 1
        assertTrue(ListNode.matchList(newHead, new int[] { 5, 4, 3, 2, 1 }));
    }

    /**
     * 测试边界条件: 空链表
     */
    @Test
    @DisplayName("测试边界条件: 空链表")
    void testReverseEmptyList() {
        Algo007ReverseLinkedList algo = new Algo007ReverseLinkedList();
        ListNode result = algo.solution(null);
        assertNull(result);
    }

    /**
     * 测试边界条件: 单节点链表
     */
    @Test
    @DisplayName("测试边界条件: 单节点链表")
    void testReverseSingleElement() {
        ListNode head = new ListNode(1);
        Algo007ReverseLinkedList algo = new Algo007ReverseLinkedList();
        ListNode result = algo.solution(head);
        assertTrue(ListNode.matchList(result, new int[] { 1 }));
    }

    /**
     * 测试双节点链表
     */
    @Test
    @DisplayName("测试双节点链表")
    void testReverseTwoElements() {
        int[] nums = { 1, 2 };
        ListNode head = ListNode.createList(nums);
        Algo007ReverseLinkedList algo = new Algo007ReverseLinkedList();
        ListNode newHead = algo.solution(head);

        assertTrue(ListNode.matchList(newHead, new int[] { 2, 1 }));
    }
}
