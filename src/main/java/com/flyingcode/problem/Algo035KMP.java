package com.flyingcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串搜索算法: Knuth-Morris-Pratt (KMP)
 * 该类提供一个高效的字符串搜索算法, 用于查找模式字符串在主字符串中的所有出现位置.
 * 算法采用部分匹配表(前缀函数)技术, 避免了传统暴力搜索中的不必要回溯, 实现了线性时间复杂度.
 * KMP算法特别适用于在长文本中多次搜索同一模式的场景.
 */
public class Algo035KMP {

  /**
   * 算法设计思路:
   * 1. 预处理模式字符串, 构建部分匹配表(也称为前缀函数), 用于记录模式字符串中每个位置的最长公共前后缀长度
   * 2. 使用双指针技术, 一个指针i遍历主字符串, 一个指针j遍历模式字符串
   * 3. 当字符匹配时, 两个指针同时前进
   * 4. 当字符不匹配时:
   * - 如果j不为0, 则根据部分匹配表将j回溯到合适位置, 避免重新开始匹配
   * - 如果j为0, 则i前进, 继续下一个位置的匹配
   * 5. 当j到达模式字符串末尾时, 找到一个匹配, 记录起始位置, 然后根据部分匹配表继续搜索下一个匹配
   *
   * 关键技术点:
   * - 部分匹配表的构建: 线性时间复杂度, 用于优化匹配失败时的回溯位置
   * - 避免暴力搜索中的O(n*m)时间复杂度, 实现O(n+m)的线性时间复杂度
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n + m), 其中n是主字符串长度, m是模式字符串长度.
   * 预处理模式字符串构建部分匹配表的时间复杂度为O(m), 主字符串的匹配过程时间复杂度为O(n), 因此总时间复杂度为O(n + m).
   * - 空间复杂度: O(m).
   * 需要额外的数组存储部分匹配表, 数组长度等于模式字符串长度m.
   */

  /**
   * 构建部分匹配表(前缀函数)
   * 部分匹配表用于记录模式字符串中每个位置的最长公共前后缀长度
   * 前缀函数lps[i]的定义: 对于子串P[0..i], 其最长相等的真前缀和真后缀的长度
   * 真前缀: 不包含最后一个字符的前缀, 如P[0..k] (0≤k<i)
   * 真后缀: 不包含第一个字符的后缀, 如P[i-k..i] (0<k≤i)
   *
   * @param pattern 模式字符串, 不能为空
   * @return 部分匹配表, 数组长度等于模式字符串长度, 每个元素表示对应位置的最长公共前后缀长度
   */
  private int[] computePrefix(String pattern) {
    // 模式字符串长度
    int m = pattern.length();
    // 初始化部分匹配表, lps[i]表示模式字符串前i+1个字符的最长公共前后缀长度
    int[] lps = new int[m];
    // len: 当前最长公共前后缀的候选长度, 初始值为0(单个字符无真前后缀)
    int len = 0;
    // i: 当前处理的位置, 从第二个字符开始(索引1)
    int i = 1;

    // 遍历模式字符串, 构建部分匹配表
    while (i < m) {
      // 情况1: 当前字符匹配成功
      // 说明P[i]与当前候选长度位置的字符相同, 可扩展公共前后缀长度
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++; // 扩展候选长度
        lps[i] = len; // 记录当前位置的最长公共前后缀长度
        i++; // 处理下一个位置
      } else {
        // 情况2: 当前字符匹配失败
        if (len > 0) {
          // 回溯到lps[len-1]
          // 证明:
          // 已知: P[0..len-1] = P[i-len..i-1]
          // 设: k = lps[len-1]
          // 因为: P[0..k-1] = P[len-k..len-1] (lps定义)
          // 又因为: P[i-len..i-1] = P[0..len-1], 其后缀 P[i-k..i-1] = P[len-k..len-1]
          // 所以: P[0..k-1] = P[i-k..i-1]
          // 结论: len = k 是下一个最大候选长度
          len = lps[len - 1];
        } else {
          // 当len=0时, 无法回溯, 当前位置的最长公共前后缀长度为0
          lps[i] = 0;
          i++; // 处理下一个位置
        }
      }
    }
    return lps;
  }

  /**
   * 搜索模式字符串在主字符串中的所有出现位置
   * 使用KMP算法实现高效的字符串搜索, 避免不必要的回溯
   * 核心思想: 利用已匹配的信息, 通过部分匹配表指导回溯, 避免从头开始匹配
   *
   * @param text    主字符串, 可以为null或空字符串
   * @param pattern 模式字符串, 可以为null或空字符串
   * @return 模式字符串在主字符串中所有出现位置的索引列表, 若没有匹配则返回空列表
   */
  public List<Integer> solution(String text, String pattern) {
    List<Integer> result = new ArrayList<>();

    // 边界条件处理: 若主字符串或模式字符串为null或空, 返回空列表
    if (text == null || pattern == null || text.isEmpty() || pattern.isEmpty()) {
      return result;
    }

    // 主字符串长度
    int n = text.length();
    // 模式字符串长度
    int m = pattern.length();
    // 构建部分匹配表(前缀函数), 用于指导匹配失败时的回溯
    int[] lps = computePrefix(pattern);

    // i: 主字符串的索引, 从0开始
    int i = 0;
    // j: 模式字符串的索引, 从0开始
    int j = 0;

    // 遍历主字符串进行匹配
    while (i < n) {
      // 步骤1: 检查当前字符是否匹配
      if (pattern.charAt(j) == text.charAt(i)) {
        // 匹配成功: 两个指针同时前进
        i++;
        j++;
      }

      // 步骤2: 检查是否已找到完整匹配
      if (j == m) {
        // 记录匹配的起始位置
        result.add(i - m);
        // 回溯到lps[j-1], 继续搜索下一个匹配
        // 证明: pattern[0..lps[m-1]-1] = text[i-lps[m-1]..i-1], 可复用已匹配的前缀
        j = lps[j - 1];
      }
      // 步骤3: 检查当前是否匹配失败
      else if (i < n && pattern.charAt(j) != text.charAt(i)) {
        // 当前字符匹配失败, 执行回溯逻辑
        if (j > 0) {
          // 回溯到lps[j-1], 与computePrefix中原理相同
          j = lps[j - 1];
        } else {
          // 当j=0时, 无法回溯, 主字符串指针i前进
          i++;
        }
      }
    }

    return result;
  }

}
