package com.flyingcode.problem;

import com.flyingcode.structure.ListNode;

/**
 * 链表环检测
 * 该类提供了一个高效的算法, 用于检测链表中是否存在环
 * 算法采用快慢指针技术(Floyd判圈算法), 实现了线性时间复杂度的检测, 空间复杂度为 O(1)
 * 适用于单链表的环检测场景, 无需额外存储空间
 */
public class Algo020DetectCycle {

  /**
   * 算法设计思路:
   * 1. 利用快慢指针在链表中移动, 快指针每次移动两步, 慢指针每次移动一步
   * 2. 如果链表中存在环, 快指针最终会追上慢指针(两者相遇)
   * 3. 如果链表中不存在环, 快指针会先到达链表末尾
   * 4. 通过判断快慢指针是否相遇来确定链表中是否存在环
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度:O(n), 其中 n 是链表的长度.
   * 因为快指针每次移动两步, 慢指针每次移动一步, 最坏情况下快指针需要遍历整个链表,
   * 当存在环时, 快指针会在环内追上慢指针, 总操作次数是线性的.
   * - 空间复杂度:O(1), 只使用了常量级的额外空间(两个指针变量).
   * 算法不需要额外的数据结构或哈希表来记录访问过的节点.
   */

  /**
   * 检测链表中是否存在环
   *
   * @param head 链表的头节点
   * @return 如果链表中存在环返回 true, 否则返回 false
   */
  public boolean solution(ListNode head) {
    // 边界条件处理: 空链表或只有一个节点的链表不存在环
    if (head == null || head.next == null) {
      return false;
    }

    // 慢指针 slow: 每次移动一步
    ListNode slow = head;
    // 快指针 fast: 每次移动两步, 初始位置为 head.next 以避免初始位置相同
    ListNode fast = head.next;

    // 快指针能够继续移动的条件:fast 和 fast.next 都不为 null
    while (fast != null && fast.next != null) {
      // 慢指针移动一步
      slow = slow.next;
      // 快指针移动两步
      fast = fast.next.next;

      // 如果快慢指针相遇, 说明链表中存在环
      if (slow == fast) {
        return true;
      }
    }

    // 快指针到达链表末尾, 说明链表中不存在环
    return false;
  }
}
