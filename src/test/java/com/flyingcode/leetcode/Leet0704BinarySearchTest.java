package com.flyingcode.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Leet0704BinarySearch
 * 使用JUnit 5测试二分查找算法的正确性
 */
class Leet0704BinarySearchTest {

    /**
     * 测试边界条件: 空数组返回-1
     */
    @Test
    @DisplayName("测试边界条件: 空数组返回-1")
    void testEmptyArray() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = {};
        int target = 5;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(-1, result, "空数组应该返回-1");
    }

    /**
     * 测试边界条件: null数组返回-1
     */
    @Test
    @DisplayName("测试边界条件: null数组返回-1")
    void testNullArray() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = null;
        int target = 5;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(-1, result, "null数组应该返回-1");
    }

    /**
     * 测试边界条件: 只有一个元素的数组, 找到目标值
     */
    @Test
    @DisplayName("测试边界条件: 只有一个元素的数组, 找到目标值")
    void testSingleElementFound() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = { 5 };
        int target = 5;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(0, result, "只有一个元素的数组, 找到目标值应该返回0");
    }

    /**
     * 测试边界条件: 只有一个元素的数组, 未找到目标值
     */
    @Test
    @DisplayName("测试边界条件: 只有一个元素的数组, 未找到目标值")
    void testSingleElementNotFound() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = { 5 };
        int target = 3;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(-1, result, "只有一个元素的数组, 未找到目标值应该返回-1");
    }

    /**
     * 测试基本功能: 数组中间位置找到目标值
     */
    @Test
    @DisplayName("测试基本功能: 数组中间位置找到目标值")
    void testTargetInMiddle() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 5;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(3, result, "数组[-1, 0, 3, 5, 9, 12]中目标值5应该在索引3的位置");
    }

    /**
     * 测试基本功能: 数组开头找到目标值
     */
    @Test
    @DisplayName("测试基本功能: 数组开头找到目标值")
    void testTargetAtStart() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = -1;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(0, result, "数组[-1, 0, 3, 5, 9, 12]中目标值-1应该在索引0的位置");
    }

    /**
     * 测试基本功能: 数组结尾找到目标值
     */
    @Test
    @DisplayName("测试基本功能: 数组结尾找到目标值")
    void testTargetAtEnd() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 12;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(5, result, "数组[-1, 0, 3, 5, 9, 12]中目标值12应该在索引5的位置");
    }

    /**
     * 测试特殊情况: 目标值小于所有元素
     */
    @Test
    @DisplayName("测试特殊情况: 目标值小于所有元素")
    void testTargetLessThanAll() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = -5;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(-1, result, "目标值-5小于数组中所有元素, 应该返回-1");
    }

    /**
     * 测试特殊情况: 目标值大于所有元素
     */
    @Test
    @DisplayName("测试特殊情况: 目标值大于所有元素")
    void testTargetGreaterThanAll() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 15;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(-1, result, "目标值15大于数组中所有元素, 应该返回-1");
    }

    /**
     * 测试特殊情况: 数组中有重复元素
     */
    @Test
    @DisplayName("测试特殊情况: 数组中有重复元素")
    void testArrayWithDuplicates() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        int[] nums = { -1, 0, 3, 3, 5, 9, 12 };
        int target = 3;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果 - 二分查找不保证找到重复元素中的哪一个, 但应该找到其中一个
        assertTrue(result == 2 || result == 3, "数组[-1, 0, 3, 3, 5, 9, 12]中目标值3应该在索引2或3的位置");
        assertEquals(3, nums[result], "找到的元素应该是3");
    }

    /**
     * 测试特殊情况: 较大的数组
     */
    @Test
    @DisplayName("测试特殊情况: 较大的数组")
    void testLargeArray() {
        // 准备测试数据
        Leet0704BinarySearch algo = new Leet0704BinarySearch();
        // 创建一个包含100个元素的有序数组
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i * 2;
        }
        int target = 150;

        // 执行测试方法
        int result = algo.solution(nums, target);

        // 验证结果
        assertEquals(75, result, "较大数组中目标值150应该在索引75的位置");
    }
}
