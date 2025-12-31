package com.flyingcode.problem;

import java.util.Arrays;

/**
 * 三个数的最大乘积
 * 该类提供了一个高效的算法, 用于计算数组中三个数的最大乘积
 * 算法采用排序技术, 通过比较两种可能的最大乘积组合来得到结果
 */
public class Algo009MaxProductThree {
  /**
   * 算法设计思路:
   * 1. 要找到三个数的最大乘积, 需要考虑两种情况:
   * - 情况一: 三个最大的正数相乘, 得到最大乘积
   * - 情况二: 两个最小的负数(绝对值最大)和一个最大的正数相乘, 可能得到更大的乘积
   * 2. 首先对数组进行排序, 这样可以方便地获取最大的三个数和最小的两个数
   * 3. 比较上述两种情况的乘积, 取较大值作为结果
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度:O(n log n), 其中 n 是数组的长度
   * 因为算法的主要时间消耗是排序操作,Arrays.sort() 使用的是双轴快速排序算法, 时间复杂度为 O(n log n)
   * - 空间复杂度:O(1) 或 O(n)
   * 对于基本数据类型数组,Arrays.sort() 是原地排序, 空间复杂度为 O(1)
   * 对于对象数组,Arrays.sort() 使用归并排序, 空间复杂度为 O(n)
   */

  /**
   * 计算数组中三个数的最大乘积
   *
   * @param nums 输入的整数数组
   * @return 数组中三个数的最大乘积
   * @throws NullPointerException 如果输入数组为 null
   */
  public int solution(int[] nums) {
    // 对数组进行排序, 便于获取最大和最小元素
    Arrays.sort(nums);

    // 获取数组长度
    int n = nums.length;

    // 计算两种可能的最大乘积组合:
    // 1. 最后三个数的乘积(三个最大的正数)
    // 2. 前两个数(可能为负数)和最后一个数(最大的正数)的乘积
    int maxProduct = Math.max(
        nums[n - 1] * nums[n - 2] * nums[n - 3], // 情况一: 三个最大正数
        nums[0] * nums[1] * nums[n - 1] // 情况二: 两个最小负数和一个最大正数
    );

    return maxProduct;
  }
}
