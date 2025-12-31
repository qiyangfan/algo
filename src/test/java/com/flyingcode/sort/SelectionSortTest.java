package com.flyingcode.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: SelectionSort
 * 使用JUnit 5测试选择排序算法的正确性
 */
class SelectionSortTest {

    /**
     * 测试基本功能: 标准数组有重复元素
     */
    @Test
    @DisplayName("测试标准数组有重复元素")
    void testStandardArray() {
        SelectionSort sort = new SelectionSort();
        int[] arr = { 5, 2, 8, 3, 1, 6 };
        int[] expected = { 1, 2, 3, 5, 6, 8 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试空数组")
    void testEmptyArray() {
        SelectionSort sort = new SelectionSort();
        int[] arr = {};
        int[] expected = {};
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试边界条件: null数组
     */
    @Test
    @DisplayName("测试null数组")
    void testNullArray() {
        SelectionSort sort = new SelectionSort();
        int[] result = sort.sort(null);
        assertArrayEquals(null, result);
    }

    /**
     * 测试单元素数组
     */
    @Test
    @DisplayName("测试单元素数组")
    void testSingleElement() {
        SelectionSort sort = new SelectionSort();
        int[] arr = { 42 };
        int[] expected = { 42 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 完全递增的数组
     */
    @Test
    @DisplayName("测试完全递增的数组")
    void testFullyIncreasingArray() {
        SelectionSort sort = new SelectionSort();
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 完全递减的数组
     */
    @Test
    @DisplayName("测试完全递减的数组")
    void testFullyDecreasingArray() {
        SelectionSort sort = new SelectionSort();
        int[] arr = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 所有元素相同
     */
    @Test
    @DisplayName("测试所有元素相同")
    void testAllSameElements() {
        SelectionSort sort = new SelectionSort();
        int[] arr = { 3, 3, 3, 3, 3 };
        int[] expected = { 3, 3, 3, 3, 3 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }
}
