package com.flyingcode.search;

/**
 * 二分查找
 * 该类提供一个高效的二分查找算法，用于在有序整数数组中查找目标值.
 * 算法采用分治策略，通过不断缩小搜索范围实现快速查找，空间复杂度为 O(1).
 */
public class BinarySearch {

  /**
   * 算法设计思路:
   * 1. 前提条件: 输入数组必须是升序排列的
   * 2. 初始化左边界left=0，右边界right=arr.length-1
   * 3. 当left<=right时，执行循环:
   * a. 计算中间位置mid=(left+right)/2
   * b. 如果arr[mid] == target，返回mid
   * c. 如果arr[mid] > target，说明target在左半部分，更新right=mid-1
   * d. 如果arr[mid] < target，说明target在右半部分，更新left=mid+1
   * 4. 如果循环结束仍未找到目标值，返回-1
   *
   * 关键技术点:
   * - 分治策略: 每次将搜索范围缩小一半
   * - 有序数组: 必须保证输入数组是有序的
   * - 中间位置计算: 使用(left+right)/2避免数组越界
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(log n)，其中 n 是数组的长度.
   * 每次比较都会将搜索范围缩小一半，因此时间复杂度为对数级
   * 最好情况下，目标元素在数组中间，时间复杂度为 O(1)
   * 最坏情况下，需要将搜索范围缩小到1个元素，时间复杂度为 O(log n)
   * - 空间复杂度: O(1).
   * 只使用了常量级的额外空间，没有使用额外的数据结构
   */

  /**
   * 在有序整数数组中查找目标值的索引
   *
   * @param arr    输入的有序整数数组，必须是升序排列
   * @param target 要查找的目标值
   * @return 如果找到目标值，返回其索引；否则返回-1
   */
  public int search(int[] arr, int target) {
    // 边界条件处理: 空数组或null数组直接返回-1
    if (arr == null || arr.length == 0) {
      return -1;
    }

    // 初始化左边界和右边界
    int left = 0;
    int right = arr.length - 1;

    // 当左边界小于等于右边界时，继续查找
    while (left <= right) {
      // 计算中间位置，避免整数溢出
      int mid = left + (right - left) / 2;

      // 如果中间元素等于目标值，返回索引
      if (arr[mid] == target) {
        return mid;
      }
      // 如果中间元素大于目标值，说明目标值在左半部分
      else if (arr[mid] > target) {
        right = mid - 1;
      }
      // 如果中间元素小于目标值，说明目标值在右半部分
      else {
        left = mid + 1;
      }
    }

    // 遍历完整个数组仍未找到，返回-1
    return -1;
  }
}
