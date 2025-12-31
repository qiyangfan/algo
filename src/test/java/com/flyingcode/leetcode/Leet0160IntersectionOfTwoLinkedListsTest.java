package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.flyingcode.structure.ListNode;

/**
 * 测试类: Leet0160IntersectionOfTwoLinkedLists
 * 使用JUnit 5测试两个链表交点查找算法的正确性
 */
class Leet0160IntersectionOfTwoLinkedListsTest {

    /**
     * 测试基本功能: 两个链表有交点
     * 链表A: 1 -> 2 -> 3
     *                 \n     *                  6 -> 7 -> 8
     *                 /
     * 链表B:     4 -> 5
     */
    @Test
    @DisplayName("测试基本功能: 两个链表有交点")
    void testIntersectingLinkedLists() {
        // 准备: 创建两个有交点的链表
        Leet0160IntersectionOfTwoLinkedLists algo = new Leet0160IntersectionOfTwoLinkedLists();
        
        // 创建公共部分
        ListNode common6 = new ListNode(6);
        ListNode common7 = new ListNode(7);
        ListNode common8 = new ListNode(8);
        common6.next = common7;
        common7.next = common8;
        
        // 创建链表A: 1 -> 2 -> 3 -> 6 -> 7 -> 8
        ListNode headA = new ListNode(1);
        ListNode node2A = new ListNode(2);
        ListNode node3A = new ListNode(3);
        headA.next = node2A;
        node2A.next = node3A;
        node3A.next = common6;
        
        // 创建链表B: 4 -> 5 -> 6 -> 7 -> 8
        ListNode headB = new ListNode(4);
        ListNode node5B = new ListNode(5);
        headB.next = node5B;
        node5B.next = common6;
        
        // 执行: 调用被测方法
        ListNode result = algo.solution(headA, headB);
        
        // 验证: 检查结果是否为预期的交点
        assertEquals(common6, result, "两个有交点的链表应该返回正确的交点");
        assertEquals(6, result.val, "交点的值应该是6");
    }

    /**
     * 测试边界条件: 两个链表没有交点
     * 链表A: 1 -> 2 -> 3
     * 链表B: 4 -> 5 -> 6
     */
    @Test
    @DisplayName("测试边界条件: 两个链表没有交点")
    void testNonIntersectingLinkedLists() {
        // 准备: 创建两个没有交点的链表
        Leet0160IntersectionOfTwoLinkedLists algo = new Leet0160IntersectionOfTwoLinkedLists();
        
        // 创建链表A: 1 -> 2 -> 3
        ListNode headA = ListNode.createList(new int[] { 1, 2, 3 });
        
        // 创建链表B: 4 -> 5 -> 6
        ListNode headB = ListNode.createList(new int[] { 4, 5, 6 });
        
        // 执行: 调用被测方法
        ListNode result = algo.solution(headA, headB);
        
        // 验证: 检查结果是否为null
        assertNull(result, "两个没有交点的链表应该返回null");
    }

    /**
     * 测试边界条件: 其中一个链表为空
     */
    @Test
    @DisplayName("测试边界条件: 其中一个链表为空")
    void testOneEmptyLinkedList() {
        // 准备: 创建一个空链表和一个非空链表
        Leet0160IntersectionOfTwoLinkedLists algo = new Leet0160IntersectionOfTwoLinkedLists();
        
        // 创建链表A: 1 -> 2 -> 3
        ListNode headA = ListNode.createList(new int[] { 1, 2, 3 });
        
        // 创建链表B: null
        ListNode headB = null;
        
        // 执行: 调用被测方法
        ListNode result1 = algo.solution(headA, headB);
        ListNode result2 = algo.solution(headB, headA);
        
        // 验证: 检查结果是否为null
        assertNull(result1, "其中一个链表为空时应该返回null");
        assertNull(result2, "其中一个链表为空时应该返回null");
    }

    /**
     * 测试边界条件: 两个链表都为空
     */
    @Test
    @DisplayName("测试边界条件: 两个链表都为空")
    void testBothEmptyLinkedLists() {
        // 准备: 创建两个空链表
        Leet0160IntersectionOfTwoLinkedLists algo = new Leet0160IntersectionOfTwoLinkedLists();
        
        // 创建链表A: null
        ListNode headA = null;
        
        // 创建链表B: null
        ListNode headB = null;
        
        // 执行: 调用被测方法
        ListNode result = algo.solution(headA, headB);
        
        // 验证: 检查结果是否为null
        assertNull(result, "两个链表都为空时应该返回null");
    }

    /**
     * 测试特殊情况: 两个链表在头部相交
     * 链表A和链表B完全相同
     */
    @Test
    @DisplayName("测试特殊情况: 两个链表在头部相交")
    void testIntersectionAtHead() {
        // 准备: 创建两个在头部相交的链表
        Leet0160IntersectionOfTwoLinkedLists algo = new Leet0160IntersectionOfTwoLinkedLists();
        
        // 创建链表: 1 -> 2 -> 3
        ListNode head = ListNode.createList(new int[] { 1, 2, 3 });
        
        // 链表A和链表B指向同一个头节点
        ListNode headA = head;
        ListNode headB = head;
        
        // 执行: 调用被测方法
        ListNode result = algo.solution(headA, headB);
        
        // 验证: 检查结果是否为头节点
        assertEquals(head, result, "两个链表在头部相交时应该返回头节点");
        assertEquals(1, result.val, "交点的值应该是1");
    }

    /**
     * 测试特殊情况: 两个链表在末尾相交
     * 链表A: 1 -> 2 -> 3
     * 链表B:     4 -> 5 -> 3
     */
    @Test
    @DisplayName("测试特殊情况: 两个链表在末尾相交")
    void testIntersectionAtTail() {
        // 准备: 创建两个在末尾相交的链表
        Leet0160IntersectionOfTwoLinkedLists algo = new Leet0160IntersectionOfTwoLinkedLists();
        
        // 创建公共尾部节点
        ListNode common3 = new ListNode(3);
        
        // 创建链表A: 1 -> 2 -> 3
        ListNode headA = new ListNode(1);
        ListNode node2A = new ListNode(2);
        headA.next = node2A;
        node2A.next = common3;
        
        // 创建链表B: 4 -> 5 -> 3
        ListNode headB = new ListNode(4);
        ListNode node5B = new ListNode(5);
        headB.next = node5B;
        node5B.next = common3;
        
        // 执行: 调用被测方法
        ListNode result = algo.solution(headA, headB);
        
        // 验证: 检查结果是否为尾部节点
        assertEquals(common3, result, "两个链表在末尾相交时应该返回尾部节点");
        assertEquals(3, result.val, "交点的值应该是3");
    }
}
