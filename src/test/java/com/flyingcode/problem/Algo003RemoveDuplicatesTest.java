package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo003RemoveDuplicates
 * 使用 JUnit 5 测试移除有序数组重复项算法的正确性
 */
class Algo003RemoveDuplicatesTest {

    /**
     * 测试基本功能: 标准数组有重复元素
     */
    @Test
    @DisplayName("测试标准数组有重复元素")
    void testStandardArrayWithDuplicates() {
        Algo003RemoveDuplicates algo = new Algo003RemoveDuplicates();
        int[] nums = { 1, 1, 2 };
        int result = algo.solution(nums);
        assertEquals(2, result);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    /**
     * 测试多个重复元素
     */
    @Test
    @DisplayName("测试多个重复元素")
    void testMultipleDuplicates() {
        Algo003RemoveDuplicates algo = new Algo003RemoveDuplicates();
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int result = algo.solution(nums);
        assertEquals(5, result);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);
    }

    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        Algo003RemoveDuplicates algo = new Algo003RemoveDuplicates();
        int[] nums = {};
        int result = algo.solution(nums);
        assertEquals(0, result);
    }

    /**
     * 测试无重复元素
     */
    @Test
    @DisplayName("测试无重复元素")
    void testNoDuplicates() {
        Algo003RemoveDuplicates algo = new Algo003RemoveDuplicates();
        int[] nums = { 1, 2, 3, 4, 5 };
        int result = algo.solution(nums);
        assertEquals(5, result);
    }

    /**
     * 测试全部相同元素
     */
    @Test
    @DisplayName("测试全部相同元素")
    void testAllSameElements() {
        Algo003RemoveDuplicates algo = new Algo003RemoveDuplicates();
        int[] nums = { 2, 2, 2, 2, 2 };
        int result = algo.solution(nums);
        assertEquals(1, result);
        assertEquals(2, nums[0]);
    }

    /**
     * 测试单个元素
     */
    @Test
    @DisplayName("测试单个元素")
    void testSingleElement() {
        Algo003RemoveDuplicates algo = new Algo003RemoveDuplicates();
        int[] nums = { 1 };
        int result = algo.solution(nums);
        assertEquals(1, result);
    }
}
