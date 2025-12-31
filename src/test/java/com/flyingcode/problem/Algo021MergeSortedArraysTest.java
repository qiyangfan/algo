package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo021MergeSortedArrays
 * 使用 JUnit 5 测试双指针法合并两个有序数组算法的正确性
 */
class Algo021MergeSortedArraysTest {

    /**
     * 测试基本功能: 两个非空有序数组合并
     */
    @Test
    @DisplayName("测试两个非空有序数组合并")
    void testMergeTwoNonEmptyArrays() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 3, 5, 7 };
        int[] nums2 = { 2, 4, 6, 8 };
        int[] result = algo.solution(nums1, 4, nums2, 4);
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: 两个空数组合并
     */
    @Test
    @DisplayName("测试两个空数组合并")
    void testMergeTwoEmptyArrays() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = {};
        int[] nums2 = {};
        int[] result = algo.solution(nums1, 0, nums2, 0);
        int[] expected = {};
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: 第一个数组为空, 第二个数组非空
     */
    @Test
    @DisplayName("测试第一个数组为空")
    void testMergeFirstArrayEmpty() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = {};
        int[] nums2 = { 2, 4, 6 };
        int[] result = algo.solution(nums1, 0, nums2, 3);
        int[] expected = { 2, 4, 6 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: 第二个数组为空, 第一个数组非空
     */
    @Test
    @DisplayName("测试第二个数组为空")
    void testMergeSecondArrayEmpty() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 3, 5 };
        int[] nums2 = {};
        int[] result = algo.solution(nums1, 3, nums2, 0);
        int[] expected = { 1, 3, 5 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: 两个单元素数组合并
     */
    @Test
    @DisplayName("测试两个单元素数组合并")
    void testMergeTwoSingleElementArrays() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1 };
        int[] nums2 = { 2 };
        int[] result = algo.solution(nums1, 1, nums2, 1);
        int[] expected = { 1, 2 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 两个数组包含相同元素
     */
    @Test
    @DisplayName("测试两个数组包含相同元素")
    void testMergeArraysWithDuplicateElements() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 2, 3, 4 };
        int[] result = algo.solution(nums1, 3, nums2, 3);
        int[] expected = { 1, 2, 2, 3, 3, 4 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 两个数组完全相同
     */
    @Test
    @DisplayName("测试两个数组完全相同")
    void testMergeIdenticalArrays() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 2, 3, 4 };
        int[] nums2 = { 1, 2, 3, 4 };
        int[] result = algo.solution(nums1, 4, nums2, 4);
        int[] expected = { 1, 1, 2, 2, 3, 3, 4, 4 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 第一个数组所有元素都小于第二个数组
     */
    @Test
    @DisplayName("测试第一个数组所有元素小于第二个数组")
    void testMergeFirstAllSmaller() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 4, 5, 6 };
        int[] result = algo.solution(nums1, 3, nums2, 3);
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 第二个数组所有元素都小于第一个数组
     */
    @Test
    @DisplayName("测试第二个数组所有元素小于第一个数组")
    void testMergeSecondAllSmaller() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 4, 5, 6 };
        int[] nums2 = { 1, 2, 3 };
        int[] result = algo.solution(nums1, 3, nums2, 3);
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 数组包含负数
     */
    @Test
    @DisplayName("测试数组包含负数")
    void testMergeArraysWithNegativeNumbers() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { -5, -3, -1 };
        int[] nums2 = { -2, 0, 2 };
        int[] result = algo.solution(nums1, 3, nums2, 3);
        int[] expected = { -5, -3, -2, -1, 0, 2 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 数组包含零
     */
    @Test
    @DisplayName("测试数组包含零")
    void testMergeArraysWithZero() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { -2, 0, 2 };
        int[] nums2 = { -1, 0, 1 };
        int[] result = algo.solution(nums1, 3, nums2, 3);
        int[] expected = { -2, -1, 0, 0, 1, 2 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: 数组长度不相等(第一个数组较长)
     */
    @Test
    @DisplayName("测试第一个数组较长")
    void testMergeFirstArrayLonger() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 3, 5, 7, 9 };
        int[] nums2 = { 2, 4 };
        int[] result = algo.solution(nums1, 5, nums2, 2);
        int[] expected = { 1, 2, 3, 4, 5, 7, 9 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: 数组长度不相等(第二个数组较长)
     */
    @Test
    @DisplayName("测试第二个数组较长")
    void testMergeSecondArrayLonger() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 2, 4 };
        int[] nums2 = { 1, 3, 5, 7, 9 };
        int[] result = algo.solution(nums1, 2, nums2, 5);
        int[] expected = { 1, 2, 3, 4, 5, 7, 9 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: 大数组合并
     */
    @Test
    @DisplayName("测试大数组合并")
    void testMergeLargeArrays() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = new int[100];
        int[] nums2 = new int[100];
        for (int i = 0; i < 100; i++) {
            nums1[i] = i * 2;
            nums2[i] = i * 2 + 1;
        }
        int[] result = algo.solution(nums1, 100, nums2, 100);
        assertEquals(200, result.length);
        for (int i = 0; i < 200; i++) {
            assertEquals(i, result[i]);
        }
    }

    /**
     * 测试特殊情况: 数组包含重复元素
     */
    @Test
    @DisplayName("测试数组包含重复元素")
    void testMergeArraysWithRepeatedElements() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 1, 2, 2 };
        int[] nums2 = { 1, 2, 2, 3 };
        int[] result = algo.solution(nums1, 4, nums2, 4);
        int[] expected = { 1, 1, 1, 2, 2, 2, 2, 3 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: 数组仅有一个元素且相等
     */
    @Test
    @DisplayName("测试单元素相等数组合并")
    void testMergeSingleEqualElementArrays() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 5 };
        int[] nums2 = { 5 };
        int[] result = algo.solution(nums1, 1, nums2, 1);
        int[] expected = { 5, 5 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 交错有序数组
     */
    @Test
    @DisplayName("测试交错有序数组合并")
    void testMergeInterleavedArrays() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 3, 5, 7 };
        int[] nums2 = { 2, 4, 6, 8 };
        int[] result = algo.solution(nums1, 4, nums2, 4);
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8 };
        assertArrayEquals(expected, result);
    }

    /**
     * 测试返回结果不被修改
     */
    @Test
    @DisplayName("测试返回结果是新数组")
    void testReturnNewArray() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 3, 5 };
        int[] nums2 = { 2, 4, 6 };
        int[] result = algo.solution(nums1, 3, nums2, 3);

        // 验证返回的不是输入数组
        assertNotSame(nums1, result);
        assertNotSame(nums2, result);

        // 修改输入数组不影响结果
        nums1[0] = 999;
        assertEquals(1, result[0]);
    }

    /**
     * 测试输入数组不被修改
     */
    @Test
    @DisplayName("测试输入数组不被修改")
    void testInputArraysNotModified() {
        Algo021MergeSortedArrays algo = new Algo021MergeSortedArrays();
        int[] nums1 = { 1, 3, 5 };
        int[] nums2 = { 2, 4, 6 };
        int[] originalNums1 = nums1.clone();
        int[] originalNums2 = nums2.clone();

        algo.solution(nums1, 3, nums2, 3);

        assertArrayEquals(originalNums1, nums1);
        assertArrayEquals(originalNums2, nums2);
    }
}
