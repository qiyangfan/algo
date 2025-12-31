package com.flyingcode.leetcode;

import com.flyingcode.structure.ListNode;

/**
 * 删除排序链表中的重复元素
 * 该类提供一个迭代的算法, 用于删除排序链表中的重复元素, 确保每个元素只出现一次。
 * 算法采用迭代技术, 实现了高效的空间利用, 时间复杂度为 O(n), 空间复杂度为 O(1)。
 */
public class Leet0083DeleteDuplicatesFromSortedList {

  /**
   * 算法设计思路:
   * 1. 边界条件处理: 当链表为空时, 直接返回null
   * 2. 使用指针curr遍历链表, 初始指向头节点
   * 3. 遍历过程中比较当前节点与下一个节点的值:
   * - 如果值相同, 则跳过下一个节点（将curr.next指向curr.next.next）
   * - 如果值不同, 则将curr指针移动到下一个节点
   * 4. 遍历结束后, 返回处理后的链表头节点
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中 n 是链表的长度。
   * 因为每个节点只被访问一次, 总共有 n 个节点需要处理。
   * - 空间复杂度: O(1)。
   * 只使用了常数级的额外空间, 即几个指针变量。
   */

  /**
   * 删除排序链表中的重复元素, 确保每个元素只出现一次。
   * 该方法通过迭代实现, 修改链表的指针连接来去除重复节点, 空间复杂度为O(1)。
   *
   * @param head 排序链表的头节点
   * @return 去重后的排序链表头节点
   */
  public ListNode solution(ListNode head) {
    // 边界条件处理: 空链表直接返回null
    if (head == null) {
      return null;
    }

    // 初始化遍历指针, 指向头节点
    ListNode curr = head;

    // 遍历链表, 直到当前节点的下一个节点为空
    while (curr.next != null) {
      // 如果当前节点与下一个节点的值相同, 跳过下一个节点
      if (curr.val == curr.next.val) {
        curr.next = curr.next.next;
      } else {
        // 如果值不同, 将指针移动到下一个节点
        curr = curr.next;
      }
    }

    // 返回处理后的链表头节点
    return head;
  }
}
