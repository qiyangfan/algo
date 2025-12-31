package com.flyingcode.problem;

/**
 * 数组中三个数的最大乘积
 * 该类提供了一个高效的算法, 用于找出数组中三个数的最大乘积
 * 算法采用线性扫描技术, 仅需遍历数组一次, 实现了O(n)的时间复杂度
 */
public class Algo010MaxProductThreeScan {

  /**
   * 算法设计思路:
   * 1. 最大乘积的可能情况:
   * - 三个最大正数的乘积
   * - 一个最大正数和两个最小负数的乘积(因为负负得正)
   * 2. 遍历数组, 同时维护:
   * - 三个最大的数(max1 >= max2 >= max3)
   * - 两个最小的数(min1 <= min2)
   * 3. 最终结果为以下两种情况的最大值:
   * - max1 * max2 * max3
   * - max1 * min1 * min2
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度:O(n), 其中n是数组的长度
   * 只需遍历数组一次, 所有操作都是常数时间
   * - 空间复杂度:O(1)
   * 只使用了5个变量来存储最大值和最小值, 没有使用额外的数据结构
   */

  /**
   * 找出数组中三个数的最大乘积
   *
   * @param nums 输入的整数数组
   * @return 数组中三个数的最大乘积
   */
  public int solution(int[] nums) {
    // 初始化三个最大数, 初始值为最小整数
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int max3 = Integer.MIN_VALUE;

    // 初始化两个最小数, 初始值为最大整数
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    // 遍历数组, 更新最大值和最小值
    for (int num : nums) {
      // 更新最大三个数: 从大到小依次更新
      if (num > max1) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (num > max2) {
        max3 = max2;
        max2 = num;
      } else if (num > max3) {
        max3 = num;
      }

      // 更新最小两个数: 从小到大依次更新
      if (num < min1) {
        min2 = min1;
        min1 = num;
      } else if (num < min2) {
        min2 = num;
      }
    }

    // 计算两种可能的最大乘积并返回较大值
    return Math.max(max1 * max2 * max3, max1 * min1 * min2);
  }

}
