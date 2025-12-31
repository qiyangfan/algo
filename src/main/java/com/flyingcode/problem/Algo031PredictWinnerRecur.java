package com.flyingcode.problem;

/**
 * 预测赢家
 * 本类提供一个算法, 用于判断在双方从数组两端轮流选择数字的游戏中, 先手玩家是否能获胜.
 * 算法使用递归和极小化极大策略, 探索所有可能的游戏场景, 确定在双方都采用最优策略的情况下,
 * 先手玩家是否能保证获胜或平局.
 *
 * 算法设计思路:
 * 1. 采用递归方法和极小化极大策略, 模拟所有可能的游戏路径
 * 2. 每个回合, 当前玩家有两种选择: 选择起始端数字或选择末尾端数字
 * 3. 选择后, 角色互换: 当前玩家变为对手, 对手变为当前玩家
 * 4. 先手玩家回合使用或逻辑(只需有一条获胜路径即可), 后手玩家会使用与逻辑
 * 5. 当所有数字都被选完后, 比较双方分数判断先手玩家是否获胜或平局
 *
 * 算法复杂度分析:
 * - 时间复杂度: O(2^n), 其中 n 为数组的长度.
 *   每次递归调用会分支为 2 个调用(选择起始端或末尾端), 共有 n 层递归深度.
 * - 空间复杂度: O(n), 用于递归调用栈的空间.
 *   最大递归深度等于数组中元素的个数.
 */
public class Algo031PredictWinnerRecur {

  /**
   * 判断先手玩家是否能在给定数组的选择游戏中获胜
   *
   * @param nums 输入的整数数组, 每个数字代表一个分数值
   * @return 如果先手玩家在双方都采用最优策略的情况下能获胜或平局, 返回 true; 否则返回 false
   */
  public boolean solution(int[] nums) {
    return predictWinner(nums, 0, nums.length - 1, 0, 0);
  }

  /**
   * 递归判断当前玩家在给定游戏状态下是否能获胜
   *
   * @param nums 输入的整数数组, 包含所有可选择的数字
   * @param start 当前可选取范围的起始索引
   * @param end 当前可选取范围的结束索引
   * @param player1Score 玩家1当前的累计得分
   * @param player2Score 玩家2当前的累计得分
   * @return 如果当前玩家(当前轮到的玩家)能强制获胜, 返回 true; 否则返回 false
   */
  private boolean predictWinner(int[] nums, int start, int end, int player1Score, int player2Score) {
    // 基准情况: 没有更多数字可选择, 游戏结束
    // 比较最终得分: 如果玩家1得分 >= 玩家2得分, 玩家1获胜或平局
    if (start > end) {
      return player1Score >= player2Score;
    }

    // 递归情况1: 当前玩家选择起始位置的数字
    // 选择后角色互换: 当前玩家变为对手(得分参数位置互换)
    // 选择的数字(nums[start])加到原当前玩家的得分上
    boolean chooseStart = predictWinner(nums, start + 1, end, player2Score, player1Score + nums[start]);

    // 递归情况2: 当前玩家选择末尾位置的数字
    // 同样地, 角色互换, 选择的数字(nums[end])加到当前玩家的得分上
    boolean chooseEnd = predictWinner(nums, start, end - 1, player2Score, player1Score + nums[end]);

    // 只要任一选择能导致获胜状态, 当前玩家就获胜
    // 这实现了极小化极大策略: 当前玩家选择最优选项
    return chooseStart || chooseEnd;
  }
}
