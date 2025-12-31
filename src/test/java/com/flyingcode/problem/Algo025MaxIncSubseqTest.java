package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo025MaxIncSubseq
 * 使用 JUnit 5 测试最长连续递增子序列算法的正确性
 */
class Algo025MaxIncSubseqTest {

    /**
     * 测试基本功能: 标准数组有多个连续递增序列
     */
    @Test
    @DisplayName("测试标准数组有多个连续递增序列")
    void testStandardArrayWithMultipleIncreasingSequences() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 3, 5, 4, 7 };
        int result = algo.solution(nums);
        assertEquals(3, result, "数组 [1,3,5,4,7] 中最长连续递增子序列为 [1,3,5], 长度为3");
    }

    /**
     * 测试完全递增数组
     */
    @Test
    @DisplayName("测试完全递增数组")
    void testFullyIncreasingArray() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 2, 3, 4, 5 };
        int result = algo.solution(nums);
        assertEquals(5, result, "完全递增数组 [1,2,3,4,5] 的最长连续递增子序列长度为5");
    }

    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = {};
        int result = algo.solution(nums);
        assertEquals(0, result, "空数组的最长连续递增子序列长度为0");
    }

    /**
     * 测试边界条件:null数组
     */
    @Test
    @DisplayName("测试边界条件:null数组")
    void testNullArray() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = null;
        int result = algo.solution(nums);
        assertEquals(0, result, "null数组的最长连续递增子序列长度为0");
    }

    /**
     * 测试单个元素
     */
    @Test
    @DisplayName("测试单个元素")
    void testSingleElement() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1 };
        int result = algo.solution(nums);
        assertEquals(1, result, "单个元素数组的最长连续递增子序列长度为1");
    }

    /**
     * 测试完全递减数组
     */
    @Test
    @DisplayName("测试完全递减数组")
    void testFullyDecreasingArray() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 5, 4, 3, 2, 1 };
        int result = algo.solution(nums);
        assertEquals(1, result, "完全递减数组 [5,4,3,2,1] 的最长连续递增子序列长度为1");
    }

    /**
     * 测试所有元素相同
     */
    @Test
    @DisplayName("测试所有元素相同")
    void testAllSameElements() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 2, 2, 2, 2, 2 };
        int result = algo.solution(nums);
        assertEquals(1, result, "所有元素相同的数组的最长连续递增子序列长度为1");
    }

    /**
     * 测试包含负数的数组
     */
    @Test
    @DisplayName("测试包含负数的数组")
    void testArrayWithNegativeNumbers() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { -2, -1, 0, 1, 2 };
        int result = algo.solution(nums);
        assertEquals(5, result, "包含负数的递增数组 [-2,-1,0,1,2] 的最长连续递增子序列长度为5");
    }

    /**
     * 测试长数组中的多个递增序列
     */
    @Test
    @DisplayName("测试长数组中的多个递增序列")
    void testLongArrayWithMultipleSequences() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 2, 3, 1, 2, 3, 4, 5, 2, 3 };
        int result = algo.solution(nums);
        assertEquals(5, result, "长数组中最长连续递增子序列为 [1,2,3,4,5], 长度为5");
    }

    /**
     * 测试两个连续递增序列长度相同
     */
    @Test
    @DisplayName("测试两个连续递增序列长度相同")
    void testTwoSequencesWithSameLength() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 2, 3, 0, 1, 2 };
        int result = algo.solution(nums);
        assertEquals(3, result, "两个长度为3的连续递增序列, 最长长度应为3");
    }

    /**
     * 测试包含零的数组
     */
    @Test
    @DisplayName("测试包含零的数组")
    void testArrayWithZero() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 0, 1, 2, 3 };
        int result = algo.solution(nums);
        assertEquals(4, result, "从零开始的递增数组 [0,1,2,3] 的最长连续递增子序列长度为4");
    }

    /**
     * 测试两个元素
     */
    @Test
    @DisplayName("测试两个元素递增")
    void testTwoElementsIncreasing() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 2 };
        int result = algo.solution(nums);
        assertEquals(2, result, "两个递增元素 [1,2] 的最长连续递增子序列长度为2");
    }

    /**
     * 测试两个元素递减
     */
    @Test
    @DisplayName("测试两个元素递减")
    void testTwoElementsDecreasing() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 2, 1 };
        int result = algo.solution(nums);
        assertEquals(1, result, "两个递减元素 [2,1] 的最长连续递增子序列长度为1");
    }

    /**
     * 测试波动数组
     */
    @Test
    @DisplayName("测试波动数组")
    void testFluctuatingArray() {
        Algo025MaxIncSubseq algo = new Algo025MaxIncSubseq();
        int[] nums = { 1, 3, 2, 4, 3, 5 };
        int result = algo.solution(nums);
        assertEquals(2, result, "波动数组 [1,3,2,4,3,5] 中最长连续递增子序列长度为2");
    }
}
