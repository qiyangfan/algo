package com.flyingcode.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用栈实现队列
 * 该类提供一个高效的队列实现, 用于模拟队列的先进先出(FIFO)特性.
 * 算法采用双栈技术, 实现了O(1)均摊时间复杂度的队列操作.
 */
public class Leet0232ImplementQueueUsingStacks {
  /**
   * 算法设计思路:
   * 1. 使用两个栈: 输入栈(inputStack)用于接收新元素, 输出栈(outputStack)用于提供队列元素
   * 2. 入队操作: 直接将元素压入输入栈, 时间复杂度O(1)
   * 3. 出队操作:
   *    - 如果输出栈为空, 将输入栈所有元素弹出并压入输出栈, 此时输出栈顶为最早入队元素
   *    - 从输出栈弹出栈顶元素, 实现FIFO顺序
   * 4. 查看队头元素: 与出队操作类似, 但只查看不弹出
   * 5. 判空操作: 当两个栈都为空时, 队列为空
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: 入队O(1), 出队和查看队头O(1)均摊, 判空O(1)
   *   每个元素最多被压入和弹出栈各两次, 因此均摊时间复杂度为O(1)
   * - 空间复杂度: O(n), 其中n是队列中的元素数量
   *   两个栈最多存储n个元素
   */

  // 输入栈: 用于接收新入队的元素
  private final Deque<Integer> inputStack = new ArrayDeque<>();
  // 输出栈: 用于提供出队的元素, 栈顶为最早入队的元素
  private final Deque<Integer> outputStack = new ArrayDeque<>();

  /**
   * 入队操作
   * 将元素压入输入栈, 确保新元素位于栈底, 符合队列的FIFO特性.
   *
   * @param x 要入队的元素
   */
  public void push(int x) {
    inputStack.addLast(x);
  }

  /**
   * 出队操作
   * 如果输出栈为空, 则将输入栈中的所有元素弹出并压入输出栈, 确保先入队的元素位于栈顶.
   * 然后弹出输出栈的栈顶元素, 即队头元素.
   *
   * @return 队头元素, 如果队列为空, 返回-1
   */
  public int pop() {
    if (outputStack.isEmpty()) {
      // 如果输出栈为空, 则将输入栈中的所有元素弹出并压入输出栈
      while (!inputStack.isEmpty()) {
        outputStack.addLast(inputStack.removeLast());
      }
    }
    // 弹出输出栈的栈顶元素, 即队头元素
    return outputStack.isEmpty() ? -1 : outputStack.removeLast();
  }

  /**
   * 查看队头元素
   * 如果输出栈为空, 则将输入栈中的所有元素弹出并压入输出栈, 确保先入队的元素位于栈顶.
   * 然后查看输出栈的栈顶元素, 即队头元素.
   *
   * @return 队头元素, 如果队列为空, 返回-1
   */
  public int peek() {
    if (outputStack.isEmpty()) {
      // 如果输出栈为空, 则将输入栈中的所有元素弹出并压入输出栈
      while (!inputStack.isEmpty()) {
        outputStack.addLast(inputStack.removeLast());
      }
    }
    // 查看输出栈的栈顶元素, 即队头元素
    return outputStack.isEmpty() ? -1 : outputStack.peekLast();
  }

  /**
   * 判断队列是否为空
   * 当输入栈和输出栈都为空时, 队列才为空.
   *
   * @return 如果队列为空, 返回true; 否则返回false
   */
  public boolean empty() {
    // 当输入栈和输出栈都为空时, 队列才为空
    return inputStack.isEmpty() && outputStack.isEmpty();
  }
}
