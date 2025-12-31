package com.flyingcode.sort;

/**
 * 归并排序
 * 该类提供一个高效的排序算法, 用于对整数数组进行排序.
 * 算法采用分治策略, 将数组分成子数组排序后再合并, 实现稳定排序.
 * 归并排序是一种稳定的排序算法, 适用于各种规模的数据集.
 */
public class MergeSort {

  /**
   * 算法设计思路:
   * 1. 分治策略: 将待排序数组分成两个大小相等的子数组
   * 2. 递归排序: 递归地对两个子数组进行归并排序
   * 3. 合并操作: 将两个已排序的子数组合并成一个更大的已排序数组
   * 4. 递归终止: 当子数组长度为1或0时, 直接返回(单个元素本身就是有序的)
   * 5. 辅助数组: 使用额外的辅助数组来存储合并过程中的临时结果
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n log n), 其中 n 是数组长度.
   * - 无论输入情况如何, 都需要将数组递归分割成 log n 层
   * - 每层合并操作的时间复杂度为 O(n)
   * - 最好、平均、最坏情况下时间复杂度均为 O(n log n)
   * - 空间复杂度: O(n).
   * - 需要额外的辅助数组来存储合并结果
   * - 递归调用栈深度为 O(log n), 但被 O(n) 的空间复杂度覆盖
   */

  /**
   * 对整数数组进行归并排序
   *
   * @param arr 待排序的整数数组, 可以为null或空数组
   * @return 排序后的整数数组, 如果输入为null或空数组则直接返回
   */
  public int[] sort(int[] arr) {
    // 边界情况处理: 空数组或长度为1的数组无需排序
    if (arr == null || arr.length <= 1) {
      return arr;
    }

    // 创建辅助数组: 用于存储合并过程中的临时结果
    // 只创建一次, 避免递归过程中频繁创建数组
    int[] temp = new int[arr.length];
    // 调用递归排序方法, 对整个数组进行排序
    mergeSort(arr, 0, arr.length - 1, temp);
    return arr;
  }

  /**
   * 递归实现归并排序
   *
   * @param arr   待排序的整数数组
   * @param left  当前子数组的左边界索引
   * @param right 当前子数组的右边界索引
   * @param temp  辅助数组, 用于存储合并结果
   */
  private void mergeSort(int[] arr, int left, int right, int[] temp) {
    // 递归终止条件: 子数组长度为1或0
    if (left < right) {
      // 计算中间索引, 避免整数溢出
      // 公式: mid = left + (right - left) / 2
      int mid = left + (right - left) / 2;

      // 递归排序左半部分: [left, mid]
      mergeSort(arr, left, mid, temp);
      // 递归排序右半部分: [mid+1, right]
      mergeSort(arr, mid + 1, right, temp);

      // 合并两个已排序的子数组
      merge(arr, left, mid, right, temp);
    }
  }

  /**
   * 合并两个已排序的子数组
   * 左子数组范围: [left, mid]
   * 右子数组范围: [mid+1, right]
   *
   * @param arr   待排序的整数数组
   * @param left  左子数组的左边界索引
   * @param mid   左子数组的右边界索引, 同时也是右子数组左边界的前一个索引
   * @param right 右子数组的右边界索引
   * @param temp  辅助数组, 用于存储合并结果
   */
  private void merge(int[] arr, int left, int mid, int right, int[] temp) {
    // 初始化指针
    int i = left; // 左子数组的起始索引
    int j = mid + 1; // 右子数组的起始索引
    int k = 0; // 辅助数组的起始索引

    // 比较两个子数组的元素, 按顺序放入辅助数组
    // 循环条件: 两个子数组都还有元素未处理
    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        // 左子数组元素较小, 放入辅助数组
        temp[k++] = arr[i++];
      } else {
        // 右子数组元素较小, 放入辅助数组
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
    // 重置辅助数组指针
    k = 0;
    // 复制范围: [left, right]
    while (left <= right) {
      arr[left++] = temp[k++];
    }
  }
}
