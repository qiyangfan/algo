package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo013TwoSumSorted
 * 使用 JUnit 5 测试两数之和(有序数组双指针)算法的正确性
 */
class Algo013TwoSumSortedTest {

    /**
     * 测试基本功能: 标准输入
     */
    @Test
    @DisplayName("测试基本功能: 标准输入")
    void testStandardInput() {
        Algo013TwoSumSorted algo = new Algo013TwoSumSorted();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 1 }, result); // 返回的下标从0开始
    }

    /**
     * 测试目标值在数组中间
     */
    @Test
    @DisplayName("测试目标值在数组中间")
    void testMiddleTarget() {
        Algo013TwoSumSorted algo = new Algo013TwoSumSorted();
        int[] nums = { 2, 3, 4 };
        int target = 6;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 2 }, result); // 2 + 4 = 6
    }

    /**
     * 测试负数情况
     */
    @Test
    @DisplayName("测试负数情况")
    void testNegativeNumbers() {
        Algo013TwoSumSorted algo = new Algo013TwoSumSorted();
        int[] nums = { -5, -3, -2, -1 };
        int target = -8;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 1 }, result); // -5 + -3 = -8
    }

    /**
     * 测试包含零
     */
    @Test
    @DisplayName("测试包含零")
    void testWithZero() {
        Algo013TwoSumSorted algo = new Algo013TwoSumSorted();
        int[] nums = { -1, 0, 1, 2 };
        int target = 1;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 3 }, result); // -1 + 2 = 1
    }

    /**
     * 测试无解情况 - 返回默认数组[0,0]
     */
    @Test
    @DisplayName("测试无解情况 - 返回默认数组[0,0]")
    void testNoSolution() {
        Algo013TwoSumSorted algo = new Algo013TwoSumSorted();
        int[] nums = { 1, 2, 3 };
        int target = 10;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 0 }, result); // 返回默认初始化的数组
    }

    /**
     * 测试两个元素
     */
    @Test
    @DisplayName("测试两个元素")
    void testTwoElements() {
        Algo013TwoSumSorted algo = new Algo013TwoSumSorted();
        int[] nums = { 1, 5 };
        int target = 6;
        int[] result = algo.solution(nums, target);
        assertArrayEquals(new int[] { 0, 1 }, result);
    }
}
