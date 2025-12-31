package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo011TwoSumBrute
 * 使用 JUnit 5 测试两数之和(暴力解法)算法的正确性
 */
class Algo011TwoSumBruteTest {

    /**
     * 测试基本功能: 标准输入
     */
    @Test
    @DisplayName("测试基本功能: 标准输入")
    void testStandardInput() {
        Algo011TwoSumBrute algo = new Algo011TwoSumBrute();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 1 }, result);
    }

    /**
     * 测试目标值在数组中间
     */
    @Test
    @DisplayName("测试目标值在数组中间")
    void testMiddleTarget() {
        Algo011TwoSumBrute algo = new Algo011TwoSumBrute();
        int[] nums = { 3, 2, 4 };
        int target = 6;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 1, 2 }, result);
    }

    /**
     * 测试目标值由重复元素组成
     */
    @Test
    @DisplayName("测试目标值由重复元素组成")
    void testDuplicateElements() {
        Algo011TwoSumBrute algo = new Algo011TwoSumBrute();
        int[] nums = { 3, 3 };
        int target = 6;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 1 }, result);
    }

    /**
     * 测试负数情况
     */
    @Test
    @DisplayName("测试负数情况")
    void testNegativeNumbers() {
        Algo011TwoSumBrute algo = new Algo011TwoSumBrute();
        int[] nums = { -1, -2, -3, -4, -5 };
        int target = -8;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 2, 4 }, result); // -3 + -5 = -8
    }

    /**
     * 测试包含零
     */
    @Test
    @DisplayName("测试包含零")
    void testWithZero() {
        Algo011TwoSumBrute algo = new Algo011TwoSumBrute();
        int[] nums = { 0, 4, 3, 0 };
        int target = 0;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 3 }, result);
    }

    /**
     * 测试无解情况 - 返回默认数组[0,0]
     */
    @Test
    @DisplayName("测试无解情况 - 返回默认数组[0,0]")
    void testNoSolution() {
        Algo011TwoSumBrute algo = new Algo011TwoSumBrute();
        int[] nums = { 1, 2, 3 };
        int target = 10;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 0 }, result); // 返回默认初始化的数组
    }
}
