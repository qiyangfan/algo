package com.flyingcode.leetcode;

import com.flyingcode.structure.ListNode;

public class Leet0160IntersectionOfTwoLinkedLists {
  /**
   * 求两个链表的交点
   * 时间复杂度：O(N+M)，其中 N 和 M 分别是两个链表的长度
   * 空间复杂度：O(1)
   * 
   * @param headA 第一个链表的头节点
   * @param headB 第二个链表的头节点
   * @return 两个链表的交点，如果没有交点则返回 null
   */
  public ListNode solution(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    ListNode pA = headA;
    ListNode pB = headB;

    // 当 pA 和 pB 相遇时，即为交点；如果没有交点，最终都会指向 null
    while (pA != pB) {
      // 如果 pA 到达末尾，将其指向 headB；否则继续向前移动
      pA = pA == null ? headB : pA.next;
      // 如果 pB 到达末尾，将其指向 headA；否则继续向前移动
      pB = pB == null ? headA : pB.next;
    }

    return pA;
  }
}
