package com.flyingcode.swordoffer;

import com.flyingcode.structure.ListNode;

public class SwordOffer0022KthNodeFromEndOfLinkedList {
  /**
   * 找到链表的倒数第 k 个节点
   * 该方法通过快慢指针法, 快指针先移动 k 步, 然后快慢指针同时移动, 当快指针到达链表末尾时, 慢指针指向的节点即为倒数第 k 个节点。
   *
   * @param head 链表的头节点
   * @param k    倒数第 k 个节点, 从 1 开始计数
   * @return 链表的倒数第 k 个节点, 如果 k 大于链表长度, 返回 null
   */
  public ListNode solution(ListNode head, int k) {
    ListNode slow = head;
    ListNode fast = head;
    // 快指针先移动 k 步
    for (int i = 0; i < k; i++) {
      if (fast == null) {
        // k 大于链表长度, 返回 null
        return null;
      }
      fast = fast.next;
    }
    // 快慢指针同时移动, 当快指针到达链表末尾时, 慢指针指向的节点即为倒数第 k 个节点
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

}
