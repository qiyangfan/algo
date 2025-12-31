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

    /**
     * 测试双轴快排: 传统快排和双轴快排结果一致
     */
    @Test
    @DisplayName("测试双轴快排: 传统快排和双轴快排结果一致")
    void testDualPivotConsistency() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums1 = { 5, 2, 9, 1, 7, 6, 3, 8, 4 };
        int[] nums2 = nums1.clone();
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // 执行测试方法
        int[] resultTraditional = algo.solutionWithTraditionalQuickSort(nums1);
        int[] resultDualPivot = algo.solutionWithDualPivotQuickSort(nums2);

        // 验证两种算法结果一致且正确
        assertArrayEquals(expected, resultTraditional, "传统快排应该产生正确结果");
        assertArrayEquals(expected, resultDualPivot, "双轴快排应该产生正确结果");
    }

    /**
     * 测试双轴快排边界: 空数组
     */
    @Test
    @DisplayName("测试双轴快排边界: 空数组")
    void testDualPivotEmptyArray() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = {};
        int[] expected = {};

        // 执行测试方法
        int[] result = algo.solutionWithDualPivotQuickSort(nums);

        // 验证结果
        assertArrayEquals(expected, result, "双轴快排处理空数组应该返回空数组");
    }

    /**
     * 测试双轴快排边界: 单元素
     */
    @Test
    @DisplayName("测试双轴快排边界: 单元素")
    void testDualPivotSingleElement() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 42 };
        int[] expected = { 42 };

        // 执行测试方法
        int[] result = algo.solutionWithDualPivotQuickSort(nums);

        // 验证结果
        assertArrayEquals(expected, result, "双轴快排处理单元素数组应该返回原数组");
    }

    /**
     * 测试传统快排边界: 空数组
     */
    @Test
    @DisplayName("测试传统快排边界: 空数组")
    void testTraditionalEmptyArray() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = {};
        int[] expected = {};

        // 执行测试方法
        int[] result = algo.solutionWithTraditionalQuickSort(nums);

        // 验证结果
        assertArrayEquals(expected, result, "传统快排处理空数组应该返回空数组");
    }

    /**
     * 测试传统快排边界: 单元素
     */
    @Test
    @DisplayName("测试传统快排边界: 单元素")
    void testTraditionalSingleElement() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 42 };
        int[] expected = { 42 };

        // 执行测试方法
        int[] result = algo.solutionWithTraditionalQuickSort(nums);

        // 验证结果
        assertArrayEquals(expected, result, "传统快排处理单元素数组应该返回原数组");
    }

    /**
     * 测试双轴快排: 已排序数组
     */
    @Test
    @DisplayName("测试双轴快排: 已排序数组")
    void testDualPivotAlreadySorted() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // 执行测试方法
        int[] result = algo.solutionWithDualPivotQuickSort(nums);

        // 验证结果
        assertArrayEquals(expected, result, "双轴快排处理已排序数组应该保持不变");
    }

    /**
     * 测试传统快排: 已排序数组
     */
    @Test
    @DisplayName("测试传统快排: 已排序数组")
    void testTraditionalAlreadySorted() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // 执行测试方法
        int[] result = algo.solutionWithTraditionalQuickSort(nums);

        // 验证结果
        assertArrayEquals(expected, result, "传统快排处理已排序数组应该保持不变");
    }

    /**
     * 测试双轴快排: 包含重复元素
     */
    @Test
    @DisplayName("测试双轴快排: 包含重复元素")
    void testDualPivotWithDuplicates() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 5, 2, 5, 1, 2, 9, 1, 5, 3 };
        int[] expected = { 1, 1, 2, 2, 3, 5, 5, 5, 9 };

        // 执行测试方法
        int[] result = algo.solutionWithDualPivotQuickSort(nums);

        // 验证结果
        assertArrayEquals(expected, result, "双轴快排应该正确处理包含重复元素的数组");
    }

    /**
     * 测试双轴快排: 包含负数
     */
    @Test
    @DisplayName("测试双轴快排: 包含负数")
    void testDualPivotWithNegatives() {
        // 准备测试数据
        Leet0912SortAnArray algo = new Leet0912SortAnArray();
        int[] nums = { 5, -2, 9, -1, 7, -6, 3, 8, -4 };
        int[] expected = { -6, -4, -2, -1, 3, 5, 7, 8, 9 };

        // 执行测试方法
        int[] result = algo.solutionWithDualPivotQuickSort(nums);

        // 验证结果
        assertArrayEquals(expected, result, "双轴快排应该正确处理包含负数的数组");
    }
}
