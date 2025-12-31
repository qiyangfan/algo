package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo037HouseRobberCycleDP
 * 使用 JUnit 5 测试首尾相连房屋抢劫问题的动态规划数组实现的正确性
 */
class Algo037HouseRobberCycleDPTest {

  /**
   * 测试基本功能: 单个元素数组
   */
  @Test
  @DisplayName("测试基本功能: 单个元素数组")
  void testSingleElement() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 1 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(1, result, "单个元素数组: 抢劫该房屋获得最大金额1");
  }

  /**
   * 测试基本功能: 两个元素数组
   */
  @Test
  @DisplayName("测试基本功能: 两个元素数组")
  void testTwoElements() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 1, 2 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(2, result, "两个元素数组: 选择金额较大的房屋, 获得最大金额2");
  }

  /**
   * 测试基本功能: 三个元素数组 (循环情况)
   */
  @Test
  @DisplayName("测试基本功能: 三个元素数组")
  void testThreeElements() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 1, 5, 2 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(5, result, "三个元素数组: 选择中间金额最大的房屋, 获得最大金额5");
  }

  /**
   * 测试基本功能: 四个元素数组 (循环情况)
   */
  @Test
  @DisplayName("测试基本功能: 四个元素数组")
  void testFourElements() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 1, 5, 2, 4 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(9, result, "四个元素数组: 选择第1和第3个房屋, 获得最大金额5+4=9");
  }

  /**
   * 测试边界条件: 空数组
   */
  @Test
  @DisplayName("测试边界条件: 空数组")
  void testEmptyArray() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = {};

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(0, result, "空数组: 没有房屋可抢劫, 获得最大金额0");
  }

  /**
   * 测试边界条件: null数组
   */
  @Test
  @DisplayName("测试边界条件: null数组")
  void testNullArray() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();

    // Act: 执行测试方法
    int result = algo.solution(null);

    // Assert: 验证结果
    assertEquals(0, result, "null数组: 没有房屋可抢劫, 获得最大金额0");
  }

  /**
   * 测试特殊情况: 所有元素相同
   */
  @Test
  @DisplayName("测试特殊情况: 所有元素相同")
  void testAllSameElements() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 3, 3, 3, 3 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(6, result, "所有元素相同: 选择第1和第3个房屋, 获得最大金额3+3=6");
  }

  /**
   * 测试特殊情况: 完全递增数组
   */
  @Test
  @DisplayName("测试特殊情况: 完全递增数组")
  void testFullyIncreasingArray() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(24, result, "完全递增数组: 选择第2、4、6、8个房屋, 获得最大金额2+4+6+8=20");
  }

  /**
   * 测试特殊情况: 包含零的数组
   */
  @Test
  @DisplayName("测试特殊情况: 包含零的数组")
  void testArrayWithZero() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 0, 0, 0, 0 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(0, result, "包含零的数组: 所有房屋金额为0, 获得最大金额0");
  }

  /**
   * 测试特殊情况: 包含负数的数组
   */
  @Test
  @DisplayName("测试特殊情况: 包含负数的数组")
  void testArrayWithNegativeNumbers() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { -1, -2, -3, -4 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(-1, result, "包含负数的数组: 选择金额最大的房屋, 获得最大金额-1");
  }

  /**
   * 测试复杂场景: 波动模式数组
   */
  @Test
  @DisplayName("测试复杂场景: 波动模式数组")
  void testFluctuatingPattern() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 5, 3, 7, 10, 2, 4, 8, 1 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(23, result, "波动模式数组: 选择第0、3、6个房屋, 获得最大金额5+10+8=23");
  }

  /**
   * 测试复杂场景: 较大数组
   */
  @Test
  @DisplayName("测试复杂场景: 较大数组")
  void testLargeArray() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 2, 7, 9, 3, 1, 5, 8, 4, 6, 10 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(29, result, "较大数组: 选择最优房屋组合, 获得最大金额29");
  }

  /**
   * 测试特殊情况: 循环特性明显的数组
   */
  @Test
  @DisplayName("测试特殊情况: 循环特性明显的数组")
  void testCycleSpecific() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 2, 3, 2 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(3, result, "循环特性明显的数组: 选择中间房屋, 获得最大金额3");
  }

  /**
   * 测试特殊情况: 第一个房屋金额最大
   */
  @Test
  @DisplayName("测试特殊情况: 第一个房屋金额最大")
  void testFirstHouseMax() {
    // Arrange: 准备测试数据
    Algo037HouseRobberCycleDP algo = new Algo037HouseRobberCycleDP();
    int[] nums = { 10, 1, 1, 10 };

    // Act: 执行测试方法
    int result = algo.solution(nums);

    // Assert: 验证结果
    assertEquals(11, result, "第一个房屋金额最大: 选择第2和第4个房屋, 获得最大金额1+10=11");
  }
}
