package com.flyingcode.problem;

import com.flyingcode.structure.ListNode;

/**
 * 递归反转链表
 * 该类提供了一个使用递归方式反转单链表的算法实现
 * 算法通过递归思想, 从链表末尾开始反向调整节点指针, 实现链表的反转
 */
public class Algo008ReverseLinkedListRecur {

  /**
   * 算法设计思路:
   * 1. 利用递归的特性, 将问题分解为子问题: 先反转当前节点之后的所有节点, 再处理当前节点
   * 2. 递归终止条件: 当链表为空或只有一个节点时, 直接返回该节点(无需反转)
   * 3. 递归过程:
   * - 先递归反转当前节点的下一个节点开始的子链表
   * - 然后将当前节点的下一个节点的next指针指向当前节点, 完成反转
   * - 最后将当前节点的next指针置为null, 避免形成循环
   * 4. 最终返回反转后的链表头节点
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度:O(n), 其中n是链表的长度
   * 每个节点需要被访问一次, 递归调用的深度为n, 因此总时间复杂度为线性
   * - 空间复杂度:O(n)
   * 由于递归调用需要使用栈空间, 递归的最大深度为n, 因此空间复杂度为O(n)
   */

  /**
   * 使用递归方式反转单链表
   *
   * @param head 输入的单链表头节点
   * @return 反转后的单链表头节点
   */
  public ListNode solution(ListNode head) {
    // 递归终止条件: 空链表或只有一个节点, 直接返回
    if (head == null || head.next == null) {
      return head;
    }

    // 递归反转当前节点之后的子链表, 得到新的头节点
    ListNode newHead = solution(head.next);

    // 将当前节点的下一个节点的next指针指向当前节点, 实现局部反转
    head.next.next = head;

    // 将当前节点的next指针置为null, 避免形成循环链表
    head.next = null;

    // 返回反转后的链表头节点
    return newHead;
  }
}
