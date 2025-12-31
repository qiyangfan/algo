package com.flyingcode.search;

/**
 * 斐波那契查找
 * 该类提供一个高效的斐波那契查找算法，用于在有序整数数组中查找目标值.
 * 算法采用斐波那契数列分割搜索区间，实现了对数级时间复杂度，空间复杂度为 O(1).
 */
public class FibonacciSearch {

  /**
   * 算法设计思路:
   * 1. 前提条件: 输入数组必须是升序排列的
   * 2. 生成斐波那契数列，直到找到第一个大于等于数组长度的斐波那契数 F[k]
   * 3. 将原数组扩展到长度 F[k]，使用原数组最后一个元素填充扩展部分
   * 4. 初始化左边界left=0，右边界right=arr.length-1，斐波那契分割点索引offset=0
   * 5. 当left<=right时，执行循环:
   * a. 计算当前分割点mid=left + F[k-1] - 1
   * b. 如果arr[mid] == target，返回mid（如果mid<原数组长度）或原数组长度-1
   * c. 如果arr[mid] > target，说明target在左半部分，更新right=mid-1，k-=1
   * d. 如果arr[mid] < target，说明target在右半部分，更新left=mid+1，k-=2
   * 6. 如果循环结束仍未找到目标值，返回-1
   *
   * 关键技术点:
   * - 斐波那契数列: 用于确定分割点位置
   * - 数组扩展: 将数组长度扩展到斐波那契数
   * - 有序数组: 必须保证输入数组是有序的
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(log n)，其中 n 是数组的长度.
   * 每次比较都会将搜索范围缩小约1/φ（黄金分割比例），因此时间复杂度为对数级
   * 最好情况下，目标元素一次命中，时间复杂度为 O(1)
   * 最坏情况下，时间复杂度为 O(log n)
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

    int n = arr.length;

    // 生成斐波那契数列，直到找到第一个大于等于数组长度的斐波那契数
    int k = 0;
    int[] fib = generateFibonacci(n);

    // 找到第一个大于等于n的斐波那契数fib[k]
    while (k < fib.length && fib[k] < n) {
      k++;
    }

    // 初始化左边界和右边界
    int left = 0;
    int right = n - 1;

    // 当左边界小于等于右边界时，继续查找
    while (left <= right && k > 1) {
      // 计算分割点mid
      int mid = left + fib[k - 1] - 1;

      // 防止mid越界
      if (mid >= n) {
        mid = right;
      }
      if (mid < left) {
        mid = left;
      }

      // 如果中间元素等于目标值，返回索引
      if (arr[mid] == target) {
        return mid;
      }
      // 如果中间元素大于目标值，说明目标值在左半部分
      else if (arr[mid] > target) {
        right = mid - 1;
        k--;
      }
      // 如果中间元素小于目标值，说明目标值在右半部分
      else {
        left = mid + 1;
        k -= 2;
      }
    }

    // 处理最后一个元素
    if (left <= right && arr[left] == target) {
      return left;
    }

    // 遍历完整个数组仍未找到，返回-1
    return -1;
  }

  /**
   * 生成斐波那契数列，直到斐波那契数大于等于给定值
   *
   * @param n 给定值
   * @return 斐波那契数列数组
   */
  private int[] generateFibonacci(int n) {
    // 斐波那契数列的前几个值
    int[] fib = new int[40]; // 足够大的数组，斐波那契数列增长很快
    fib[0] = 0;
    fib[1] = 1;

    for (int i = 2; i < fib.length; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
      // 如果斐波那契数大于等于n*2，停止生成
      if (fib[i] >= n * 2) {
        break;
      }
    }

    return fib;
  }
}
