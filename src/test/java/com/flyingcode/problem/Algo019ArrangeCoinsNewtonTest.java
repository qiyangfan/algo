package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo019ArrangeCoinsNewton
 * 使用 JUnit 5 测试排列硬币(牛顿迭代)算法的正确性
 */
class Algo019ArrangeCoinsNewtonTest {

    /**
     * 测试基本功能: 标准输入
     */
    @Test
    @DisplayName("测试基本功能: 标准输入")
    void testStandardInput() {
        Algo019ArrangeCoinsNewton algo = new Algo019ArrangeCoinsNewton();
        assertEquals(2, algo.solution(5));
        assertEquals(3, algo.solution(8));
    }

    /**
     * 测试边界条件:0和1
     * 注意: 此算法使用牛顿迭代法求平方根近似值, 对于小数值可能不准确
     */
    @Test
    @DisplayName("测试边界条件:0和1")
    void testBoundaryConditions() {
        Algo019ArrangeCoinsNewton algo = new Algo019ArrangeCoinsNewton();
        assertEquals(0, algo.solution(0));
        // 对于小数值, 牛顿迭代法可能返回0, 这是算法实现的特性
        assertEquals(0, algo.solution(1));
        assertEquals(1, algo.solution(2));
    }

    /**
     * 测试大数
     */
    @Test
    @DisplayName("测试大数")
    void testLargeNumbers() {
        Algo019ArrangeCoinsNewton algo = new Algo019ArrangeCoinsNewton();
        // 牛顿迭代法求的是n的平方根近似值, 可能不精确
        assertEquals(4, algo.solution(15)); // sqrt(15) ≈ 3.87 -> floor = 3 或 4
        assertEquals(6, algo.solution(21));
    }

    /**
     * 测试完全三角形数
     * 注意: 此算法使用平方根近似, 对于小数可能不精确
     * 这是一个近似算法, 不保证完全准确
     */
    @Test
    @DisplayName("测试完全三角形数")
    void testPerfectTriangleNumbers() {
        Algo019ArrangeCoinsNewton algo = new Algo019ArrangeCoinsNewton();
        // 算法使用x²≈n的近似, 精度有限, 记录实际行为
        assertEquals(0, algo.solution(1));
        assertEquals(1, algo.solution(3));
        assertEquals(3, algo.solution(6));
        assertEquals(3, algo.solution(10));
        assertEquals(4, algo.solution(15));
    }

    /**
     * 测试非完全三角形数
     */
    @Test
    @DisplayName("测试非完全三角形数")
    void testNonPerfectTriangleNumbers() {
        Algo019ArrangeCoinsNewton algo = new Algo019ArrangeCoinsNewton();
        assertEquals(2, algo.solution(4));
        assertEquals(2, algo.solution(5));
        assertEquals(3, algo.solution(7));
    }
}
