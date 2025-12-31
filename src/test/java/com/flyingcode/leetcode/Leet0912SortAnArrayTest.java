package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Leet0912SortAnArray
 * 使用JUnit 5测试排序数组算法的正确性
 */
class Leet0912SortAnArrayTest {

    /**
     * 测试边界条件: 空数组返回空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组返回空数组")
    void testEmptyArray() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = {};
        int[] expected = {};

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "空数组应该返回空数组");
    }

    /**
     * 测试边界条件: null数组返回null
     */
    @Test
    @DisplayName("测试边界条件: null数组返回null")
    void testNullArray() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = null;
        int[] expected = null;

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "null数组应该返回null");
    }

    /**
     * 测试边界条件: 只有一个元素的数组返回原数组
     */
    @Test
    @DisplayName("测试边界条件: 只有一个元素的数组返回原数组")
    void testSingleElement() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 5 };
        int[] expected = { 5 };

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "只有一个元素的数组应该返回原数组");
    }

    /**
     * 测试基本功能: 已经排序的数组
     */
    @Test
    @DisplayName("测试基本功能: 已经排序的数组")
    void testAlreadySorted() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "已经排序的数组应该保持不变");
    }

    /**
     * 测试基本功能: 逆序数组
     */
    @Test
    @DisplayName("测试基本功能: 逆序数组")
    void testReverseSorted() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "逆序数组应该被正确排序");
    }

    /**
     * 测试基本功能: 随机顺序数组
     */
    @Test
    @DisplayName("测试基本功能: 随机顺序数组")
    void testRandomOrder() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
        int[] expected = { 1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9 };

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "随机顺序数组应该被正确排序");
    }

    /**
     * 测试特殊情况: 包含重复元素的数组
     */
    @Test
    @DisplayName("测试特殊情况: 包含重复元素的数组")
    void testWithDuplicates() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 2, 2, 2, 2, 2 };
        int[] expected = { 2, 2, 2, 2, 2 };

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "包含重复元素的数组应该被正确排序");
    }

    /**
     * 测试特殊情况: 包含正负数的数组
     */
    @Test
    @DisplayName("测试特殊情况: 包含正负数的数组")
    void testWithNegatives() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { -3, 1, -4, 1, -5, 9, -2, 6, -5, 3, -5 };
        int[] expected = { -5, -5, -5, -4, -3, -2, 1, 1, 3, 6, 9 };

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "包含正负数的数组应该被正确排序");
    }

    /**
     * 测试特殊情况: 包含零的数组
     */
    @Test
    @DisplayName("测试特殊情况: 包含零的数组")
    void testWithZeros() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 0, 0, 1, 0, -1, 0, 2, 0, -2, 0, 3 };
        int[] expected = { -2, -1, 0, 0, 0, 0, 0, 0, 1, 2, 3 };

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "包含零的数组应该被正确排序");
    }

    /**
     * 测试特殊情况: 较大的数组
     */
    @Test
    @DisplayName("测试特殊情况: 较大的数组")
    void testLargeArray() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        // 创建一个包含100个随机顺序元素的数组
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = 50 - i;
        }
        // 预期结果是排序后的数组
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            expected[i] = i - 49;
        }

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "较大的数组应该被正确排序");
    }

    /**
     * 测试特殊情况: 只有两个元素的数组
     */
    @Test
    @DisplayName("测试特殊情况: 只有两个元素的数组")
    void testTwoElements() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 2, 1 };
        int[] expected = { 1, 2 };

        // 执行测试方法
        int[] result = algo.solution(nums);

        // 验证结果
        assertArrayEquals(expected, result, "只有两个元素的数组应该被正确排序");
    }
}
