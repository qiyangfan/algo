package com.flyingcode.sort;

/**
 * 基数排序
 * 该类提供一个高效的非比较排序算法, 用于对整数数组进行排序.
 * 算法从最低有效位到最高有效位依次对元素进行排序, 实现稳定排序.
 */
public class RadixSort {

  /**
   * 算法设计思路:
   * 1. 找出待排序数组中的最大值, 确定最大位数
   * 2. 从最低有效位开始, 对数组进行计数排序
   * 3. 依次对每一位进行排序, 直到处理完最高有效位
   * 4. 最终得到完全排序的数组
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(d * (n + k)), 其中 n 是数组长度, d 是最大位数, k 是进制基数.
   * 每一位的计数排序时间为 O(n + k), 需要处理 d 位
   * - 空间复杂度: O(n + k).
   * 需要额外的计数数组和输出数组
   */

  /**
   * 对整数数组进行基数排序
   *
   * @param arr 待排序的整数数组
   * @return 排序后的整数数组
   */
  public int[] sort(int[] arr) {
    // 边界情况处理
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // 找出数组中的最大值
    int max = arr[0];
    for (int num : arr) {
      if (num > max) {
        max = num;
      }
    }

    // 确定最大位数
    int maxDigits = 0;
    while (max > 0) {
      maxDigits++;
      max /= 10;
    }

    // 对每一位进行计数排序
    int[] result = arr.clone();
    int exp = 1; // 表示当前处理的位数 (1, 10, 100, ...)

    for (int i = 0; i < maxDigits; i++) {
      result = countingSortByDigit(result, exp);
      exp *= 10;
    }

    return result;
  }

  /**
   * 按指定位数对数组进行计数排序
   *
   * @param arr 待排序的整数数组
   * @param exp 当前处理的位数 (1, 10, 100, ...)
   * @return 按当前位数排序后的数组
   */
  private int[] countingSortByDigit(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[10]; // 0-9 共10个数字

    // 统计每个数字出现的次数
    for (int i = 0; i < n; i++) {
      int digit = (arr[i] / exp) % 10;
      count[digit]++;
    }

    // 计算每个数字的结束位置
    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // 从右往左遍历, 保持稳定性
    for (int i = n - 1; i >= 0; i--) {
      int digit = (arr[i] / exp) % 10;
      output[count[digit] - 1] = arr[i];
      count[digit]--;
    }

    return output;
  }
}
