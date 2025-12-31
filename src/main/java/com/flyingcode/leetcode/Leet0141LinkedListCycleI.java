package com.flyingcode.leetcode;

import com.flyingcode.structure.ListNode;

/**
 * 链表环形检测
 * 该类提供一个高效的算法, 用于检测单链表中是否存在环结构.
 * 算法采用快慢指针技术, 实现了线性时间复杂度和常量空间复杂度.
 */
public class Leet0141LinkedListCycleI {

  /**
   * 算法设计思路:
   * 1. 使用快慢指针技术(龟兔赛跑算法), 其中慢指针每次移动1步, 快指针每次移动2步
   * 2. 边界条件处理: 空链表或只有一个节点的链表一定没有环, 直接返回false
   * 3. 初始化快慢指针: 慢指针指向头节点, 快指针指向头节点的下一个节点
   * 4. 进入循环: 当快慢指针不相遇时, 持续移动指针
   * 5. 循环内检查: 若快指针到达链表末尾(null), 说明链表无环, 返回false
   * 6. 若快慢指针相遇, 说明链表存在环, 返回true
   *
   * 关键技术点:
   * - 快慢指针技术利用环的特性, 快指针会在有限步内追上慢指针
   * - 时间复杂度O(n), 空间复杂度O(1), 无需额外存储空间
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中 n 是链表的节点数量.
   * 若链表无环, 快指针最多遍历n次就会到达末尾;
   * 若链表有环, 快慢指针最多在环内循环n次就会相遇.
   * - 空间复杂度: O(1), 只使用了两个指针变量, 不随输入规模增长.
   */

  /**
   * 检测单链表中是否存在环结构
   *
   * @param head 链表的头节点
   * @return true表示链表存在环, false表示链表无环
   */
  public boolean solution(ListNode head) {
    // 边界条件: 空链表或只有一个节点的链表一定没有环
    if (head == null || head.next == null) {
      return false;
    }

    // 初始化快慢指针: 慢指针(slow)每次移动1步, 快指针(fast)每次移动2步
    ListNode slow = head;
    ListNode fast = head.next;

    // 当快慢指针不相遇时, 持续移动指针
    while (slow != fast) {
      // 若快指针到达链表末尾, 说明链表无环
      if (fast == null || fast.next == null) {
        return false;
      }
      // 慢指针移动1步
      slow = slow.next;
      // 快指针移动2步
      fast = fast.next.next;
    }

    // 快慢指针相遇, 说明链表存在环
    return true;
  }
}
