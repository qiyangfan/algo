package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Class: Algo040AdvantageShuffleGreedy
 * Uses JUnit 5 to test the correctness of the Advantage Shuffle greedy
 * algorithm
 */
class Algo040AdvantageShuffleGreedyTest {

    /**
     * 测试基本功能: LeetCode示例输入
     */
    @Test
    @DisplayName("Test basic functionality: LeetCode example 1")
    void testLeetCodeExample1() {
        // Arrange: 准备测试数据
        Algo040AdvantageShuffleGreedy algo = new Algo040AdvantageShuffleGreedy();
        int[] A = { 2, 7, 11, 15 };
        int[] B = { 1, 10, 4, 11 };
        int[] expected = { 2, 11, 7, 15 };

        // Act: 执行测试方法
        int[] result = algo.solution(A, B);

        // Assert: 验证结果
        assertArrayEquals(expected, result, "Expected [2,11,7,15] for input A=[2,7,11,15], B=[1,10,4,11]");
    }

    /**
     * 测试基本功能: LeetCode示例输入2
     */
    @Test
    @DisplayName("Test basic functionality: LeetCode example 2")
    void testLeetCodeExample2() {
        // Arrange: 准备测试数据
        Algo040AdvantageShuffleGreedy algo = new Algo040AdvantageShuffleGreedy();
        int[] A = { 12, 24, 8, 32 };
        int[] B = { 13, 25, 32, 11 };
        int[] expected = { 24, 32, 8, 12 };

        // Act: 执行测试方法
        int[] result = algo.solution(A, B);

        // Assert: 验证结果
        assertArrayEquals(expected, result, "Expected [24,32,8,12] for input A=[12,24,8,32], B=[13,25,32,11]");
    }

    /**
     * 测试边界条件: 空数组
     */
    @Test
    @DisplayName("Test boundary condition: empty arrays")
    void testEmptyArrays() {
        // Arrange: 准备测试数据
        Algo040AdvantageShuffleGreedy algo = new Algo040AdvantageShuffleGreedy();
        int[] A = {};
        int[] B = {};
        int[] expected = {};

        // Act: 执行测试方法
        int[] result = algo.solution(A, B);

        // Assert: 验证结果
        assertArrayEquals(expected, result, "Empty arrays should return empty result");
    }

    /**
     * 测试边界条件: 单元素数组
     */
    @Test
    @DisplayName("Test boundary condition: single element arrays")
    void testSingleElementArrays() {
        // Arrange: 准备测试数据
        Algo040AdvantageShuffleGreedy algo = new Algo040AdvantageShuffleGreedy();
        int[] A = { 5 };
        int[] B = { 3 };
        int[] expected = { 5 };

        // Act: 执行测试方法
        int[] result = algo.solution(A, B);

        // Assert: 验证结果
        assertArrayEquals(expected, result, "Single element array A[5] should win against B[3]");
    }

    /**
     * 测试特殊情况: 所有元素相同
     */
    @Test
    @DisplayName("Test special case: all elements identical")
    void testAllSameElements() {
        // Arrange: 准备测试数据
        Algo040AdvantageShuffleGreedy algo = new Algo040AdvantageShuffleGreedy();
        int[] A = { 2, 2, 2 };
        int[] B = { 2, 2, 2 };
        int[] expected = { 2, 2, 2 };

        // Act: 执行测试方法
        int[] result = algo.solution(A, B);

        // Assert: 验证结果
        assertArrayEquals(expected, result, "All identical elements should return same array");
    }

    /**
     * 测试特殊情况: A数组完全小于B数组
     */
    @Test
    @DisplayName("Test special case: A array completely smaller than B array")
    void testAArraySmallerThanBArray() {
        // Arrange: 准备测试数据
        Algo040AdvantageShuffleGreedy algo = new Algo040AdvantageShuffleGreedy();
        int[] A = { 1, 2, 3 };
        int[] B = { 4, 5, 6 };

        // Act: 执行测试方法
        int[] result = algo.solution(A, B);

        // Assert: 验证结果 - 检查A数组元素是否正确分配, 且A[i] > B[i]的次数最大化
        // 由于A数组完全小于B数组, A[i] > B[i]的次数应为0
        int advantageCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (result[i] > B[i]) {
                advantageCount++;
            }
        }

        // 验证结果数组包含A数组的所有元素
        int[] sortedResult = result.clone();
        int[] sortedA = A.clone();
        java.util.Arrays.sort(sortedResult);
        java.util.Arrays.sort(sortedA);
        assertArrayEquals(sortedA, sortedResult, "Result array should contain all elements of A");

        // 验证A[i] > B[i]的次数为0
        // 因为A数组中的所有元素都小于B数组中的对应元素
        assert advantageCount == 0
                : "Expected 0 advantage counts when A is completely smaller than B, but got " + advantageCount;
    }

    /**
     * 测试复杂场景: 包含多个重复元素
     */
    @Test
    @DisplayName("Test complex scenario: multiple duplicate elements")
    void testMultipleDuplicateElements() {
        // Arrange: 准备测试数据
        Algo040AdvantageShuffleGreedy algo = new Algo040AdvantageShuffleGreedy();
        int[] A = { 3, 3, 5, 5, 7, 7 };
        int[] B = { 4, 4, 5, 5, 6, 6 };

        // Act: 执行测试方法
        int[] result = algo.solution(A, B);

        // Assert: 验证结果 - 检查A[i] > B[i]的次数最大化
        // 预期最大优势次数: 4次
        // 5>4, 5>4, 7>5, 7>5, 3<6, 3<6 或者其他排列方式
        int advantageCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (result[i] > B[i]) {
                advantageCount++;
            }
        }

        // 验证结果数组包含A数组的所有元素
        int[] sortedResult = result.clone();
        int[] sortedA = A.clone();
        java.util.Arrays.sort(sortedResult);
        java.util.Arrays.sort(sortedA);
        assertArrayEquals(sortedA, sortedResult, "Result array should contain all elements of A");

        // 验证A[i] > B[i]的次数至少为4次
        // 因为算法应该最大化优势次数
        // 对于输入A=[3,3,5,5,7,7], B=[4,4,5,5,6,6], 最大优势次数为4
        assert advantageCount >= 4 : "Expected at least 4 advantage counts, but got " + advantageCount;
    }

    /**
     * 测试特殊情况: A数组元素已经是最优排列
     */
    @Test
    @DisplayName("Test special case: A array already optimal")
    void testAlreadyOptimalArray() {
        // Arrange: 准备测试数据
        Algo040AdvantageShuffleGreedy algo = new Algo040AdvantageShuffleGreedy();
        int[] A = { 1, 3, 5, 7 };
        int[] B = { 2, 4, 6, 8 };
        int[] expected = { 3, 5, 7, 1 };

        // Act: 执行测试方法
        int[] result = algo.solution(A, B);

        // Assert: 验证结果
        assertArrayEquals(expected, result, "Already optimal array should return same optimal arrangement");
    }
}
