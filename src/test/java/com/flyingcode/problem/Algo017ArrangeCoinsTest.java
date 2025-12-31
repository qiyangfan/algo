package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo017ArrangeCoins
 * 使用 JUnit 5 测试排列硬币(迭代)算法的正确性
 */
class Algo017ArrangeCoinsTest {

    /**
     * 测试基本功能: 标准输入
     */
    @Test
    @DisplayName("测试基本功能: 标准输入")
    void testStandardInput() {
        Algo017ArrangeCoins algo = new Algo017ArrangeCoins();
        assertEquals(2, algo.solution(5));
        assertEquals(3, algo.solution(8));
    }

    /**
     * 测试边界条件:0和1
     */
    @Test
    @DisplayName("测试边界条件:0和1")
    void testBoundaryConditions() {
        Algo017ArrangeCoins algo = new Algo017ArrangeCoins();
        assertEquals(0, algo.solution(0));
        assertEquals(1, algo.solution(1));
        assertEquals(1, algo.solution(2));
    }

    /**
     * 测试大数
     */
    @Test
    @DisplayName("测试大数")
    void testLargeNumbers() {
        Algo017ArrangeCoins algo = new Algo017ArrangeCoins();
        assertEquals(5, algo.solution(15));
        assertEquals(6, algo.solution(21));
    }

    /**
     * 测试完全三角形数
     */
    @Test
    @DisplayName("测试完全三角形数")
    void testPerfectTriangleNumbers() {
        Algo017ArrangeCoins algo = new Algo017ArrangeCoins();
        // T(n) = n*(n+1)/2
        // T(1)=1, T(2)=3, T(3)=6, T(4)=10, T(5)=15
        assertEquals(1, algo.solution(1));
        assertEquals(2, algo.solution(3));
        assertEquals(3, algo.solution(6));
        assertEquals(4, algo.solution(10));
        assertEquals(5, algo.solution(15));
    }

    /**
     * 测试非完全三角形数
     */
    @Test
    @DisplayName("测试非完全三角形数")
    void testNonPerfectTriangleNumbers() {
        Algo017ArrangeCoins algo = new Algo017ArrangeCoins();
        assertEquals(2, algo.solution(4));
        assertEquals(2, algo.solution(5));
        assertEquals(3, algo.solution(7));
    }
}
