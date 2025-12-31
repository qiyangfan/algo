package com.flyingcode.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: RadixSort
 * 使用JUnit 5测试基数排序算法的正确性
 */
class RadixSortTest {

    /**
     * 测试基本功能: 标准数组有重复元素
     */
    @Test
    @DisplayName("测试标准数组有重复元素")
    void testStandardArray() {
        RadixSort sort = new RadixSort();
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
        RadixSort sort = new RadixSort();
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
        RadixSort sort = new RadixSort();
        int[] result = sort.sort(null);
        assertArrayEquals(null, result);
    }

    /**
     * 测试单元素数组
     */
    @Test
    @DisplayName("测试单元素数组")
    void testSingleElement() {
        RadixSort sort = new RadixSort();
        int[] arr = { 42 };
        int[] expected = { 42 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 包含不同位数的数组
     */
    @Test
    @DisplayName("测试包含不同位数的数组")
    void testArrayWithDifferentDigits() {
        RadixSort sort = new RadixSort();
        int[] arr = { 123, 45, 6, 789, 12, 345 };
        int[] expected = { 6, 12, 45, 123, 345, 789 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 完全递减的数组
     */
    @Test
    @DisplayName("测试完全递减的数组")
    void testFullyDecreasingArray() {
        RadixSort sort = new RadixSort();
        int[] arr = { 500, 40, 3, 2000, 100 };
        int[] expected = { 3, 40, 100, 500, 2000 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 所有元素相同
     */
    @Test
    @DisplayName("测试所有元素相同")
    void testAllSameElements() {
        RadixSort sort = new RadixSort();
        int[] arr = { 55, 55, 55, 55 };
        int[] expected = { 55, 55, 55, 55 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }
}
