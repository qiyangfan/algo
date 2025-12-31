package com.flyingcode.sort;

/**
 * 插入排序
 * 该类提供一个简单高效的排序算法, 用于对整数数组进行排序.
 * 算法采用将元素插入到已排序序列中的方式, 实现稳定排序.
 */
public class InsertionSort {

  /**
   * 算法设计思路:
   * 1. 将数组分为已排序区间和未排序区间, 初始时已排序区间只有第一个元素
   * 2. 从第二个元素开始, 依次将未排序区间的元素插入到已排序区间的合适位置
   * 3. 插入时, 从已排序区间的末尾开始比较, 找到第一个小于等于当前元素的位置
   * 4. 将当前元素插入到该位置之后, 重复上述过程直到所有元素排序完成
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n^2), 其中 n 是数组长度.
   * 最坏情况下需要进行 n-1 轮插入, 每轮插入最多比较 i 次
   * - 空间复杂度: O(1).
   * 只需要常数级的额外空间
   */

  /**
   * 对整数数组进行插入排序
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
    // 外层循环控制未排序区间的元素
    for (int i = 1; i < n; i++) {
      int current = arr[i];
      int j = i - 1;

      // 从已排序区间的末尾开始比较, 找到插入位置
      while (j >= 0 && arr[j] > current) {
        // 将大于current的元素向右移动一位
        arr[j + 1] = arr[j];
        j--;
      }

      // 将current插入到正确位置
      arr[j + 1] = current;
    }

    return arr;
  }
}
