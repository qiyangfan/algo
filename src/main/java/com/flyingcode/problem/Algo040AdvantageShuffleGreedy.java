package com.flyingcode.problem;

import java.util.Arrays;

/**
 * 优势洗牌问题 - 贪心算法
 * 该类提供一个高效的贪心算法解决方案, 用于解决优势洗牌问题.
 * 算法通过排序和双指针技术, 实现了最大化 A[i] > B[i] 次数的目标.
 */
public class Algo040AdvantageShuffleGreedy {

  /**
   * 算法设计思路:
   * 1. 基于田忌赛马策略, 用最小的能赢的元素去赢, 用最弱的元素去输
   * 2. 为 B 数组创建索引数组, 并按 B 的值从小到大排序, 保留原始索引信息
   * 3. 对 A 数组进行升序排序, 便于访问最小和最大元素
   * 4. 使用双指针技术, left 指向 A 中最小元素, right 指向 A 中最大元素
   * 5. 从大到小遍历 B 中的元素:
   * - 如果 A 的最大元素大于当前 B 元素, 用 A 的最大元素去赢
   * - 否则用 A 的最小元素去输, 保留较大元素用于其他 B 元素
   * 6. 将结果按 B 元素的原始索引分配到最终数组中
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n log n), 其中 n 是数组长度.
   * 主要时间消耗在三个排序操作: A 数组排序、B 索引数组排序、自定义比较器排序, 每个排序的时间复杂度均为 O(n log n).
   * - 空间复杂度: O(n).
   * 需要额外的索引数组和结果数组, 空间复杂度为 O(n).
   */

  /**
   * 重新排列数组 A, 使得 A[i] > B[i] 的次数最大化
   *
   * @param A 输入数组, 可重新排列
   * @param B 输入数组, 不可重新排列
   * @return 重新排列后的数组 A, 使得 A[i] > B[i] 的次数最大化
   */
  public int[] solution(int[] A, int[] B) {
    // 获取数组长度
    int n = A.length;

    // 创建 B 的索引数组, 用于记录 B 元素的原始位置
    Integer[] indexB = new Integer[n];
    for (int i = 0; i < n; i++) {
      indexB[i] = i;
    }

    // 按 B 的值从小到大排序索引数组
    // 比较器含义: 根据索引对应的 B 元素值进行排序
    Arrays.sort(indexB, (i, j) -> B[i] - B[j]);

    // 对 A 数组进行升序排序, 便于访问最小和最大元素
    Arrays.sort(A);

    // 结果数组, 用于存储最终的排列结果
    int[] result = new int[n];

    // 双指针初始化:
    // left 指向 A 中最小的元素
    // right 指向 A 中最大的元素
    int left = 0;
    int right = n - 1;

    // 从大到小遍历 B 中的元素(通过索引数组实现)
    for (int i = n - 1; i >= 0; i--) {
      // 获取当前 B 元素的原始索引
      int currentBIndex = indexB[i];
      // 获取当前 B 元素的值
      int currentBValue = B[currentBIndex];

      if (A[right] > currentBValue) {
        // 情况1: A 的最大元素大于当前 B 元素, 用 A 的最大元素去赢
        result[currentBIndex] = A[right];
        // 移动右指针, 下一次使用次大元素
        right--;
      } else {
        // 情况2: A 的最大元素不大于当前 B 元素, 用 A 的最小元素去输
        result[currentBIndex] = A[left];
        // 移动左指针, 下一次使用次小元素
        left++;
      }
    }

    // 返回最终排列结果
    return result;
  }
}
