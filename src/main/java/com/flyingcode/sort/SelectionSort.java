package com.flyingcode.sort;

/**
 * 选择排序
 * 该类提供一个简单直观的排序算法, 用于对整数数组进行排序.
 * 算法采用每次选择最小元素的方式, 实现不稳定排序.
 */
public class SelectionSort {

  /**
   * 算法设计思路:
   * 1. 将数组分为已排序区间和未排序区间, 初始时已排序区间为空
   * 2. 遍历未排序区间, 找到最小元素的索引
   * 3. 将最小元素与未排序区间的第一个元素交换位置
   * 4. 重复上述过程直到整个数组排序完成
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n^2), 其中 n 是数组长度.
   * 无论输入情况如何, 都需要进行 n-1 轮选择, 每轮选择需要比较 n-i 次
   * - 空间复杂度: O(1).
   * 只需要常数级的额外空间
   */

  /**
   * 对整数数组进行选择排序
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
    // 外层循环控制已排序区间的边界
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      // 内层循环遍历未排序区间, 找到最小元素
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      // 将最小元素与未排序区间的第一个元素交换
      if (minIndex != i) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
      }
    }

    return arr;
  }
}
