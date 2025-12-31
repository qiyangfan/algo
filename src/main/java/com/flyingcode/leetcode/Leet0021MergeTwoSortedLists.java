package com.flyingcode.leetcode;

import com.flyingcode.structure.ListNode;

/**
 * 合并两个有序链表
 * 该类提供一个递归的算法, 用于将两个升序排列的链表合并为一个新的升序链表.
 * 算法采用递归技术, 实现了简洁的代码结构, 时间复杂度为 O(n + m), 空间复杂度为 O(n + m).
 */
public class Leet0021MergeTwoSortedLists {

  /**
   * 算法设计思路:
   * 1. 比较两个链表的头节点, 选择值较小的节点作为合并后的头节点
   * 2. 对于选择的头节点, 递归地将剩余部分与另一个链表合并
   * 3. 将合并后的链表连接到当前选择的节点之后
   * 4. 递归终止条件: 当其中一个链表为空时, 直接返回另一个链表
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n + m), 其中 n 和 m 分别是两个链表的长度.
   * 因为每递归一次, 就会处理一个节点, 总共有 n + m 个节点需要处理.
   * - 空间复杂度: O(n + m).
   * 递归调用的栈深度取决于两个链表的总长度, 最坏情况下是 n + m.
   */

  /**
   * 将两个升序链表合并为一个新的升序链表并返回.
   * 新链表是通过拼接给定的两个链表的所有节点组成的.
   *
   * @param list1 第一个升序链表
   * @param list2 第二个升序链表
   * @return 合并后的升序链表
   */
  public ListNode solution(ListNode list1, ListNode list2) {
    // 如果第一个链表为空, 直接返回第二个链表
    if (list1 == null) {
      return list2;
    }
    // 如果第二个链表为空, 直接返回第一个链表
    if (list2 == null) {
      return list1;
    }
    // 比较两个链表的头节点, 选择值较小的节点
    if (list1.val < list2.val) {
      // 递归合并 list1 的剩余部分和 list2
      list1.next = solution(list1.next, list2);
      return list1;
    } else {
      // 递归合并 list1 和 list2 的剩余部分
      list2.next = solution(list1, list2.next);
      return list2;
    }
  }
}
