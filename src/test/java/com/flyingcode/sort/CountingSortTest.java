package com.flyingcode.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class: CountingSort
 * Uses JUnit 5 to test the correctness of the counting sort algorithm
 */
class CountingSortTest {

    /**
     * 测试基本功能: 标准数组有重复元素
     */
    @Test
    @DisplayName("测试标准数组有重复元素")
    void testStandardArray() {
        CountingSort sort = new CountingSort();
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
        CountingSort sort = new CountingSort();
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
        CountingSort sort = new CountingSort();
        int[] result = sort.sort(null);
        assertArrayEquals(null, result);
    }

    /**
     * 测试单元素数组
     */
    @Test
    @DisplayName("测试单元素数组")
    void testSingleElement() {
        CountingSort sort = new CountingSort();
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
        CountingSort sort = new CountingSort();
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
        CountingSort sort = new CountingSort();
        int[] arr = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试特殊情况: 包含负数的数组
     */
    @Test
    @DisplayName("测试包含负数的数组")
    void testArrayWithNegativeNumbers() {
        CountingSort sort = new CountingSort();
        int[] arr = { -3, 5, -2, 0, 1, -4 };
        int[] expected = { -4, -3, -2, 0, 1, 5 };
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }
}
