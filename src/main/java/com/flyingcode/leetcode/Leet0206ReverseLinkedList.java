package com.flyingcode.leetcode;

import com.flyingcode.structure.ListNode;

/**
 * 反转链表
 * 该类提供一个高效的算法, 用于反转单向链表.
 * 算法采用迭代方式, 实现了线性时间复杂度和常量空间复杂度.
 */
public class Leet0206ReverseLinkedList {

  /**
   * 算法设计思路:
   * 1. 初始化三个指针: prev指向null, curr指向头节点, next用于临时保存下一个节点
   * 2. 遍历链表, 每次处理一个节点:
   * - 保存当前节点的下一个节点到next
   * - 将当前节点的next指针指向prev, 实现反转
   * - 将prev和curr指针都向后移动一位
   * 3. 遍历结束后, prev指向反转后的头节点
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中 n 是链表的长度.
   * 因为只需要遍历链表一次, 每个节点只访问一次, 所以总操作次数是线性的.
   * - 空间复杂度: O(1).
   * 只使用了三个指针变量, 不随输入规模变化而变化.
   */

  /**
   * 反转单向链表
   *
   * @param head 链表的头节点
   * @return 反转后的链表头节点
   */
  public ListNode solution(ListNode head) {
    // 边界条件处理: 空链表或只有一个节点直接返回
    if (head == null || head.next == null) {
      return head;
    }
    // prev初始化为null, 表示反转后的链表尾节点
    ListNode prev = null;
    // curr初始化为头节点, 表示当前处理的节点
    ListNode curr = head;
    // 遍历链表, 逐个反转节点
    while (curr != null) {
      // 保存当前节点的下一个节点, 防止链表断裂
      ListNode next = curr.next;
      // 将当前节点的next指针指向prev, 实现反转
      curr.next = prev;
      // prev指针后移, 指向当前节点
      prev = curr;
      // curr指针后移, 处理下一个节点
      curr = next;
    }
    // 遍历结束后, prev指向反转后的头节点
    return prev;
  }
}
