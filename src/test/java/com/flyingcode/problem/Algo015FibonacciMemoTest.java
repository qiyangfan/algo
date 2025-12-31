package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo015FibonacciMemo
 * 使用 JUnit 5 测试斐波那契数列(去重递归)算法的正确性
 */
class Algo015FibonacciMemoTest {

    /**
     * 测试基本功能: 标准输入
     */
    @Test
    @DisplayName("测试基本功能: 标准输入")
    void testStandardInput() {
        Algo015FibonacciMemo algo = new Algo015FibonacciMemo();
        assertEquals(1, algo.solution(2));
        assertEquals(2, algo.solution(3));
        assertEquals(3, algo.solution(4));
        assertEquals(5, algo.solution(5));
    }

    /**
     * 测试边界条件:0和1
     */
    @Test
    @DisplayName("测试边界条件:0和1")
    void testBoundaryConditions() {
        Algo015FibonacciMemo algo = new Algo015FibonacciMemo();
        assertEquals(0, algo.solution(0));
        assertEquals(1, algo.solution(1));
    }

    /**
     * 测试更大的斐波那契数
     */
    @Test
    @DisplayName("测试更大的斐波那契数")
    void testLargerFibonacci() {
        Algo015FibonacciMemo algo = new Algo015FibonacciMemo();
        assertEquals(8, algo.solution(6));
        assertEquals(13, algo.solution(7));
        assertEquals(21, algo.solution(8));
    }

    /**
     * 测试前几个斐波那契数列
     */
    @Test
    @DisplayName("测试前几个斐波那契数列")
    void testFibonacciSequence() {
        Algo015FibonacciMemo algo = new Algo015FibonacciMemo();
        assertEquals(0, algo.solution(0));
        assertEquals(1, algo.solution(1));
        assertEquals(1, algo.solution(2));
        assertEquals(2, algo.solution(3));
        assertEquals(3, algo.solution(4));
        assertEquals(5, algo.solution(5));
    }
}
