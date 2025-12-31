package com.flyingcode.sort;

/**
 * 冒泡排序
 * 该类提供一个简单直观的排序算法, 用于对整数数组进行排序.
 * 算法采用相邻元素比较交换的方式, 实现稳定排序.
 */
public class BubbleSort {

  /**
   * 算法设计思路:
   * 1. 遍历数组, 比较相邻的两个元素
   * 2. 如果前一个元素大于后一个元素, 则交换它们
   * 3. 每一轮遍历都会将当前最大的元素移动到数组末尾
   * 4. 重复上述过程, 直到整个数组排序完成
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n^2), 其中 n 是数组长度.
   * 最坏情况下需要进行 n-1 轮遍历, 每轮遍历比较 n-i 次
   * - 空间复杂度: O(1).
   * 只需要常数级的额外空间
   */

  /**
   * 对整数数组进行冒泡排序
   *
   * @param arr 待排序的整数数组
   * @return 排序后的整数数组
   */
  public int[] sort(int[] arr) {
    // 边界情况处理
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    int n = arr.length;
    // 外层循环控制遍历轮数
    for (int i = 0; i < n - 1; i++) {
      // 内层循环进行相邻元素比较和交换
      for (int j = 0; j < n - 1 - i; j++) {
        // 如果前一个元素大于后一个元素, 则交换
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }
}
