package com.flyingcode.problem;

import com.flyingcode.structure.ListNode;

/**
 * 反转链表(迭代实现)
 * 该类提供了一个高效的算法, 用于反转单链表的所有节点顺序
 * 算法采用迭代方式实现, 具有线性时间复杂度和常量空间复杂度
 */
public class Algo007ReverseLinkedList {
  /**
   * 算法设计思路:
   * 1. 使用三个指针遍历链表, 分别记录前一个节点, 当前节点和下一个节点
   * 2. 遍历过程中, 将当前节点的指针方向反转, 指向前一个节点
   * 3. 更新三个指针的位置, 继续遍历下一个节点
   * 4. 当遍历结束时, 前一个节点即为反转后的链表头
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度:O(n), 其中 n 是链表的长度
   * 算法需要遍历链表中的每个节点一次, 因此时间复杂度为线性
   * - 空间复杂度:O(1)
   * 只使用了常量级的额外空间(三个指针变量), 没有使用任何与链表长度相关的额外数据结构
   */

  /**
   * 反转给定的单链表, 返回反转后的链表头节点
   *
   * @param head 输入的单链表头节点
   * @return 反转后的单链表头节点
   */
  public ListNode solution(ListNode head) {
    // prev: 记录当前节点的前一个节点, 初始为null(反转后链表的尾节点的next指针为null)
    ListNode prev = null;
    // curr: 记录当前遍历到的节点, 初始为输入链表的头节点
    ListNode curr = head;

    // 遍历链表, 直到当前节点为null(即遍历到原链表的尾节点之后)
    while (curr != null) {
      // 保存当前节点的下一个节点, 防止反转指针后丢失后续链表
      ListNode next = curr.next;
      // 将当前节点的指针反转, 指向前一个节点
      curr.next = prev;
      // 更新前一个节点为当前节点, 为下一次迭代做准备
      prev = curr;
      // 更新当前节点为之前保存的下一个节点, 继续遍历
      curr = next;
    }

    // 遍历结束后,prev指向原链表的尾节点, 即反转后链表的头节点
    return prev;
  }
}
