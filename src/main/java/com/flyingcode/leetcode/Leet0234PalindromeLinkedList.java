package com.flyingcode.leetcode;

import com.flyingcode.structure.ListNode;

/**
 * 回文链表检查
 * 该类提供一个高效的算法, 用于检查单链表是否为回文链表。
 * 算法采用快慢指针法和链表反转技术, 实现O(n)时间复杂度和O(1)空间复杂度。
 */
public class Leet0234PalindromeLinkedList {
  /**
   * 算法设计思路:
   * 1. 边界条件处理: 空链表或只有一个节点直接返回true
   * 2. 找到链表中点: 使用快慢指针法, 快指针每次走两步, 慢指针每次走一步, 当快指针到达末尾时, 慢指针指向中点
   * 3. 反转后半部分链表: 从中点开始反转链表后半部分
   * 4. 比较前半部分和反转后的后半部分: 同时遍历原链表前半部分和反转后的后半部分, 比较对应节点的值
   * 5. 返回比较结果: 如果所有对应节点值相等, 则为回文链表, 返回true; 否则返回false
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中n是链表的长度。
   * 因为需要遍历链表三次: 一次找中点, 一次反转后半部分, 一次比较两部分, 总操作次数为O(n)。
   * - 空间复杂度: O(1)。
   * 只使用了常量级的额外空间, 没有使用额外的数据结构来存储链表元素。
   */

  /**
   * 检查链表是否为回文链表
   * 该方法通过找到链表中点, 反转后半部分链表后与原链表前半部分比较, 来判断是否为回文链表。
   * 算法采用快慢指针法找到中点, 然后使用迭代方式反转链表, 最后进行比较。
   * 时间复杂度为O(n), 空间复杂度为O(1)。
   *
   * @param head 链表的头节点
   * @return 如果链表为回文链表, 返回true; 否则返回false
   */
  public boolean solution(ListNode head) {
    // 边界条件处理: 空链表或只有一个节点, 直接返回true
    if (head == null || head.next == null) {
      return true;
    }
    // 找到链表的中间节点
    ListNode mid = findMid(head);
    // 反转中间节点后的链表
    ListNode reversed = reverse(mid);
    // 比较前半部分和后半部分是否相等
    while (reversed != null) {
      if (head.val != reversed.val) {
        return false;
      }
      head = head.next;
      reversed = reversed.next;
    }
    return true;
  }

  /**
   * 找到链表的中间节点
   * 该方法通过快慢指针法, 快指针每次走两步, 慢指针每次走一步, 当快指针到达链表末尾时, 慢指针指向的节点即为中间节点。
   *
   * @param head 链表的头节点
   * @return 链表的中间节点
   */
  private ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  /**
   * 反转链表
   * 该方法通过迭代方式, 将链表反转。
   *
   * @param head 链表的头节点
   * @return 反转后的链表头节点
   */
  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
