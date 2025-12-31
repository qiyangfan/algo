package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo032PredictWinnerDP
 * 使用 JUnit 5 测试预测赢家算法的动态规划数组实现的正确性
 */
class Algo032PredictWinnerDPTest {

  /**
   * 测试基本功能: 单个元素数组
   */
  @Test
  @DisplayName("测试基本功能: 单个元素数组")
  void testSingleElement() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { 1 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertTrue(result, "单个元素数组: 玩家1可以通过拿取唯一元素获胜");
  }

  /**
   * 测试基本功能: 两个元素数组
   */
  @Test
  @DisplayName("测试基本功能: 两个元素数组")
  void testTwoElements() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { 1, 2 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertTrue(result, "两个元素数组: 玩家1可以通过拿取较大元素获胜");
  }

  /**
   * 测试基本功能: 三个元素数组
   */
  @Test
  @DisplayName("测试基本功能: 三个元素数组")
  void testThreeElements() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { 1, 5, 2 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertFalse(result, "三个元素数组: 玩家1无法获胜");
  }

  /**
   * 测试基本功能: 四个元素数组
   */
  @Test
  @DisplayName("测试基本功能: 四个元素数组")
  void testFourElements() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { 1, 5, 2, 4 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertTrue(result, "四个元素数组: 玩家1可以通过最优策略获胜");
  }

  /**
   * 测试特殊情况: 所有元素相同
   */
  @Test
  @DisplayName("测试特殊情况: 所有元素相同")
  void testAllSameElements() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { 3, 3 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertTrue(result, "所有元素相同: 玩家1可以通过最优策略获胜");
  }

  /**
   * 测试边界条件: 空数组
   */
  @Test
  @DisplayName("测试边界条件: 空数组")
  void testEmptyArray() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = {};

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertFalse(result, "空数组: 玩家1无法获胜");
  }

  /**
   * 测试边界条件: null数组
   */
  @Test
  @DisplayName("测试边界条件: null数组")
  void testNullArray() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();

    // Act: 执行测试方法
    boolean result = algo.solution(null);

    // Assert: 验证结果
    assertFalse(result, "null数组: 玩家1无法获胜");
  }

  /**
   * 测试特殊情况: 较大数组
   */
  @Test
  @DisplayName("测试特殊情况: 较大数组")
  void testLargeArray() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { 2, 7, 9, 4, 4 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertTrue(result, "较大数组 [2,7,9,4,4]: 玩家1可以通过最优策略获胜");
  }

  /**
   * 测试特殊情况: 完全递增数组
   */
  @Test
  @DisplayName("测试特殊情况: 完全递增数组")
  void testFullyIncreasingArray() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertTrue(result, "完全递增数组: 玩家1可以通过最优策略获胜");
  }

  /**
   * 测试特殊情况: 包含负数的数组
   */
  @Test
  @DisplayName("测试特殊情况: 包含负数的数组")
  void testArrayWithNegativeNumbers() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { -1, -2, -3, -4 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertTrue(result, "包含负数的数组: 玩家1可以通过最优策略获胜");
  }

  /**
   * 测试特殊情况: 包含零的数组
   */
  @Test
  @DisplayName("测试特殊情况: 包含零的数组")
  void testArrayWithZero() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { 0, 0, 0, 0 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertTrue(result, "包含零的数组: 玩家1可以通过最优策略获胜");
  }

  /**
   * 测试复杂场景: 波动模式数组
   */
  @Test
  @DisplayName("测试复杂场景: 波动模式数组")
  void testFluctuatingPattern() {
    // Arrange: 准备测试数据
    Algo032PredictWinnerDP algo = new Algo032PredictWinnerDP();
    int[] nums = { 5, 3, 7, 10, 2, 4, 8, 1 };

    // Act: 执行测试方法
    boolean result = algo.solution(nums);

    // Assert: 验证结果
    assertTrue(result, "波动模式数组: 玩家1可以通过最优策略获胜");
  }
}
