package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * 测试类: Algo020DetectCycle
 * 使用 JUnit 5 测试快慢指针法检测链表环算法的正确性
 */
class Algo020DetectCycleTest {

    /**
     * 测试边界条件: 空链表
     */
    @Test
    @DisplayName("测试空链表")
    void testEmptyList() {
        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertFalse(algo.solution(null));
    }

    /**
     * 测试边界条件: 单节点链表(无环)
     */
    @Test
    @DisplayName("测试单节点链表无环")
    void testSingleElementNoCycle() {
        ListNode head = new ListNode(1);
        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertFalse(algo.solution(head));
    }

    /**
     * 测试双节点链表(无环)
     */
    @Test
    @DisplayName("测试双节点链表无环")
    void testTwoElementsNoCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertFalse(algo.solution(head));
    }

    /**
     * 测试多节点链表(无环)
     */
    @Test
    @DisplayName("测试多节点链表无环")
    void testMultipleElementsNoCycle() {
        int[] nums = { 1, 2, 3, 4, 5 };
        ListNode head = ListNode.createList(nums);
        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertFalse(algo.solution(head));
    }

    /**
     * 测试单节点链表(有环)
     * 节点的 next 指向自己形成环
     */
    @Test
    @DisplayName("测试单节点链表有环")
    void testSingleElementWithCycle() {
        ListNode head = new ListNode(1);
        head.next = head; // 指向自己形成环
        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertTrue(algo.solution(head));
    }

    /**
     * 测试链表在头部形成环
     * 链表:1 -> 2 -> 3 -> 1 (环)
     */
    @Test
    @DisplayName("测试链表在头部形成环")
    void testCycleAtHead() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // 尾节点指向头节点形成环

        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertTrue(algo.solution(node1));
    }

    /**
     * 测试链表在中间形成环
     * 链表:1 -> 2 -> 3 -> 4 -> 2 (环)
     */
    @Test
    @DisplayName("测试链表在中间形成环")
    void testCycleInMiddle() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // 尾节点指向中间节点形成环

        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertTrue(algo.solution(node1));
    }

    /**
     * 测试链表在尾部形成环
     * 链表:1 -> 2 -> 3 -> 4 -> 5 -> 4 (环)
     */
    @Test
    @DisplayName("测试链表在尾部形成环")
    void testCycleAtEnd() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node4; // 尾节点指向倒数第二个节点形成环

        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertTrue(algo.solution(node1));
    }

    /**
     * 测试较长的无环链表
     */
    @Test
    @DisplayName("测试较长无环链表")
    void testLongListNoCycle() {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i + 1;
        }
        ListNode head = ListNode.createList(nums);
        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertFalse(algo.solution(head));
    }

    /**
     * 测试较长的有环链表
     * 创建100个节点的链表, 让最后一个节点指向第50个节点
     */
    @Test
    @DisplayName("测试较长有环链表")
    void testLongListWithCycle() {
        ListNode[] nodes = new ListNode[100];
        for (int i = 0; i < 100; i++) {
            nodes[i] = new ListNode(i + 1);
        }

        // 连接所有节点
        for (int i = 0; i < 99; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // 最后一个节点指向第50个节点形成环
        nodes[99].next = nodes[49];

        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertTrue(algo.solution(nodes[0]));
    }

    /**
     * 测试双节点链表(有环)
     * 链表:1 -> 2 -> 1 (环)
     */
    @Test
    @DisplayName("测试双节点链表有环")
    void testTwoElementsWithCycle() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;
        node2.next = node1; // 第二个节点指向第一个节点形成环

        Algo020DetectCycle algo = new Algo020DetectCycle();
        assertTrue(algo.solution(node1));
    }
}
