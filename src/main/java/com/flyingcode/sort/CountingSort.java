package com.flyingcode.sort;

/**
 * 计数排序
 * 该类提供一个高效的非比较排序算法, 用于对整数数组进行排序.
 * 算法通过统计每个元素出现的次数来实现排序, 实现稳定排序.
 */
public class CountingSort {

  /**
   * 算法设计思路:
   * 1. 找出待排序数组中的最大值和最小值
   * 2. 创建一个计数数组, 用于统计每个元素出现的次数
   * 3. 遍历待排序数组, 统计每个元素的出现次数并存储到计数数组中
   * 4. 根据计数数组重构排序后的数组
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n + k), 其中 n 是数组长度, k 是元素的取值范围.
   * 需要遍历数组两次, 一次统计次数, 一次重构数组
   * - 空间复杂度: O(n + k).
   * 需要额外的计数数组和输出数组
   */

  /**
   * 对整数数组进行计数排序
   *
   * @param arr 待排序的整数数组
   * @return 排序后的整数数组
   */
  public int[] sort(int[] arr) {
    // 边界情况处理
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // 找出数组中的最大值和最小值
    int max = arr[0];
    int min = arr[0];
    for (int num : arr) {
      if (num > max) {
        max = num;
      }
      if (num < min) {
        min = num;
      }
    }

    // 创建计数数组
    int range = max - min + 1;
    int[] count = new int[range];

    // 统计每个元素出现的次数
    for (int num : arr) {
      count[num - min]++;
    }

    // 重构排序后的数组
    int[] result = new int[arr.length];
    int index = 0;
    for (int i = 0; i < range; i++) {
      while (count[i] > 0) {
        result[index++] = i + min;
        count[i]--;
      }
    }

    return result;
  }
}
