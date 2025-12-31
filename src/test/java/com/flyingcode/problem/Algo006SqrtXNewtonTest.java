package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo006SqrtXNewton
 * 使用 JUnit 5 测试牛顿迭代法平方根算法的正确性
 */
class Algo006SqrtXNewtonTest {

    /**
     * 测试基本功能: 标准输入
     */
    @Test
    @DisplayName("测试基本功能: 标准输入")
    void testStandardInput() {
        Algo006SqrtXNewton algo = new Algo006SqrtXNewton();
        assertEquals(2, algo.solution(4));
        assertEquals(2, algo.solution(8));
    }

    /**
     * 测试边界条件:0和1
     */
    @Test
    @DisplayName("测试边界条件:0和1")
    void testBoundaryConditions() {
        Algo006SqrtXNewton algo = new Algo006SqrtXNewton();
        assertEquals(0, algo.solution(0));
        assertEquals(1, algo.solution(1));
    }

    /**
     * 测试大数
     */
    @Test
    @DisplayName("测试大数")
    void testLargeNumbers() {
        Algo006SqrtXNewton algo = new Algo006SqrtXNewton();
        assertEquals(46340, algo.solution(2147395600));
    }

    /**
     * 测试非完全平方数
     */
    @Test
    @DisplayName("测试非完全平方数")
    void testNonPerfectSquares() {
        Algo006SqrtXNewton algo = new Algo006SqrtXNewton();
        assertEquals(3, algo.solution(10));
        assertEquals(4, algo.solution(20));
        assertEquals(5, algo.solution(35));
    }

    /**
     * 测试完全平方数
     */
    @Test
    @DisplayName("测试完全平方数")
    void testPerfectSquares() {
        Algo006SqrtXNewton algo = new Algo006SqrtXNewton();
        assertEquals(3, algo.solution(9));
        assertEquals(4, algo.solution(16));
        assertEquals(5, algo.solution(25));
        assertEquals(10, algo.solution(100));
    }

    /**
     * 测试小整数
     */
    @Test
    @DisplayName("测试小整数")
    void testSmallIntegers() {
        Algo006SqrtXNewton algo = new Algo006SqrtXNewton();
        assertEquals(1, algo.solution(2));
        assertEquals(1, algo.solution(3));
    }
}
