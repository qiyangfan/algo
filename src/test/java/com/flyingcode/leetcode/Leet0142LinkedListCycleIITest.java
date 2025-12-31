package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * 测试类: Leet0142LinkedListCycleII
 * 使用JUnit 5测试链表环入口检测算法的正确性
 */
class Leet0142LinkedListCycleIITest {

    /**
     * 测试基本功能: 中间有环的链表, 找到环入口
     * 1 -> 2 -> 3 -> 4 -> 5
     * ^ |
     * |_________|
     * 环入口为节点3
     */
    @Test
    @DisplayName("测试基本功能: 中间有环的链表, 找到环入口")
    void testLinkedListWithCycleMiddle() {
        // 准备: 创建一个带有环的链表, 环入口为节点3
        Leet0142LinkedListCycleII algo = new Leet0142LinkedListCycleII();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3); // 环入口
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3; // 创建环: 5 -> 3

        // 执行: 调用被测方法
        ListNode result = algo.solution(head);

        // 验证: 检查结果是否为环入口节点3
        assertSame(node3, result, "带有环的链表, 环入口应该是节点3");
    }

    /**
     * 测试边界条件: 空链表
     */
    @Test
    @DisplayName("测试边界条件: 空链表")
    void testEmptyLinkedList() {
        // 准备: 创建空链表
        Leet0142LinkedListCycleII algo = new Leet0142LinkedListCycleII();
        ListNode head = null;

        // 执行: 调用被测方法
        ListNode result = algo.solution(head);

        // 验证: 检查结果是否为null
        assertNull(result, "空链表应该返回null");
    }

    /**
     * 测试边界条件: 单节点链表
     */
    @Test
    @DisplayName("测试边界条件: 单节点链表")
    void testSingleNodeLinkedList() {
        // 准备: 创建单节点链表
        Leet0142LinkedListCycleII algo = new Leet0142LinkedListCycleII();
        ListNode head = new ListNode(1);

        // 执行: 调用被测方法
        ListNode result = algo.solution(head);

        // 验证: 检查结果是否为null
        assertNull(result, "单节点链表应该返回null");
    }

    /**
     * 测试边界条件: 两个节点且无环的链表
     */
    @Test
    @DisplayName("测试边界条件: 两个节点无环链表")
    void testTwoNodesWithoutCycle() {
        // 准备: 创建两个节点无环链表
        Leet0142LinkedListCycleII algo = new Leet0142LinkedListCycleII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        // 执行: 调用被测方法
        ListNode result = algo.solution(head);

        // 验证: 检查结果是否为null
        assertNull(result, "两个节点无环链表应该返回null");
    }

    /**
     * 测试边界条件: 两个节点且有环的链表
     * 1 -> 2 -> 1
     * 环入口为节点1
     */
    @Test
    @DisplayName("测试边界条件: 两个节点有环链表")
    void testTwoNodesWithCycle() {
        // 准备: 创建两个节点有环链表, 环入口为节点1
        Leet0142LinkedListCycleII algo = new Leet0142LinkedListCycleII();
        ListNode head = new ListNode(1); // 环入口
        ListNode node2 = new ListNode(2);
        head.next = node2;
        node2.next = head; // 创建环: 2 -> 1

        // 执行: 调用被测方法
        ListNode result = algo.solution(head);

        // 验证: 检查结果是否为环入口节点1
        assertSame(head, result, "两个节点有环链表, 环入口应该是节点1");
    }

    /**
     * 测试特殊情况: 无环链表
     */
    @Test
    @DisplayName("测试特殊情况: 无环链表")
    void testLinkedListWithoutCycle() {
        // 准备: 创建无环链表
        Leet0142LinkedListCycleII algo = new Leet0142LinkedListCycleII();
        ListNode head = ListNode.createList(new int[] { 1, 2, 3, 4, 5 });

        // 执行: 调用被测方法
        ListNode result = algo.solution(head);

        // 验证: 检查结果是否为null
        assertNull(result, "无环链表应该返回null");
    }

    /**
     * 测试特殊情况: 长度为1的环（节点指向自身）
     * 1 -> 2 -> 3 -> 3
     * 环入口为节点3
     */
    @Test
    @DisplayName("测试特殊情况: 长度为1的环")
    void testCycleWithLengthOne() {
        // 准备: 创建长度为1的环链表, 环入口为节点3
        Leet0142LinkedListCycleII algo = new Leet0142LinkedListCycleII();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3); // 环入口
        head.next = node2;
        node2.next = node3;
        node3.next = node3; // 创建环: 3 -> 3

        // 执行: 调用被测方法
        ListNode result = algo.solution(head);

        // 验证: 检查结果是否为环入口节点3
        assertSame(node3, result, "长度为1的环, 环入口应该是节点3");
    }

    /**
     * 测试特殊情况: 整个链表都是环
     * 1 -> 2 -> 3 -> 1
     * 环入口为节点1
     */
    @Test
    @DisplayName("测试特殊情况: 整个链表都是环")
    void testEntireLinkedListIsCycle() {
        // 准备: 创建整个链表都是环的链表, 环入口为节点1
        Leet0142LinkedListCycleII algo = new Leet0142LinkedListCycleII();
        ListNode head = new ListNode(1); // 环入口
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = head; // 创建环: 3 -> 1

        // 执行: 调用被测方法
        ListNode result = algo.solution(head);

        // 验证: 检查结果是否为环入口节点1
        assertSame(head, result, "整个链表都是环, 环入口应该是节点1");
    }
}
