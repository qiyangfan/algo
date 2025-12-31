package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo005SqrtX
 * 使用 JUnit 5 测试二分查找平方根算法的正确性
 */
class Algo005SqrtXTest {

    /**
     * 测试基本功能: 标准输入
     */
    @Test
    @DisplayName("测试基本功能: 标准输入")
    void testStandardInput() {
        Algo005SqrtX algo = new Algo005SqrtX();
        assertEquals(2, algo.solution(4));
        assertEquals(2, algo.solution(8));
    }

    /**
     * 测试边界条件:0和1
     */
    @Test
    @DisplayName("测试边界条件:0和1")
    void testBoundaryConditions() {
        Algo005SqrtX algo = new Algo005SqrtX();
        assertEquals(0, algo.solution(0));
        assertEquals(1, algo.solution(1));
    }

    /**
     * 测试大数
     */
    @Test
    @DisplayName("测试大数")
    void testLargeNumbers() {
        Algo005SqrtX algo = new Algo005SqrtX();
        assertEquals(46340, algo.solution(2147395600));
    }

    /**
     * 测试非完全平方数
     */
    @Test
    @DisplayName("测试非完全平方数")
    void testNonPerfectSquares() {
        Algo005SqrtX algo = new Algo005SqrtX();
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
        Algo005SqrtX algo = new Algo005SqrtX();
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
        Algo005SqrtX algo = new Algo005SqrtX();
        assertEquals(1, algo.solution(2));
        assertEquals(1, algo.solution(3));
    }
}
