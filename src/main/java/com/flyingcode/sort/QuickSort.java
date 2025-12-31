package com.flyingcode.sort;

/**
 * 快速排序
 * 该类提供一个高效的排序算法, 用于对整数数组进行排序.
 * 算法采用分治策略, 选择基准元素将数组分割成两部分, 实现不稳定排序.
 */
public class QuickSort {

  /**
   * 算法设计思路:
   * 1. 选择一个基准元素(pivot), 通常选择数组的第一个或最后一个元素
   * 2. 分区操作: 将数组中小于基准的元素放在基准左边, 大于基准的元素放在基准右边
   * 3. 对基准左边和右边的子数组分别递归地执行步骤1和步骤2
   * 4. 递归结束条件是子数组长度为0或1
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n log n), 其中 n 是数组长度.
   * 平均情况下, 每轮分区将数组分成两个大小相近的子数组, 递归深度为 log n, 每轮分区时间为 O(n)
   * 最坏情况下, 分区不平衡, 时间复杂度为 O(n^2)
   * - 空间复杂度: O(log n).
   * 递归调用栈的深度, 平均情况下为 log n, 最坏情况下为 O(n)
   */

  /**
   * 对整数数组进行快速排序
   *
   * @param arr 待排序的整数数组
   * @return 排序后的整数数组
   */
  public int[] sort(int[] arr) {
    // 边界情况处理
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    quickSort(arr, 0, arr.length - 1);
    return arr;
  }

  /**
   * 递归实现快速排序
   *
   * @param arr   待排序的整数数组
   * @param left  左边界索引
   * @param right 右边界索引
   */
  private void quickSort(int[] arr, int left, int right) {
    if (left < right) {
      // 获取分区点
      int pivotIndex = partition(arr, left, right);
      // 对基准左边的子数组进行排序
      quickSort(arr, left, pivotIndex - 1);
      // 对基准右边的子数组进行排序
      quickSort(arr, pivotIndex + 1, right);
    }
  }

  /**
   * 分区操作, 将数组分成两部分
   *
   * @param arr   待分区的整数数组
   * @param left  左边界索引
   * @param right 右边界索引
   * @return 基准元素的最终位置
   */
  private int partition(int[] arr, int left, int right) {
    // 选择最右边的元素作为基准
    int pivot = arr[right];
    // i 指向小于基准元素区域的右边界
    int i = left - 1;

    // 遍历数组, 将小于基准的元素放到左边
    for (int j = left; j < right; j++) {
      if (arr[j] <= pivot) {
        i++;
        // 交换元素
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // 将基准元素放到正确位置
    int temp = arr[i + 1];
    arr[i + 1] = arr[right];
    arr[right] = temp;

    return i + 1;
  }
}
