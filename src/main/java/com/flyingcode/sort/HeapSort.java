package com.flyingcode.sort;

/**
 * 堆排序
 * 该类提供一个高效的排序算法, 用于对整数数组进行排序.
 * 算法采用二叉堆数据结构, 通过构建最大堆并逐步取出堆顶元素实现排序, 实现不稳定排序.
 */
public class HeapSort {

  /**
   * 算法设计思路:
   * 1. 将待排序数组构建成一个最大堆, 此时堆顶元素是最大值
   * 2. 将堆顶元素与堆的最后一个元素交换, 此时最大值被放到了数组末尾
   * 3. 调整剩余元素, 使其重新成为一个最大堆
   * 4. 重复步骤2和步骤3, 直到堆的大小为1
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n log n), 其中 n 是数组长度.
   * 构建堆的时间复杂度为 O(n), 调整堆的时间复杂度为 O(log n), 需要调整 n-1 次
   * - 空间复杂度: O(1).
   * 只需要常数级的额外空间
   */

  /**
   * 对整数数组进行堆排序
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

    // 构建最大堆
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    // 逐步将堆顶元素与最后一个元素交换, 并调整堆
    for (int i = n - 1; i > 0; i--) {
      // 交换堆顶元素和当前堆的最后一个元素
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // 调整剩余元素, 使其重新成为最大堆
      heapify(arr, i, 0);
    }

    return arr;
  }

  /**
   * 调整堆结构, 使其成为最大堆
   *
   * @param arr 待调整的数组
   * @param n   堆的大小
   * @param i   要调整的节点索引
   */
  private void heapify(int[] arr, int n, int i) {
    int largest = i; // 初始化当前节点为最大值
    int left = 2 * i + 1; // 左子节点索引
    int right = 2 * i + 2; // 右子节点索引

    // 如果左子节点大于当前节点, 更新最大值索引
    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }

    // 如果右子节点大于当前最大值, 更新最大值索引
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }

    // 如果最大值不是当前节点, 交换并继续调整子树
    if (largest != i) {
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;

      // 递归调整受影响的子树
      heapify(arr, n, largest);
    }
  }
}
