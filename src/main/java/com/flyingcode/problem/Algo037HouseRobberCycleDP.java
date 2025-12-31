package com.flyingcode.problem;

/**
 * 房屋抢劫问题 - 首尾相连版本
 * 该类提供一个使用滚动数组优化的动态规划算法, 用于解决首尾相连的房屋抢劫问题.
 * 算法采用动态规划技术和滚动数组优化, 实现线性时间复杂度和常量空间复杂度.
 */
public class Algo037HouseRobberCycleDP {

  /**
   * 算法设计思路:
   * 1. 对于首尾相连的房屋, 我们需要考虑两种情况:
   * a) 不抢劫第一个房屋, 那么最后一个房屋可以抢劫
   * b) 不抢劫最后一个房屋, 那么第一个房屋可以抢劫
   * 2. 分别计算这两种情况的最大抢劫金额, 然后取最大值作为结果
   * 3. 对于每种情况, 使用与普通房屋抢劫问题相同的滚动数组优化算法
   * 4. 辅助函数 robRange 用于计算指定范围内房屋的最大抢劫金额
   * 5. 状态定义和转移方程与普通房屋抢劫问题相同
   *
   * 关键技术点: 问题分解, 将首尾相连问题转化为两个普通房屋抢劫问题
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中 n 是房屋数量.
   * 因为需要遍历两次房屋数组, 但总操作次数仍然是线性的.
   * - 空间复杂度: O(1).
   * 使用了两个变量来保存中间结果, 空间占用是常量级的.
   */

  /**
   * 计算首尾相连房屋抢劫的最大金额
   *
   * @param nums 房屋金额数组, 其中 nums[i] 表示第 i 个房屋的金额
   * @return 抢劫房屋能获得的最大金额
   */
  public int solution(int[] nums) {
    // 边界条件处理: 数组为空或 null 时, 返回 0
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // 边界条件处理: 只有一个房屋时, 抢劫该房屋
    if (nums.length == 1) {
      return nums[0];
    }

    // 边界条件处理: 只有两个房屋时, 选择金额较大的那个
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    // 计算两种情况的最大金额, 然后取最大值
    // 情况1: 不抢劫第一个房屋, 可以抢劫最后一个房屋
    int max1 = robRange(nums, 1, nums.length - 1);
    // 情况2: 不抢劫最后一个房屋, 可以抢劫第一个房屋
    int max2 = robRange(nums, 0, nums.length - 2);

    return Math.max(max1, max2);
  }

  /**
   * 计算指定范围内房屋抢劫的最大金额
   *
   * @param nums  房屋金额数组
   * @param start 起始索引 (包含)
   * @param end   结束索引 (包含)
   * @return 指定范围内房屋抢劫的最大金额
   */
  private int robRange(int[] nums, int start, int end) {
    // 初始化状态
    int first = nums[start];
    int second = Math.max(nums[start], nums[start + 1]);

    // 从第三个房屋开始, 依次计算每个房屋的最大抢劫金额
    for (int i = start + 2; i <= end; i++) {
      // 状态转移: 选择不抢劫当前房屋或抢劫当前房屋
      int current = Math.max(second, first + nums[i]);
      first = second;
      second = current;
    }

    return second;
  }
}
