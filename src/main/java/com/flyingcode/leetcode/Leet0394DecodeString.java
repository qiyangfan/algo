package com.flyingcode.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 解码字符串
 * 该类提供一个高效的算法, 用于解码包含重复序列的字符串.
 * 算法采用栈数据结构, 实现对嵌套重复序列的正确处理.
 */
public class Leet0394DecodeString {

  /**
   * 算法设计思路:
   * 1. 使用双端队列(栈)存储解码过程中的中间状态, 包括当前已解码的字符串和重复次数
   * 2. 遍历输入字符串, 按字符类型分情况处理:
   * - 数字字符: 累计计算重复次数k
   * - '[': 将当前已解码字符串和重复次数入栈, 重置当前字符串和重复次数
   * - ']': 从栈中弹出最近的状态, 将当前字符串重复k次后与之前的字符串拼接
   * - 普通字符: 直接添加到当前字符串末尾
   * 3. 遍历结束后, 当前字符串即为最终解码结果
   *
   * 关键技术点:
   * - 使用栈实现嵌套结构的正确处理
   * - 累计计算多位数的重复次数
   * - 高效的字符串拼接方法
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中 n 是解码后字符串的长度.
   * 虽然存在嵌套重复, 但每个字符在解码过程中只会被处理一次.
   * - 空间复杂度: O(m), 其中 m 是输入字符串的长度.
   * 栈的最大深度取决于嵌套层级, 最坏情况下为O(m).
   */
  /**
   * 解码字符串
   * 该方法根据给定的编码规则, 解码包含方括号的字符串.
   * 编码规则为: k[encoded_string], 表示其中方括号内部的字符串被重复 k 次.
   * 例如, "3[a]2[bc]" 解码后为 "aaabcbc".
   *
   * @param s 待解码的字符串
   * @return 解码后的字符串
   */
  public String solution(String s) {
    // 初始化字符串栈, 用于存储解码过程中的中间字符串
    Deque<String> stringStack = new ArrayDeque<>();
    // 初始化数字栈, 用于存储重复次数
    Deque<Integer> countStack = new ArrayDeque<>();
    // 初始化一个 StringBuilder, 用于构建当前处理的字符串
    StringBuilder currentString = new StringBuilder();
    // 初始化一个变量, 用于存储当前的重复次数
    int currentCount = 0;

    // 遍历输入字符串的每个字符
    for (char c : s.toCharArray()) {
      // 如果字符是数字
      if (Character.isDigit(c)) {
        // 累计计算多位数的重复次数
        currentCount = currentCount * 10 + (c - '0');
      }
      // 如果字符是 '['
      else if (c == '[') {
        // 将当前计算的重复次数和字符串入栈
        countStack.push(currentCount);
        stringStack.push(currentString.toString());
        // 重置当前字符串和重复次数, 准备处理括号内的内容
        currentString.setLength(0);
        currentCount = 0;
      }
      // 如果字符是 ']'
      else if (c == ']') {
        // 从栈中弹出最近的重复次数和字符串
        int repeatTimes = countStack.pop();
        String prevString = stringStack.pop();
        // 构建重复后的字符串
        StringBuilder repeated = new StringBuilder(prevString);
        for (int i = 0; i < repeatTimes; i++) {
          repeated.append(currentString);
        }
        // 更新当前字符串为重复后的结果
        currentString = repeated;
      }
      // 如果是普通字符
      else {
        // 直接添加到当前字符串末尾
        currentString.append(c);
      }
    }
    // 返回最终解码后的字符串
    return currentString.toString();
  }

}
