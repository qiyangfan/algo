package com.flyingcode.leetcode;

import com.flyingcode.structure.ListNode;

/**
 * 链表的中间节点
 * 该类提供一个高效的算法, 用于查找单链表的中间节点。
 * 算法采用快慢指针技术, 实现O(n)时间复杂度和O(1)空间复杂度。
 */
public class Leet0876MiddleOfTheLinkedList {
  /**
   * 算法设计思路:
   * 1. 初始化快慢指针: 慢指针(slow)和快指针(fast)都指向链表头节点
   * 2. 移动指针: 慢指针每次移动1步, 快指针每次移动2步
   * 3. 判断终止条件: 当快指针到达链表末尾(fast == null 或 fast.next == null)时停止
   * 4. 返回结果: 此时慢指针指向的节点即为链表的中间节点
   * - 奇数长度链表: 慢指针指向正中间节点
   * - 偶数长度链表: 慢指针指向中间两个节点的第二个
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中n是链表的长度。
   * 因为快指针最多遍历链表一次, 慢指针最多遍历链表一半, 总操作次数是线性的。
   * - 空间复杂度: O(1), 只使用了两个指针变量, 不随输入规模增长。
   */

  /**
   * 找到链表的中间节点
   * 该方法通过快慢指针法, 快指针每次走两步, 慢指针每次走一步, 当快指针到达链表末尾时, 慢指针指向的节点即为中间节点。
   *
   * @param head 链表的头节点
   * @return 链表的中间节点, 对于偶数长度链表返回中间两个节点的第二个
   */
  public ListNode solution(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
