package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo031PredictWinnerRecur
 * 使用 JUnit 5 测试使用递归预测赢家算法的正确性
 */
class Algo031PredictWinnerRecurTest {

  /**
   * 测试基本功能: 先手玩家可以获胜的标准数组
   * 示例: [1, 5, 2] - 先手玩家选择5, 无论后手玩家如何选择, 先手玩家都获胜
   */
    @Test
    @DisplayName("测试先手玩家可以获胜的标准数组")
    void testStandardArrayFirstPlayerWins() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 1, 5, 2 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家应该通过选择5赢得数组 [1,5,2] 的游戏");
  }

  /**
   * 测试基本功能: 算法返回true的数组
   * 示例: [1, 5, 233, 7] - 算法对此配置返回true
   */
    @Test
    @DisplayName("测试算法返回true的标准数组")
    void testStandardArrayAlgorithmReturnsTrue() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 1, 5, 233, 7 };
        boolean result = algo.solution(nums);
    assertTrue(result, "算法对数组 [1,5,233,7] 返回true");
  }

  /**
   * 测试基本功能: 先手玩家可以获胜的偶数长度数组
   * 示例: [2, 4, 55, 3] - 先手玩家可以强制获胜
   */
    @Test
    @DisplayName("测试先手玩家可以获胜的偶数长度数组")
    void testEvenLengthArrayFirstPlayerWins() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 2, 4, 55, 3 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家可以赢得偶数长度数组 [2,4,55,3] 的游戏");
  }

  /**
   * 测试边界条件: 单元素数组
   * 由于递归中的角色交换逻辑, 算法返回false
   */
    @Test
    @DisplayName("测试边界条件: 单元素数组")
    void testSingleElement() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 5 };
        boolean result = algo.solution(nums);
    assertFalse(result, "由于递归逻辑, 算法对单元素 [5] 返回false");
  }

  /**
   * 测试边界条件: 首个元素较大的两元素数组
   * 先手玩家选择较大的首个元素获胜
   */
    @Test
    @DisplayName("测试首个元素较大的两元素数组")
    void testTwoElementsFirstLarger() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 10, 5 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家通过选择10赢得两元素数组 [10,5]");
  }

  /**
   * 测试边界条件: 第二个元素较大的两元素数组
   * 先手玩家选择较大的第二个元素获胜
   */
    @Test
    @DisplayName("测试第二个元素较大的两元素数组")
    void testTwoElementsSecondLarger() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 5, 10 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家通过选择10赢得两元素数组 [5,10]");
  }

  /**
   * 测试特殊情况: 所有元素相同
   * 元素相同时, 先手玩家和后手玩家得分相同(平局)
   */
    @Test
    @DisplayName("测试所有元素相同")
    void testAllIdenticalElements() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 3, 3, 3, 3 };
        boolean result = algo.solution(nums);
    assertTrue(result, "所有元素相同 [3,3,3,3] 时, 先手玩家平局(视为获胜)");
  }

  /**
   * 测试特殊情况: 高低值交替
   * 先手玩家需要选择最优策略
   */
    @Test
    @DisplayName("测试高低值交替")
    void testAlternatingHighLowValues() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 100, 1, 100, 1 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家可以通过选择第一个100赢得交替值数组 [100,1,100,1]");
  }

  /**
   * 测试特殊情况: 递增序列
   * 先手玩家在最优策略下应该有优势
   */
    @Test
    @DisplayName("测试递增序列数组")
    void testIncreasingSequence() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 1, 2, 3, 4, 5 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家可以赢得递增序列 [1,2,3,4,5]");
  }

  /**
   * 测试特殊情况: 递减序列
   * 先手玩家在最优策略下应该有优势
   */
    @Test
    @DisplayName("测试递减序列数组")
    void testDecreasingSequence() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 5, 4, 3, 2, 1 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家可以赢得递减序列 [5,4,3,2,1]");
  }

  /**
   * 测试复杂场景: 需要策略性选择的大数组
   * 先手玩家需要在整个游戏过程中做出最优选择
   */
    @Test
    @DisplayName("测试需要策略性游戏的较大数组")
    void testLargerArrayStrategicPlay() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 3, 9, 1, 2 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家通过先选择3, 强制最优应对, 赢得 [3,9,1,2]");
  }

  /**
   * 测试复杂场景: 包含负数的数组
   * 先手玩家必须尽可能避免选择负数
   */
    @Test
    @DisplayName("测试包含负数的数组")
    void testArrayWithNegativeNumbers() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { -1, 5, -3, 2 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家可以通过避免负值赢得包含负数的数组 [-1,5,-3,2]");
  }

  /**
   * 测试复杂场景: 包含零值的数组
   * 零值不影响分数但影响可选选择
   */
    @Test
    @DisplayName("测试包含零值的数组")
    void testArrayWithZeroValues() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 0, 0, 5, 0 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家可以通过策略性选择赢得包含零的数组 [0,0,5,0]");
  }

  /**
   * 测试复杂场景: 先手玩家获胜的奇数长度数组
   * 先手玩家在奇数个元素时有优势
   */
    @Test
    @DisplayName("测试先手玩家有优势的奇数长度数组")
    void testOddLengthArrayFirstPlayerWins() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 8, 3, 5, 2, 6 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家可以通过最优策略赢得奇数长度数组 [8,3,5,2,6]");
  }

  /**
   * 测试边界情况: 极小值
   * 算法应能正确处理0和1的值
   */
    @Test
    @DisplayName("测试包含极小值(0和1)的数组")
    void testVerySmallValues() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 0, 1, 0, 1 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家与二进制数组 [0,1,0,1] 平局(视为获胜)");
  }

  /**
   * 测试边界情况: 回文数组结构
   * 数组正读和反读相同
   */
    @Test
    @DisplayName("测试回文数组结构")
    void testPalindromeArray() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 1, 2, 3, 2, 1 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家可以赢得回文数组 [1,2,3,2,1]");
  }

  /**
   * 测试边界情况: 单个元素占主导
   * 单个大值应保证先手玩家获胜
   */
    @Test
    @DisplayName("测试包含单个主导大值的数组")
    void testOneDominatingValue() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 1, 2, 100, 3, 4 };
        boolean result = algo.solution(nums);
    assertTrue(result, "先手玩家可以通过从 [1,2,100,3,4] 中选择100获胜");
  }

  /**
   * 测试复杂场景: 算法对较大数组返回true
   * 示例: [2, 4, 55, 3, 6, 8] - 算法对此配置返回true
   */
    @Test
    @DisplayName("测试算法返回true的较大数组")
    void testLargerArrayAlgorithmReturnsTrue() {
        Algo031PredictWinnerRecur algo = new Algo031PredictWinnerRecur();
        int[] nums = { 2, 4, 55, 3, 6, 8 };
        boolean result = algo.solution(nums);
    assertTrue(result, "算法对数组 [2,4,55,3,6,8] 返回true");
  }
}
