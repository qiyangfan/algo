package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo004FindPivotIndex
 * 使用 JUnit 5 测试查找数组中枢索引算法的正确性
 */
class Algo004FindPivotIndexTest {

    /**
     * 测试基本功能: 标准数组有中枢索引
     */
    @Test
    @DisplayName("测试标准数组有中枢索引")
    void testStandardArrayWithPivot() {
        Algo004FindPivotIndex algo = new Algo004FindPivotIndex();
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        int result = algo.solution(nums);
        assertEquals(3, result);
    }

    /**
     * 测试最左侧中枢索引
     */
    @Test
    @DisplayName("测试最左侧中枢索引")
    void testLeftmostPivot() {
        Algo004FindPivotIndex algo = new Algo004FindPivotIndex();
        int[] nums = { 2, 1, -1 };
        int result = algo.solution(nums);
        assertEquals(0, result); // 左侧和=0, 右侧和=0
    }

    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        Algo004FindPivotIndex algo = new Algo004FindPivotIndex();
        int[] nums = {};
        int result = algo.solution(nums);
        assertEquals(-1, result);
    }

    /**
     * 测试无中枢索引
     */
    @Test
    @DisplayName("测试无中枢索引")
    void testNoPivotIndex() {
        Algo004FindPivotIndex algo = new Algo004FindPivotIndex();
        int[] nums = { 1, 2, 3 };
        int result = algo.solution(nums);
        assertEquals(-1, result); // 没有中枢索引
    }

    /**
     * 测试单个元素
     */
    @Test
    @DisplayName("测试单个元素")
    void testSingleElement() {
        Algo004FindPivotIndex algo = new Algo004FindPivotIndex();
        int[] nums = { 5 };
        int result = algo.solution(nums);
        assertEquals(0, result);
    }

    /**
     * 测试两个元素
     */
    @Test
    @DisplayName("测试两个元素")
    void testTwoElements() {
        Algo004FindPivotIndex algo = new Algo004FindPivotIndex();
        int[] nums = { 1, 2 };
        int result = algo.solution(nums);
        assertEquals(-1, result);
    }

    /**
     * 测试负数情况
     */
    @Test
    @DisplayName("测试负数情况")
    void testNegativeNumbers() {
        Algo004FindPivotIndex algo = new Algo004FindPivotIndex();
        int[] nums = { -1, -1, -1, 0, 1, 1 };
        int result = algo.solution(nums);
        assertEquals(0, result);
    }
}
