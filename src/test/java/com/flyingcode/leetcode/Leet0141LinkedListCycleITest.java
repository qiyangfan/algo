package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * 测试类: Leet0141LinkedListCycleI
 * 使用JUnit 5测试链表环检测算法的正确性
 */
class Leet0141LinkedListCycleITest {

    /**
     * 测试基本功能: 中间有环的链表
     * 1 -> 2 -> 3 -> 4 -> 5
     * ^ |
     * |_________|
     */
    @Test
    @DisplayName("测试基本功能: 中间有环的链表")
    void testLinkedListWithCycle() {
        // 准备: 创建一个带有环的链表
        Leet0141LinkedListCycleI algo = new Leet0141LinkedListCycleI();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3; // 创建环: 5 -> 3

        // 执行: 调用被测方法
        boolean result = algo.solution(head);

        // 验证: 检查结果是否符合预期
        assertTrue(result, "带有环的链表应该返回true");
    }

    /**
     * 测试边界条件: 空链表
     */
    @Test
    @DisplayName("测试边界条件: 空链表")
    void testEmptyLinkedList() {
        // 准备: 创建空链表
        Leet0141LinkedListCycleI algo = new Leet0141LinkedListCycleI();
        ListNode head = null;

        // 执行: 调用被测方法
        boolean result = algo.solution(head);

        // 验证: 检查结果是否符合预期
        assertFalse(result, "空链表应该返回false");
    }

    /**
     * 测试边界条件: 只有一个节点的链表
     */
    @Test
    @DisplayName("测试边界条件: 单节点链表")
    void testSingleNodeLinkedList() {
        // 准备: 创建单节点链表
        Leet0141LinkedListCycleI algo = new Leet0141LinkedListCycleI();
        ListNode head = new ListNode(1);

        // 执行: 调用被测方法
        boolean result = algo.solution(head);

        // 验证: 检查结果是否符合预期
        assertFalse(result, "单节点链表应该返回false");
    }

    /**
     * 测试边界条件: 两个节点且无环的链表
     */
    @Test
    @DisplayName("测试边界条件: 两个节点无环链表")
    void testTwoNodesWithoutCycle() {
        // 准备: 创建两个节点无环链表
        Leet0141LinkedListCycleI algo = new Leet0141LinkedListCycleI();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        // 执行: 调用被测方法
        boolean result = algo.solution(head);

        // 验证: 检查结果是否符合预期
        assertFalse(result, "两个节点无环链表应该返回false");
    }

    /**
     * 测试边界条件: 两个节点且有环的链表
     */
    @Test
    @DisplayName("测试边界条件: 两个节点有环链表")
    void testTwoNodesWithCycle() {
        // 准备: 创建两个节点有环链表
        Leet0141LinkedListCycleI algo = new Leet0141LinkedListCycleI();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        node2.next = head; // 创建环: 2 -> 1

        // 执行: 调用被测方法
        boolean result = algo.solution(head);

        // 验证: 检查结果是否符合预期
        assertTrue(result, "两个节点有环链表应该返回true");
    }

    /**
     * 测试特殊情况: 无环链表
     */
    @Test
    @DisplayName("测试特殊情况: 无环链表")
    void testLinkedListWithoutCycle() {
        // 准备: 创建无环链表
        Leet0141LinkedListCycleI algo = new Leet0141LinkedListCycleI();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3, 4, 5 });

        // 执行: 调用被测方法
        boolean result = algo.solution(head);

        // 验证: 检查结果是否符合预期
        assertFalse(result, "无环链表应该返回false");
    }

    /**
     * 测试特殊情况: 长度为1的环（节点指向自身）
     */
    @Test
    @DisplayName("测试特殊情况: 长度为1的环")
    void testCycleWithLengthOne() {
        // 准备: 创建长度为1的环链表
        Leet0141LinkedListCycleI algo = new Leet0141LinkedListCycleI();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next.next = node3;
        node3.next = node3; // 创建环: 3 -> 3

        // 执行: 调用被测方法
        boolean result = algo.solution(head);

        // 验证: 检查结果是否符合预期
        assertTrue(result, "长度为1的环应该返回true");
    }

    /**
     * 测试特殊情况: 整个链表都是环
     */
    @Test
    @DisplayName("测试特殊情况: 整个链表都是环")
    void testEntireLinkedListIsCycle() {
        // 准备: 创建整个链表都是环的链表
        Leet0141LinkedListCycleI algo = new Leet0141LinkedListCycleI();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = head; // 创建环: 3 -> 1

        // 执行: 调用被测方法
        boolean result = algo.solution(head);

        // 验证: 检查结果是否符合预期
        assertTrue(result, "整个链表都是环应该返回true");
    }
}
