package com.flyingcode.sort;

/**
 * 归并排序
 * 该类提供一个高效的排序算法, 用于对整数数组进行排序.
 * 算法采用分治策略, 将数组分成子数组排序后再合并, 实现稳定排序.
 */
public class MergeSort {

  /**
   * 算法设计思路:
   * 1. 将待排序数组分成两个大小相等的子数组
   * 2. 递归地对两个子数组进行归并排序
   * 3. 合并两个已排序的子数组, 得到一个更大的已排序数组
   * 4. 递归结束条件是子数组长度为1或0
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n log n), 其中 n 是数组长度.
   * 无论输入情况如何, 都需要将数组递归分割成 log n 层, 每层合并操作的时间复杂度为 O(n)
   * - 空间复杂度: O(n).
   * 需要额外的辅助数组来存储合并结果
   */

  /**
   * 对整数数组进行归并排序
   *
   * @param arr 待排序的整数数组
   * @return 排序后的整数数组
   */
  public int[] sort(int[] arr) {
    // 边界情况处理
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // 创建辅助数组
    int[] temp = new int[arr.length];
    mergeSort(arr, 0, arr.length - 1, temp);
    return arr;
  }

  /**
   * 递归实现归并排序
   *
   * @param arr   待排序的整数数组
   * @param left  左边界索引
   * @param right 右边界索引
   * @param temp  辅助数组
   */
  private void mergeSort(int[] arr, int left, int right, int[] temp) {
    if (left < right) {
      // 计算中间索引
      int mid = left + (right - left) / 2;

      // 递归排序左半部分
      mergeSort(arr, left, mid, temp);
      // 递归排序右半部分
      mergeSort(arr, mid + 1, right, temp);

      // 合并两个已排序的子数组
      merge(arr, left, mid, right, temp);
    }
  }

  /**
   * 合并两个已排序的子数组
   *
   * @param arr   待排序的整数数组
   * @param left  左边界索引
   * @param mid   中间索引
   * @param right 右边界索引
   * @param temp  辅助数组
   */
  private void merge(int[] arr, int left, int mid, int right, int[] temp) {
    // 初始化指针
    int i = left; // 左子数组的起始索引
    int j = mid + 1; // 右子数组的起始索引
    int k = 0; // 辅助数组的起始索引

    // 比较两个子数组的元素, 按顺序放入辅助数组
    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }

    // 将左子数组剩余元素放入辅助数组
    while (i <= mid) {
      temp[k++] = arr[i++];
    }

    // 将右子数组剩余元素放入辅助数组
    while (j <= right) {
      temp[k++] = arr[j++];
    }

    // 将辅助数组中的元素复制回原数组
    k = 0;
    while (left <= right) {
      arr[left++] = temp[k++];
    }
  }
}
