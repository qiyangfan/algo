package com.flyingcode.problem;

import java.util.Arrays;

/**
 * 查找数组的中枢索引
 * 该类提供了一个高效的算法, 用于查找数组中的中枢索引
 * 中枢索引的定义是: 索引左侧所有元素的和等于索引右侧所有元素的和
 */
public class Algo004FindPivotIndex {
  /**
   * 算法设计思路:
   * 1. 首先计算数组中所有元素的总和
   * 2. 然后遍历数组, 维护一个左侧元素之和的变量
   * 3. 对于每个元素, 计算其右侧元素之和(总和 - 左侧和 - 当前元素)
   * 4. 比较左侧和与右侧和, 如果相等则当前索引即为中枢索引
   * 5. 如果遍历结束仍未找到, 则返回-1
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度:O(n), 其中 n 是数组的长度
   * 需要遍历数组两次, 第一次计算总和, 第二次查找中枢索引, 总操作次数是线性的
   * - 空间复杂度:O(1)
   * 只使用了常量级的额外空间, 包括总和变量和左侧和变量
   */

  /**
   * 查找数组的中枢索引
   *
   * @param nums 输入的整数数组
   * @return 中枢索引, 如果不存在则返回-1
   * @throws NullPointerException 如果输入数组为 null
   */
  public int solution(int[] nums) {
    // 获取数组长度
    int n = nums.length;

    // 边界条件处理: 空数组直接返回-1
    if (n == 0) {
      return -1;
    }

    // 计算数组中所有元素的总和
    int sum = Arrays.stream(nums).sum();

    // 左侧元素之和, 初始为0
    int leftSum = 0;

    // 遍历数组, 查找中枢索引
    for (int i = 0; i < n; i++) {
      /*
       * 计算当前元素右侧的和: 总和 - 左侧和 - 当前元素
       * 如果左侧和等于右侧和, 当前索引即为中枢索引
       */
      if (leftSum == sum - leftSum - nums[i]) {
        return i;
      }

      // 将当前元素添加到左侧和中
      leftSum += nums[i];
    }

    // 遍历结束未找到中枢索引, 返回-1
    return -1;
  }
}
