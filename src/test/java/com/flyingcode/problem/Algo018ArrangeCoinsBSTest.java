package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo018ArrangeCoinsBS
 * 使用 JUnit 5 测试排列硬币(二分查找)算法的正确性
 */
class Algo018ArrangeCoinsBSTest {

    /**
     * 测试基本功能: 标准输入
     */
    @Test
    @DisplayName("测试基本功能: 标准输入")
    void testStandardInput() {
        Algo018ArrangeCoinsBS algo = new Algo018ArrangeCoinsBS();
        assertEquals(2, algo.solution(5));
        assertEquals(3, algo.solution(8));
    }

    /**
     * 测试边界条件:0和1
     */
    @Test
    @DisplayName("测试边界条件:0和1")
    void testBoundaryConditions() {
        Algo018ArrangeCoinsBS algo = new Algo018ArrangeCoinsBS();
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
        Algo018ArrangeCoinsBS algo = new Algo018ArrangeCoinsBS();
        assertEquals(5, algo.solution(15));
        assertEquals(6, algo.solution(21));
    }

    /**
     * 测试完全三角形数
     */
    @Test
    @DisplayName("测试完全三角形数")
    void testPerfectTriangleNumbers() {
        Algo018ArrangeCoinsBS algo = new Algo018ArrangeCoinsBS();
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
        Algo018ArrangeCoinsBS algo = new Algo018ArrangeCoinsBS();
        assertEquals(2, algo.solution(4));
        assertEquals(2, algo.solution(5));
        assertEquals(3, algo.solution(7));
    }
}
