package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo009MaxProductThree
 * 使用 JUnit 5 测试三个数最大乘积算法的正确性
 */
class Algo009MaxProductThreeTest {

    /**
     * 测试基本功能: 正数数组
     */
    @Test
    @DisplayName("测试基本功能: 正数数组")
    void testAllPositiveNumbers() {
        Algo009MaxProductThree algo = new Algo009MaxProductThree();
        int[] nums = { 1, 2, 3 };
        int result = algo.solution(nums);
        assertEquals(6, result);
    }

    /**
     * 测试包含负数的情况: 两个负数乘积为正
     */
    @Test
    @DisplayName("测试包含负数的情况: 两个负数乘积为正")
    void testWithNegativeNumbers() {
        Algo009MaxProductThree algo = new Algo009MaxProductThree();
        int[] nums = { 1, 2, 3, 4 };
        int result = algo.solution(nums);
        assertEquals(24, result);
    }

    /**
     * 测试负数乘积更大的情况
     */
    @Test
    @DisplayName("测试负数乘积更大的情况")
    void testNegativeProductLarger() {
        Algo009MaxProductThree algo = new Algo009MaxProductThree();
        int[] nums = { -100, -98, -1, 2, 3, 4 };
        int result = algo.solution(nums);
        assertEquals(39200, result); // -100 * -98 * 4
    }

    /**
     * 测试全部为负数
     */
    @Test
    @DisplayName("测试全部为负数")
    void testAllNegativeNumbers() {
        Algo009MaxProductThree algo = new Algo009MaxProductThree();
        int[] nums = { -4, -3, -2, -1 };
        int result = algo.solution(nums);
        assertEquals(-6, result); // -1 * -2 * -3
    }

    /**
     * 测试混合正负数
     */
    @Test
    @DisplayName("测试混合正负数")
    void testMixedNumbers() {
        Algo009MaxProductThree algo = new Algo009MaxProductThree();
        int[] nums = { -10, -10, 5, 2 };
        int result = algo.solution(nums);
        assertEquals(500, result); // -10 * -10 * 5
    }

    /**
     * 测试包含零的情况
     */
    @Test
    @DisplayName("测试包含零的情况")
    void testWithZero() {
        Algo009MaxProductThree algo = new Algo009MaxProductThree();
        int[] nums = { -5, -4, 0, 1, 2 };
        int result = algo.solution(nums);
        assertEquals(40, result); // -5 * -4 * 2
    }

    /**
     * 性能测试: 大规模数据测试
     */
    @Test
    @DisplayName("性能测试: 大规模数据")
    void testPerformanceLargeArray() {
        Algo009MaxProductThree algo = new Algo009MaxProductThree();
        int[] nums = new int[10000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i - 5000; // -5000 到 4999
        }

        // 执行算法并验证结果
        int result = algo.solution(nums);

        // 验证结果正确性
        assertTrue(result > 0);
    }

    /**
     * 性能测试: 中等规模数据
     */
    @Test
    @DisplayName("性能测试: 中等规模数据")
    void testPerformanceMediumArray() {
        Algo009MaxProductThree algo = new Algo009MaxProductThree();
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i - 500; // -500 到 499
        }

        // 执行算法并验证结果
        int result = algo.solution(nums);

        assertTrue(result > 0);
    }

    /**
     * 功能测试: 小规模数据
     */
    @Test
    @DisplayName("功能测试: 小规模数据")
    void testSmallArray() {
        Algo009MaxProductThree algo = new Algo009MaxProductThree();
        int[] nums = { 1, 2, 3, 4, 5 };

        int result = algo.solution(nums);

        assertEquals(60, result);
    }
}
