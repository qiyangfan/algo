package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo027MaxPerimeterTriangle
 * 使用 JUnit 5 测试最大周长三角形算法的正确性
 */
class Algo027MaxPerimeterTriangleTest {

    /**
     * 测试基本功能: 能构成三角形的标准情况
     */
    @Test
    @DisplayName("测试基本功能: 能构成三角形")
    void testCanFormTriangle() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 2, 1, 2 };
        int result = algo.solution(nums);
        assertEquals(5, result, "数组 [2,1,2] 可以构成周长为5的三角形");
    }

    /**
     * 测试基本功能: 不能构成三角形
     */
    @Test
    @DisplayName("测试基本功能: 不能构成三角形")
    void testCannotFormTriangle() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 1, 2, 3 };
        int result = algo.solution(nums);
        assertEquals(0, result, "数组 [1,2,3] 无法构成三角形,1+2不大于3");
    }

    /**
     * 测试边界条件:null数组
     */
    @Test
    @DisplayName("测试边界条件:null数组")
    void testNullArray() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = null;
        int result = algo.solution(nums);
        assertEquals(0, result, "null数组无法构成三角形, 返回0");
    }

    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("测试边界条件: 空数组")
    void testEmptyArray() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = {};
        int result = algo.solution(nums);
        assertEquals(0, result, "空数组无法构成三角形, 返回0");
    }

    /**
     * 测试边界条件: 数组长度小于3
     */
    @Test
    @DisplayName("测试边界条件: 数组长度小于3")
    void testArrayLengthLessThanThree() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 1, 2 };
        int result = algo.solution(nums);
        assertEquals(0, result, "数组长度小于3, 无法构成三角形, 返回0");
    }

    /**
     * 测试边界条件: 只有一个元素
     */
    @Test
    @DisplayName("测试边界条件: 只有一个元素")
    void testSingleElement() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 5 };
        int result = algo.solution(nums);
        assertEquals(0, result, "只有一个元素, 无法构成三角形, 返回0");
    }

    /**
     * 测试边界条件: 正好3个元素能构成三角形
     */
    @Test
    @DisplayName("测试边界条件: 正好3个元素能构成三角形")
    void testExactlyThreeElementsCanForm() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 3, 4, 5 };
        int result = algo.solution(nums);
        assertEquals(12, result, "数组 [3,4,5] 可以构成周长为12的三角形(直角三角形)");
    }

    /**
     * 测试边界条件: 正好3个元素不能构成三角形
     */
    @Test
    @DisplayName("测试边界条件: 正好3个元素不能构成三角形")
    void testExactlyThreeElementsCannotForm() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 1, 2, 4 };
        int result = algo.solution(nums);
        assertEquals(0, result, "数组 [1,2,4] 无法构成三角形,1+2不大于4");
    }

    /**
     * 测试特殊情况: 所有元素相同且能构成三角形
     */
    @Test
    @DisplayName("测试特殊情况: 所有元素相同且能构成三角形")
    void testAllSameElementsCanForm() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 5, 5, 5, 5 };
        int result = algo.solution(nums);
        assertEquals(15, result, "所有元素为5, 可以构成周长为15的等边三角形");
    }

    /**
     * 测试特殊情况: 所有元素相同但不能构成三角形
     */
    @Test
    @DisplayName("测试特殊情况: 所有元素相同但不能构成三角形")
    void testAllSameElementsCannotForm() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 1, 1, 1 };
        int result = algo.solution(nums);
        assertEquals(3, result, "所有元素为1,1+1>1, 可以构成周长为3的等边三角形");
    }

    /**
     * 测试特殊情况: 已排序的升序数组
     */
    @Test
    @DisplayName("测试特殊情况: 已排序的升序数组")
    void testAlreadySortedAscending() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 1, 2, 3, 4, 5 };
        int result = algo.solution(nums);
        assertEquals(12, result, "升序数组 [1,2,3,4,5], 最大周长三角形的周长为12(3,4,5)");
    }

    /**
     * 测试特殊情况: 已排序的降序数组
     */
    @Test
    @DisplayName("测试特殊情况: 已排序的降序数组")
    void testAlreadySortedDescending() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 5, 4, 3, 2, 1 };
        int result = algo.solution(nums);
        assertEquals(12, result, "降序数组 [5,4,3,2,1], 最大周长三角形的周长为12(3,4,5)");
    }

    /**
     * 测试复杂场景: 多个可能解, 取最大周长
     */
    @Test
    @DisplayName("测试复杂场景: 多个可能解取最大周长")
    void testMultipleSolutionsTakeMaximum() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 2, 3, 4, 5, 10 };
        int result = algo.solution(nums);
        assertEquals(12, result, "数组 [2,3,4,5,10], 最大周长为12(3,4,5),10无法与其他边构成三角形");
    }

    /**
     * 测试复杂场景: 较大的数组, 需要跳过某些元素
     */
    @Test
    @DisplayName("测试复杂场景: 需要跳过某些元素找解")
    void testNeedToSkipSomeElements() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 1, 2, 1, 3, 4, 5 };
        int result = algo.solution(nums);
        assertEquals(12, result, "数组 [1,2,1,3,4,5], 最大周长为12(3,4,5)");
    }

    /**
     * 测试复杂场景: 长数组中最大周长在中间位置
     */
    @Test
    @DisplayName("测试复杂场景: 长数组中最大周长在中间位置")
    void testMaxPerimeterInMiddleOfLongArray() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 1, 2, 3, 10, 11, 12, 100 };
        int result = algo.solution(nums);
        assertEquals(33, result, "数组 [1,2,3,10,11,12,100], 最大周长为33(10,11,12)");
    }

    /**
     * 测试特殊情况: 包含0的数组
     */
    @Test
    @DisplayName("测试特殊情况: 包含0的数组")
    void testArrayContainsZero() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 0, 1, 2, 3 };
        int result = algo.solution(nums);
        assertEquals(0, result, "数组 [0,1,2,3],1+2不大于3, 无法构成三角形");
    }

    /**
     * 测试特殊情况: 包含多个0的数组
     */
    @Test
    @DisplayName("测试特殊情况: 包含多个0的数组")
    void testArrayContainsMultipleZeros() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 0, 0, 1, 2, 3 };
        int result = algo.solution(nums);
        assertEquals(0, result, "数组 [0,0,1,2,3],1+2不大于3, 无法构成三角形");
    }

    /**
     * 测试特殊情况: 只有两条边相同
     */
    @Test
    @DisplayName("测试特殊情况: 只有两条边相同")
    void testOnlyTwoSidesEqual() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 3, 3, 6, 7 };
        int result = algo.solution(nums);
        assertEquals(16, result, "数组 [3,3,6,7], 最大周长为16(3,6,7),3+3不大于6");
    }

    /**
     * 测试边界情况: 两条边之和等于第三边
     */
    @Test
    @DisplayName("测试边界情况: 两条边之和等于第三边")
    void testSumOfTwoEqualsThird() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 2, 3, 5, 6 };
        int result = algo.solution(nums);
        assertEquals(14, result, "数组 [2,3,5,6],2+3=5不构成三角形, 最大周长为14(3,5,6)");
    }

    /**
     * 测试复杂场景: 多条边接近但无法构成三角形
     */
    @Test
    @DisplayName("测试复杂场景: 多条边接近但无法构成三角形")
    void testManyCloseButCannotForm() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int result = algo.solution(nums);
        assertEquals(27, result, "连续整数数组, 最大周长为27(8,9,10)");
    }

    /**
     * 测试特殊情况: 重复元素构成的三角形
     */
    @Test
    @DisplayName("测试特殊情况: 重复元素构成三角形")
    void testDuplicateElementsCanForm() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 2, 2, 3, 4 };
        int result = algo.solution(nums);
        assertEquals(9, result, "数组 [2,2,3,4], 最大周长为9(2,3,4)");
    }

    /**
     * 测试边界情况: 最小可能的三角形
     */
    @Test
    @DisplayName("测试边界情况: 最小可能的三角形")
    void testSmallestPossibleTriangle() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 1, 1, 1 };
        int result = algo.solution(nums);
        assertEquals(3, result, "最小可能的三角形, 三条边都是1, 周长为3");
    }

    /**
     * 测试特殊情况: 等腰三角形
     */
    @Test
    @DisplayName("测试特殊情况: 等腰三角形")
    void testIsoscelesTriangle() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 3, 3, 5, 10 };
        int result = algo.solution(nums);
        assertEquals(11, result, "数组 [3,3,5,10], 最大周长为11的等腰三角形(3,3,5)");
    }

    /**
     * 测试特殊情况: 等边三角形
     */
    @Test
    @DisplayName("测试特殊情况: 等边三角形")
    void testEquilateralTriangle() {
        Algo027MaxPerimeterTriangle algo = new Algo027MaxPerimeterTriangle();
        int[] nums = { 4, 4, 4, 5 };
        int result = algo.solution(nums);
        assertEquals(13, result, "数组 [4,4,4,5], 最大周长为13的三角形(4,4,5), 算法优先选择更大的边");
    }
}
