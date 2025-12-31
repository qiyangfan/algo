package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo022MaxAverageSubarray
 * 使用 JUnit 5 测试查找长度为k的连续子数组最大平均值算法的正确性
 */
class Algo022MaxAverageSubarrayTest {

    /**
     * 测试基本功能: 正整数数组
     */
    @Test
    @DisplayName("测试基本功能: 正整数数组的最大平均值")
    void testBasicPositiveNumbers() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        // 子数组 [12, -5, -6, 50] 的和是 51, 平均值是 12.75
        double result = algo.solution(nums, k);
        assertEquals(12.75, result, 0.0001, "长度为4的最大平均值应该是12.75");
    }

    /**
     * 测试所有元素相同的情况
     */
    @Test
    @DisplayName("测试所有元素相同: 所有窗口平均值相等")
    void testAllSameElements() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 5, 5, 5, 5, 5 };
        int k = 3;
        double result = algo.solution(nums, k);
        assertEquals(5.0, result, 0.0001, "所有元素相同时平均值应该是5.0");
    }

    /**
     * 测试k等于数组长度的情况
     */
    @Test
    @DisplayName("测试k等于数组长度: 整个数组的平均值")
    void testKEqualsArrayLength() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 5;
        // 整个数组的平均值是 (1+2+3+4+5)/5 = 3.0
        double result = algo.solution(nums, k);
        assertEquals(3.0, result, 0.0001, "k等于数组长度时应返回整个数组的平均值");
    }

    /**
     * 测试k等于1的情况
     */
    @Test
    @DisplayName("测试k等于1: 单个元素的最大值")
    void testKEqualsOne() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 1, 5, 3, 9, 2 };
        int k = 1;
        // 最大值是9
        double result = algo.solution(nums, k);
        assertEquals(9.0, result, 0.0001, "k等于1时应返回数组的最大值");
    }

    /**
     * 测试包含负数的情况
     */
    @Test
    @DisplayName("测试包含负数: 负数数组的最大平均值")
    void testNegativeNumbers() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { -1, -2, -3, -1, -2 };
        int k = 2;
        // 所有连续子数组:[-1,-2]=-1.5, [-2,-3]=-2.5, [-3,-1]=-2.0, [-1,-2]=-1.5
        // 最大平均值是 -1.5
        double result = algo.solution(nums, k);
        assertEquals(-1.5, result, 0.0001, "负数数组中应找到相对最大的平均值");
    }

    /**
     * 测试正负数混合的情况
     */
    @Test
    @DisplayName("测试正负数混合: 混合数组的最大平均值")
    void testMixedNumbers() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int k = 3;
        // 子数组 [4, -1, 2] 的和是 5, 平均值约为 1.6667
        double result = algo.solution(nums, k);
        assertEquals(1.6666667, result, 0.0001, "混合数组应正确计算最大平均值");
    }

    /**
     * 测试小数组的情况
     */
    @Test
    @DisplayName("测试小数组: 最小有效数组")
    void testSmallArray() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 100, 200 };
        int k = 2;
        // 只有一个窗口, 平均值是 (100+200)/2 = 150.0
        double result = algo.solution(nums, k);
        assertEquals(150.0, result, 0.0001, "小数组应正确计算平均值");
    }

    /**
     * 测试递增数组的情况
     */
    @Test
    @DisplayName("测试递增数组: 最后一个窗口平均值最大")
    void testIncreasingArray() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 4;
        // 最后一个窗口 [7, 8, 9, 10] 的和是 34, 平均值是 8.5(最大)
        double result = algo.solution(nums, k);
        assertEquals(8.5, result, 0.0001, "递增数组的最后一个窗口平均值最大");
    }

    /**
     * 测试递减数组的情况
     */
    @Test
    @DisplayName("测试递减数组: 第一个窗口平均值最大")
    void testDecreasingArray() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int k = 3;
        // 第一个窗口 [10, 9, 8] 的和是 27, 平均值是 9.0(最大)
        double result = algo.solution(nums, k);
        assertEquals(9.0, result, 0.0001, "递减数组的第一个窗口平均值最大");
    }

    /**
     * 测试包含零的情况
     */
    @Test
    @DisplayName("测试包含零: 零值不影响正确计算")
    void testWithZero() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 0, 5, 0, 10, 0, 15, 0 };
        int k = 3;
        // 子数组 [10, 0, 15] 的和是 25, 平均值约为 8.3333
        double result = algo.solution(nums, k);
        assertEquals(8.33333333, result, 0.0001, "包含零的数组应正确计算平均值");
    }

    /**
     * 测试精度验证: 浮点数除法的准确性
     */
    @Test
    @DisplayName("测试精度验证: 浮点数除法结果准确")
    void testPrecision() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 1, 2, 3 };
        int k = 3;
        double result = algo.solution(nums, k);
        assertEquals(2.0, result, 0.0, "平均值应该精确到小数点后多位");
    }

    /**
     * 测试较大数组的情况
     */
    @Test
    @DisplayName("测试较大数组: 验证算法在较大数据集上的性能")
    void testLargeArray() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i + 1;
        }
        int k = 100;
        // 最后100个元素的平均值:[901, 902, ..., 1000]
        double result = algo.solution(nums, k);
        double expected = (901.0 + 1000.0) / 2;
        assertEquals(expected, result, 0.01, "较大数组应正确计算平均值");
    }

    /**
     * 测试边界情况: 最小k值
     */
    @Test
    @DisplayName("测试边界情况:k的最小值")
    void testMinimumK() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 5 };
        int k = 1;
        double result = algo.solution(nums, k);
        assertEquals(5.0, result, 0.0001, "单元素数组的平均值应该是该元素值");
    }

    /**
     * 测试包含最大整数值的情况
     */
    @Test
    @DisplayName("测试包含最大整数值: 处理大数值")
    void testWithMaxInteger() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2 };
        int k = 2;
        double result = algo.solution(nums, k);
        double expected = (Integer.MAX_VALUE + (Integer.MAX_VALUE - 1)) / 2.0;
        assertEquals(expected, result, 0.01, "应正确处理大整数值");
    }

    /**
     * 测试峰值情况: 单个峰值元素
     */
    @Test
    @DisplayName("测试峰值情况: 包含单个峰值元素")
    void testSinglePeak() {
        Algo022MaxAverageSubarray algo = new Algo022MaxAverageSubarray();
        int[] nums = { 1, 1, 1, 100, 1, 1, 1 };
        int k = 3;
        // 包含100的窗口 [1, 100, 1] 平均值最大, 约为 34.0
        double result = algo.solution(nums, k);
        assertEquals(34.0, result, 0.0001, "应找到包含峰值的窗口");
    }
}
