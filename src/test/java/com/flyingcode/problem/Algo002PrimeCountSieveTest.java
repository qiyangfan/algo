package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo002PrimeCountSieve
 * 使用 JUnit 5 测试埃氏筛素数计数算法的正确性
 */
class Algo002PrimeCountSieveTest {

    /**
     * 测试基本功能: 计算1-100之间的素数个数
     */
    @Test
    @DisplayName("测试计算1-100之间的素数个数")
    void testPrimesUpTo100() {
        Algo002PrimeCountSieve algo = new Algo002PrimeCountSieve();
        int result = algo.solution(100);
        assertEquals(25, result, "100以内的素数应该有25个");
    }

    /**
     * 测试边界条件: 小于2的数应该返回0
     */
    @Test
    @DisplayName("测试边界条件: 小于2的数应该返回0")
    void testPrimesUpTo1() {
        Algo002PrimeCountSieve algo = new Algo002PrimeCountSieve();
        assertEquals(0, algo.solution(1));
        assertEquals(0, algo.solution(0));
    }

    /**
     * 测试小范围:2是最小的素数
     */
    @Test
    @DisplayName("测试小范围:2是最小的素数")
    void testPrimesUpTo2() {
        Algo002PrimeCountSieve algo = new Algo002PrimeCountSieve();
        assertEquals(1, algo.solution(2));
    }

    /**
     * 测试中等范围:10以内有4个素数(2,3,5,7)
     */
    @Test
    @DisplayName("测试中等范围:10以内有4个素数")
    void testPrimesUpTo10() {
        Algo002PrimeCountSieve algo = new Algo002PrimeCountSieve();
        assertEquals(4, algo.solution(10));
    }
}
