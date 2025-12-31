package com.flyingcode.problem;

/**
 * 房屋抢劫问题 - 滚动数组优化版本
 * 该类提供一个使用滚动数组优化的动态规划算法, 用于解决房屋抢劫问题.
 * 算法采用动态规划技术和滚动数组优化, 实现线性时间复杂度和常量空间复杂度.
 */
public class Algo036HouseRobberDP {

  /**
   * 算法设计思路:
   * 1. 定义状态:
   * - first: 表示抢劫前 i-1 个房屋能获得的最大金额
   * - second: 表示抢劫前 i 个房屋能获得的最大金额
   * 2. 状态转移方程: current = max(second, first + nums[i])
   * - 若不抢劫第 i 个房屋, 则最大金额为 second
   * - 若抢劫第 i 个房屋, 则最大金额为 first + nums[i] (不能抢劫相邻房屋)
   * 3. 滚动数组优化: 由于每次计算只需要前两个状态, 因此只需要用两个变量来保存中间结果
   * 4. 初始化:
   * - first = nums[0] (只有一个房屋时, 抢劫该房屋)
   * - second = max(nums[0], nums[1]) (有两个房屋时, 选择金额较大的那个)
   * 5. 遍历顺序: 从第三个房屋开始, 依次计算每个房屋的最大抢劫金额
   * 6. 返回结果: second (抢劫所有房屋能获得的最大金额)
   *
   * 关键技术点: 滚动数组优化, 将空间复杂度从 O(n) 降低到 O(1)
   */

  /**
   * 算法复杂度分析:
   * - 时间复杂度: O(n), 其中 n 是房屋数量.
   * 因为只需要遍历一次房屋数组, 每个房屋只访问一次, 所以总操作次数是线性的.
   * - 空间复杂度: O(1).
   * 使用了两个变量来保存中间结果, 空间占用是常量级的.
   */

  /**
   * 计算抢劫房屋能获得的最大金额
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

    int first = nums[0];
    int second = Math.max(nums[0], nums[1]);

    // 从第三个房屋开始, 依次计算每个房屋的最大抢劫金额
    for (int i = 2; i < nums.length; i++) {
      // 状态转移: 选择不抢劫当前房屋或抢劫当前房屋
      int current = Math.max(second, first + nums[i]);
      first = second;
      second = current;
    }

    // 返回抢劫所有房屋能获得的最大金额
    return second;
  }

}
