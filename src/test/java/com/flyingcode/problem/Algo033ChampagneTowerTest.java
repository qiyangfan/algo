package com.flyingcode.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 测试类: Algo033ChampagneTower
 * 使用 JUnit 5 测试香槟塔算法的正确性
 */
class Algo033ChampagneTowerTest {

    /**
     * 测试基本功能: 倒入1杯香槟, 查询顶层杯子
     */
    @Test
    @DisplayName("测试基本功能: 倒入1杯香槟, 查询顶层杯子")
    void testBasicFunctionalityOnePour() {
        Algo033ChampagneTower algo = new Algo033ChampagneTower();
        int poured = 1;
        int queryRow = 0;
        int queryGlass = 0;
        double result = algo.champagneTower(poured, queryRow, queryGlass);
        assertEquals(1.0, result, 1e-6, "倒入1杯香槟时, 顶层杯子应满杯(1.0)");
    }

    /**
     * 测试基本功能: 倒入2杯香槟, 查询第1行第0个杯子
     */
    @Test
    @DisplayName("测试基本功能: 倒入2杯香槟, 查询第1行第0个杯子")
    void testBasicFunctionalityTwoPours() {
        Algo033ChampagneTower algo = new Algo033ChampagneTower();
        int poured = 2;
        int queryRow = 1;
        int queryGlass = 0;
        double result = algo.champagneTower(poured, queryRow, queryGlass);
        assertEquals(0.5, result, 1e-6, "倒入2杯香槟时, 第1行第0个杯子应含0.5单位香槟");
    }

    /**
     * 测试边界条件: 倒入0杯香槟
     */
    @Test
    @DisplayName("测试边界条件: 倒入0杯香槟")
    void testBoundaryConditionZeroPour() {
        Algo033ChampagneTower algo = new Algo033ChampagneTower();
        int poured = 0;
        int queryRow = 0;
        int queryGlass = 0;
        double result = algo.champagneTower(poured, queryRow, queryGlass);
        assertEquals(0.0, result, 1e-6, "倒入0杯香槟时, 任何杯子应为空(0.0)");
    }

    /**
     * 测试特殊情况: 倒入大量香槟, 杯子应满杯
     */
    @Test
    @DisplayName("测试特殊情况: 倒入大量香槟, 杯子应满杯")
    void testSpecialCaseLargePour() {
        Algo033ChampagneTower algo = new Algo033ChampagneTower();
        int poured = 100000009;
        int queryRow = 33;
        int queryGlass = 17;
        double result = algo.champagneTower(poured, queryRow, queryGlass);
        assertEquals(1.0, result, 1e-6, "倒入大量香槟时, 指定位置杯子应满杯(1.0)");
    }

    /**
     * 测试特殊情况: 倒入3杯香槟, 查询第2行第1个杯子
     */
    @Test
    @DisplayName("测试特殊情况: 倒入3杯香槟, 查询第2行第1个杯子")
    void testSpecialCaseThreePours() {
        Algo033ChampagneTower algo = new Algo033ChampagneTower();
        int poured = 3;
        int queryRow = 2;
        int queryGlass = 1;
        double result = algo.champagneTower(poured, queryRow, queryGlass);
        assertEquals(0.0, result, 1e-6, "倒入3杯香槟时, 第2行第1个杯子应为空(0.0)");
    }

    /**
     * 测试特殊情况: 倒入4杯香槟, 查询第2行第1个杯子
     */
    @Test
    @DisplayName("测试特殊情况: 倒入4杯香槟, 查询第2行第1个杯子")
    void testSpecialCaseFourPours() {
        Algo033ChampagneTower algo = new Algo033ChampagneTower();
        int poured = 4;
        int queryRow = 2;
        int queryGlass = 1;
        double result = algo.champagneTower(poured, queryRow, queryGlass);
        assertEquals(0.5, result, 1e-6, "倒入4杯香槟时, 第2行第1个杯子应含0.5单位香槟");
    }

    /**
     * 测试边界条件: 查询当前行的边界杯子
     */
    @Test
    @DisplayName("测试边界条件: 查询当前行的边界杯子")
    void testBoundaryConditionEdgeGlass() {
        Algo033ChampagneTower algo = new Algo033ChampagneTower();
        int poured = 8;
        int queryRow = 2;
        int queryGlass = 2;
        double result = algo.champagneTower(poured, queryRow, queryGlass);
        assertEquals(1.0, result, 1e-6, "倒入8杯香槟时, 第2行第2个杯子应满杯(1.0)");
    }

    /**
     * 测试复杂情况: 多层香槟塔分布
     */
    @Test
    @DisplayName("测试复杂情况: 多层香槟塔分布")
    void testComplexCaseMultiLayer() {
        Algo033ChampagneTower algo = new Algo033ChampagneTower();
        int poured = 10;
        int queryRow = 3;
        int queryGlass = 1;
        double result = algo.champagneTower(poured, queryRow, queryGlass);
        assertEquals(1.0, result, 1e-6, "多层香槟塔分布时, 指定位置杯子应满杯(1.0)");
    }
}
