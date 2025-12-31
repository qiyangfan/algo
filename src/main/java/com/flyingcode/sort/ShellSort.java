package com.flyingcode.sort;

/**
 * 希尔排序
 * 该类提供一个高效的排序算法, 用于对整数数组进行排序.
 * 算法采用分组插入排序的方式, 是插入排序的改进版本, 实现不稳定排序.
 */
public class ShellSort {

  /**
   * 算法设计思路:
   * 1. 选择一个增量序列, 如 n/2, n/4, ..., 1
   * 2. 按增量序列个数 k, 对数组进行 k 趟排序
   * 3. 每趟排序, 根据对应的增量 gap, 将待排序数组分成若干长度为 gap 的子数组
   * 4. 对每个子数组分别进行插入排序
   * 5. 随着增量逐渐减小, 子数组长度逐渐增大, 当增量为1时, 整个数组就是一个子数组, 排序完成
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n^(1.3-2)), 其中 n 是数组长度.
   * 具体复杂度取决于增量序列的选择, 平均情况下约为 O(n^1.5)
   * - 空间复杂度: O(1).
   * 只需要常数级的额外空间
   */

  /**
   * 对整数数组进行希尔排序
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
    // 初始增量设为数组长度的一半, 然后逐步减半
    for (int gap = n / 2; gap > 0; gap /= 2) {
      // 对每个子数组进行插入排序
      for (int i = gap; i < n; i++) {
        int current = arr[i];
        int j = i - gap;

        // 在当前子数组中找到合适的插入位置
        while (j >= 0 && arr[j] > current) {
          arr[j + gap] = arr[j];
          j -= gap;
        }

        // 将当前元素插入到正确位置
        arr[j + gap] = current;
      }
    }

    return arr;
  }
}
