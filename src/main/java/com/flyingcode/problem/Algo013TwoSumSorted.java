package com.flyingcode.problem;

/**
 * 有序数组中的两数之和
 * 该类提供了一个高效的算法, 用于在有序整数数组中查找两个数, 使它们的和等于目标值
 * 算法采用双指针技术, 实现了线性时间复杂度的查找
 */
public class Algo013TwoSumSorted {
  /**
   * 算法设计思路:
   * 1. 利用数组有序的特性, 采用双指针技术
   * 2. 初始时, 左指针指向数组起始位置, 右指针指向数组末尾位置
   * 3. 计算当前左右指针指向元素的和:
   * - 如果和等于目标值, 直接返回两个指针的索引
   * - 如果和小于目标值, 说明需要增大和, 将左指针右移一位
   * - 如果和大于目标值, 说明需要减小和, 将右指针左移一位
   * 4. 重复上述过程, 直到找到目标值或左右指针相遇
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度:O(n), 其中 n 是数组的长度.
   * 因为在最坏情况下, 左右指针会遍历整个数组, 总操作次数是线性的.
   * - 空间复杂度:O(1), 只使用了常量级的额外空间(两个指针变量和一个结果数组).
   */

  /**
   * 在有序整数数组中查找两个数, 使它们的和等于目标值
   *
   * @param nums   输入的有序整数数组, 数组必须是非降序排列的
   * @param target 目标和值
   * @return 一个长度为2的整数数组, 包含找到的两个数的索引(索引从0开始)
   *         如果未找到符合条件的两个数, 返回包含默认值的数组
   */
  public int[] solution(int[] nums, int target) {
    // 初始化结果数组, 用于存储找到的两个数的索引
    int[] result = new int[2];

    // 左指针: 初始指向数组的第一个元素
    int left = 0;

    // 右指针: 初始指向数组的最后一个元素
    int right = nums.length - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum == target) {
        result[0] = left;
        result[1] = right;
        return result;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    // 未找到符合条件的两个数, 返回默认结果
    return result;
  }
}
